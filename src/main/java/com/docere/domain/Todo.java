package com.docere.domain;

/**
 * Represents a Todo item in the application.
 * This class encapsulates the data for a single todo item including its
 * unique identifier, title, description, and completion status.
 *
 * @author Naveen Kumar
 * @version 1.0
 * @since 2025-08-26
 */
public class Todo {
    private String id;
    private String title;
    private String description;
    private boolean completed;

    /**
     * Constructs a new Todo item with the specified parameters.
     *
     * @param id          The unique identifier for the todo item
     * @param title       The title of the todo item
     * @param description The detailed description of the todo item
     */
    public Todo(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    /**
     * Gets the unique identifier of the todo item.
     *
     * @return The todo item's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the title of the todo item.
     *
     * @return The todo item's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the todo item.
     *
     * @param title The new title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the todo item.
     *
     * @return The todo item's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the todo item.
     *
     * @param description The new description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Checks if the todo item is completed.
     *
     * @return true if the todo is completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the completion status of the todo item.
     *
     * @param completed The new completion status to set
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
