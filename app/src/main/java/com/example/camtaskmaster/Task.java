package com.example.camtaskmaster;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String details;
    private String status;

    public Task(String title, String details) {
        this.title = title;
        this.details = details;
        this.status = "pending";  // Default status
    }

    // getter and setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }
}
