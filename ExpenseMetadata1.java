package com.workattech.splitwise.models.expense1;

public class ExpenseMetadata1 {
    private String name;
    private String imageUrl;
    private String notes;

    public ExpenseMetadata(String name, String imageUrl, String notes) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imageUrl;
    }

    public void setImgUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
