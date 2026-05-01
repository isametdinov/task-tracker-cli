package com.tasktracker;

import com.tasktracker.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * This class handles reading and writing tasks to a JSON file.
 * No external libraries are used, so JSON is handled manually.
 */
public class FileHandler {

    private static final String FILE_NAME = "tasks.json";

    /*
     * Loads tasks from JSON file into memory
     */
    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);

        try {
            // If file does not exist, create it
            if (!file.exists()) {
                file.createNewFile();
                writeEmptyArray();
                return tasks;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder json = new StringBuilder();
            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {
                json.append(line.trim());
            }
            reader.close();

            String content = json.toString();

            // If file is empty
            if (content.isEmpty() || content.equals("[]")) {
                return tasks;
            }

            // Remove outer brackets [ ]
            content = content.substring(1, content.length() - 1);

            // Split each task object
            String[] taskStrings = content.split("\\},\\{");

            for (String t : taskStrings) {
                t = t.replace("{", "").replace("}", "");

                String[] fields = t.split(",");

                int id = 0;
                String description = "";
                String status = "";
                String createdAt = "";
                String updatedAt = "";

                for (String field : fields) {
                    String[] keyValue = field.split(":", 2);

                    String key = keyValue[0].replace("\"", "").trim();
                    String value = keyValue[1].replace("\"", "").trim();

                    switch (key) {
                        case "id": id = Integer.parseInt(value); break;
                        case "description": description = value; break;
                        case "status": status = value; break;
                        case "createdAt": createdAt = value; break;
                        case "updatedAt": updatedAt = value; break;
                    }
                }

                tasks.add(new Task(id, description, status, createdAt, updatedAt));
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        return tasks;
    }

    /*
     * Saves tasks list into JSON file
     */
    public static void saveTasks(List<Task> tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            writer.write("[\n");

            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);

                writer.write("  {\n");
                writer.write("    \"id\": " + t.getId() + ",\n");
                writer.write("    \"description\": \"" + escape(t.getDescription()) + "\",\n");
                writer.write("    \"status\": \"" + t.getStatus() + "\",\n");
                writer.write("    \"createdAt\": \"" + t.getCreatedAt() + "\",\n");
                writer.write("    \"updatedAt\": \"" + t.getUpdatedAt() + "\"\n");
                writer.write("  }");

                if (i < tasks.size() - 1) writer.write(",");
                writer.write("\n");
            }

            writer.write("]");
            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    /*
     * Creates empty JSON array if file is new
     */
    private static void writeEmptyArray() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.write("[]");
        writer.close();
    }

    /*
     * Escapes quotes in text to prevent JSON breaking
     */
    private static String escape(String text) {
        return text.replace("\"", "\\\"");
    }
}