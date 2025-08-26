package com.docere;

import com.docere.domain.Todo;
import com.docere.service.TodoService;
import com.docere.service.TodoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for the TodoService implementation.
 * This class contains unit tests that verify the functionality of the TodoService
 * implementation, covering all CRUD operations and edge cases.
 *
 * @author Naveen Kumar
 * @version 1.0
 * @since 2025-08-26
 */
class TodoServiceTest {
    private TodoService todoService;

    /**
     * Set up method that runs before each test.
     * Initializes a new instance of TodoService for testing.
     */
    @BeforeEach
    void setUp() {
        todoService = new TodoServiceImpl();
    }

    /**
     * Test case for creating a todo with valid input.
     * Verifies that a todo is created successfully with the provided title and description.
     */
    @Test
    void createTodo_WithValidInput_ShouldCreateTodo() {
        // Given
        String title = "Test Todo";
        String description = "Test Description";

        // When
        Todo todo = todoService.createTodo(title, description);

        // Then
        assertNotNull(todo);
        assertEquals(title, todo.getTitle());
        assertEquals(description, todo.getDescription());
        assertFalse(todo.isCompleted());
    }

    /**
     * Test case for creating a todo with an empty title.
     * Verifies that an IllegalArgumentException is thrown when attempting to create
     * a todo with an empty title.
     */
    @Test
    void createTodo_WithEmptyTitle_ShouldThrowException() {
        // Given
        String title = "";
        String description = "Test Description";

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            todoService.createTodo(title, description);
        });
    }

    /**
     * Test case for retrieving all todos when todos exist in the system.
     * Verifies that all created todos are returned in the list.
     */
    @Test
    void getAllTodos_WhenTodosExist_ShouldReturnAllTodos() {
        // Given
        todoService.createTodo("Todo 1", "Description 1");
        todoService.createTodo("Todo 2", "Description 2");

        // When
        List<Todo> todos = todoService.getAllTodos();

        // Then
        assertEquals(2, todos.size());
    }

    /**
     * Test case for marking a todo as completed.
     * Verifies that a todo can be successfully marked as completed using its ID.
     */
    @Test
    void markTodoAsCompleted_WithValidId_ShouldMarkTodoAsCompleted() {
        // Given
        Todo todo = todoService.createTodo("Test Todo", "Test Description");

        // When
        boolean result = todoService.markTodoAsCompleted(todo.getId());

        // Then
        assertTrue(result);
        assertTrue(todoService.getTodoById(todo.getId()).get().isCompleted());
    }

    /**
     * Test case for deleting a todo.
     * Verifies that a todo can be successfully deleted using its ID.
     */
    @Test
    void deleteTodo_WithValidId_ShouldDeleteTodo() {
        // Given
        Todo todo = todoService.createTodo("Test Todo", "Test Description");

        // When
        boolean result = todoService.deleteTodo(todo.getId());

        // Then
        assertTrue(result);
        assertTrue(todoService.getTodoById(todo.getId()).isEmpty());
    }
}
