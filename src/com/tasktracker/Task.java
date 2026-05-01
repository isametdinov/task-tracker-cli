package com.tasktracker;

/*
This class represents a single task object.
It stores all required properties of a task.
 */

public class Task {

    // Unique ID of the task
    private int  id;

    // Description of the task
    private String description;

    //Status:todo/inprogress/done
    private String status;

    //Timestamp when task was created
    private String createdAt;

    //Timestamp when task was last updated
    private String updatedAt;

    /*
    Constructer is used to create a new Task object
     */

    public Task(int id, String description, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //===========GETTERS ===========//
    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }

    //===========SETTERS ===========//
    public void setDescription(String description){
        this.description = description;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
}