package com.example.camtaskmaster;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String details;

    public Task(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }
}
