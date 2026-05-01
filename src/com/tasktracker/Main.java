package com.tasktracker;

import com.tasktracker.TaskManager;

/*
 * Entry point of the application
 * Handles CLI input and calls TaskManager
 */
public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        // If no command is given
        if (args.length == 0) {
            printUsage();
            return;
        }

        String command = args[0];

        try {
            switch (command) {

                case "add":
                    manager.addTask(args[1]);
                    break;

                case "update":
                    manager.updateTask(Integer.parseInt(args[1]), args[2]);
                    break;

                case "delete":
                    manager.deleteTask(Integer.parseInt(args[1]));
                    break;

                case "mark-in-progress":
                    manager.markStatus(Integer.parseInt(args[1]), "in-progress");
                    break;

                case "mark-done":
                    manager.markStatus(Integer.parseInt(args[1]), "done");
                    break;

                case "list":
                    if (args.length == 2)
                        manager.listTasks(args[1]);
                    else
                        manager.listTasks(null);
                    break;

                default:
                    printUsage();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * Prints CLI usage instructions
     */
    private static void printUsage() {
        System.out.println("Commands:");
        System.out.println(" add \"task\"");
        System.out.println(" update <id> \"task\"");
        System.out.println(" delete <id>");
        System.out.println(" mark-in-progress <id>");
        System.out.println(" mark-done <id>");
        System.out.println(" list");
        System.out.println(" list done|todo|in-progress");
    }
}