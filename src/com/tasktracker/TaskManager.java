package com.tasktracker;

import com.tasktracker.Task;
import com.tasktracker.Utils;

import java.util.List;

/*
 * This class contains all business logic for task management
 */
public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        // Load tasks from file into memory
        tasks = FileHandler.loadTasks();
    }

    /*
     * Adds new task
     */
    public void addTask(String description) {
        int id = getNextId();

        Task task = new Task(
                id,
                description,
                "todo",
                Utils.getCurrentTime(),
                Utils.getCurrentTime()
        );

        tasks.add(task);
        FileHandler.saveTasks(tasks);

        System.out.println("Task added successfully (ID: " + id + ")");
    }

    /*
     * Updates task description
     */
    public void updateTask(int id, String description) {
        Task task = findTask(id);

        if (task == null) {
            System.out.println("Task not found");
            return;
        }

        task.setDescription(description);
        task.setUpdatedAt(Utils.getCurrentTime());

        FileHandler.saveTasks(tasks);
        System.out.println("Task updated successfully");
    }

    /*
     * Deletes a task
     */
    public void deleteTask(int id) {
        Task task = findTask(id);

        if (task == null) {
            System.out.println("Task not found");
            return;
        }

        tasks.remove(task);
        FileHandler.saveTasks(tasks);

        System.out.println("Task deleted successfully");
    }

    /*
     * Changes task status
     */
    public void markStatus(int id, String status) {
        Task task = findTask(id);

        if (task == null) {
            System.out.println("Task not found");
            return;
        }

        task.setStatus(status);
        task.setUpdatedAt(Utils.getCurrentTime());

        FileHandler.saveTasks(tasks);
        System.out.println("Task marked as " + status);
    }

    /*
     * Lists tasks (with optional filter)
     */
    public void listTasks(String status) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
            return;
        }

        for (Task t : tasks) {
            if (status == null || t.getStatus().equals(status)) {
                System.out.println("[" + t.getId() + "] " + t.getDescription() + " (" + t.getStatus() + ")");
            }
        }
    }

    // ---------- Helpers ----------

    private Task findTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    private int getNextId() {
        int max = 0;
        for (Task t : tasks) {
            if (t.getId() > max) max = t.getId();
        }
        return max + 1;
    }
}