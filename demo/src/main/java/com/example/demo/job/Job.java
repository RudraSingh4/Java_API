package com.example.demo.job;

public class Job {
    private Long id;
    private String title;
    private String description;

    private float minSallary;
    private float maxSallary;
    private String location;

    public Job(Long id, String title, String description, float minSallary, float maxSallary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSallary = minSallary;
        this.maxSallary = maxSallary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMinSallary() {
        return minSallary;
    }

    public void setMinSallary(float minSallary) {
        this.minSallary = minSallary;
    }

    public float getMaxSallary() {
        return maxSallary;
    }

    public void setMaxSallary(float maxSallary) {
        this.maxSallary = maxSallary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
