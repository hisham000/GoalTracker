package com.example.goaltracker;

public class TasksModel {
    String TaskName;
    String Description;
    String Importance;
    String DueDate;
    TasksModel PreReq;
    int color;


    public TasksModel(String taskName, String description, String importance, String dueDate, TasksModel preReq, int color) {
        TaskName = taskName;
        Description = description;
        Importance = importance;
        DueDate = dueDate;
        PreReq = preReq;
        this.color = color;
    }

    public String getTaskName() {
        return TaskName;
    }

    public String getDescription() {
        return Description;
    }

    public String getImportance() {
        return Importance;
    }

    public String getDueDate() {
        return DueDate;
    }

    public TasksModel getPreReq() {
        return PreReq;
    }

    public int getColor() {
        return color;
    }
}
