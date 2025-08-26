package com.docere.service;

import com.docere.domain.Todo;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Todo items.
 * This interface defines the contract for CRUD (Create, Read, Update, Delete) operations
 * on Todo items in the application.
 *
 * @author Naveen Kumar
 * @version 1.0
 * @since 2025-08-26
 */
public interface TodoService {
    /**
     * Creates a new Todo item with the given title and description.
     *
     * @param title       The title of the todo item (must not be empty)
     * @param description The description of the todo item
     * @return The newly created Todo item
     * @throws IllegalArgumentException if the title is empty or null
     */
    Todo createTodo(String title, String description);

    /**
     * Retrieves a Todo item by its ID.
     *
     * @param id The ID of the todo item to retrieve
     * @return An Optional containing the Todo item if found, empty otherwise
     */
    Optional<Todo> getTodoById(String id);

    /**
     * Retrieves all Todo items in the system.
     *
     * @return A list of all Todo items
     */
    List<Todo> getAllTodos();

    /**
     * Updates an existing Todo item with new title and description.
     *
     * @param id          The ID of the todo item to update
     * @param title       The new title (must not be empty)
     * @param description The new description
     * @return true if the todo was updated successfully, false if not found
     * @throws IllegalArgumentException if the title is empty or null
     */
    boolean updateTodo(String id, String title, String description);

    /**
     * Marks a Todo item as completed.
     *
     * @param id The ID of the todo item to mark as completed
     * @return true if the todo was marked as completed successfully, false if not found
     */
    boolean markTodoAsCompleted(String id);

    /**
     * Deletes a Todo item from the system.
     *
     * @param id The ID of the todo item to delete
     * @return true if the todo was deleted successfully, false if not found
     */
    boolean deleteTodo(String id);
}
