package com.docere.service;

import com.docere.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementation of the TodoService interface.
 * This class provides a thread-safe implementation of the TodoService interface
 * using ConcurrentHashMap for in-memory storage of Todo items.
 *
 * @author Naveen Kumar
 * @version 1.0
 * @since 2025-08-26
 * @see TodoService
 */
public class TodoServiceImpl implements TodoService {
    private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
    private final Map<String, Todo> todos;

    public TodoServiceImpl() {
        this.todos = new ConcurrentHashMap<>();
    }

    @Override
    public Todo createTodo(String title, String description) {
        logger.debug("Creating new todo with title: {}", title);
        
        if (title == null || title.trim().isEmpty()) {
            logger.error("Failed to create todo: Title cannot be empty");
            throw new IllegalArgumentException("Title cannot be empty");
        }

        String id = UUID.randomUUID().toString();
        Todo todo = new Todo(id, title, description);
        todos.put(id, todo);
        
        logger.info("Successfully created todo with id: {}", id);
        return todo;
    }

    @Override
    public Optional<Todo> getTodoById(String id) {
        logger.debug("Fetching todo with id: {}", id);
        Todo todo = todos.get(id);
        
        if (todo == null) {
            logger.info("No todo found with id: {}", id);
            return Optional.empty();
        }
        
        logger.debug("Found todo: {}", todo);
        return Optional.of(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        logger.debug("Fetching all todos");
        List<Todo> todoList = new ArrayList<>(todos.values());
        logger.info("Retrieved {} todos", todoList.size());
        return todoList;
    }

    @Override
    public boolean updateTodo(String id, String title, String description) {
        logger.debug("Updating todo with id: {}", id);
        
        if (title == null || title.trim().isEmpty()) {
            logger.error("Failed to update todo: Title cannot be empty");
            throw new IllegalArgumentException("Title cannot be empty");
        }

        Todo todo = todos.get(id);
        if (todo == null) {
            logger.info("No todo found with id: {}", id);
            return false;
        }

        todo.setTitle(title);
        todo.setDescription(description);
        logger.info("Successfully updated todo with id: {}", id);
        return true;
    }

    @Override
    public boolean markTodoAsCompleted(String id) {
        logger.debug("Marking todo as completed with id: {}", id);
        
        Todo todo = todos.get(id);
        if (todo == null) {
            logger.info("No todo found with id: {}", id);
            return false;
        }

        todo.setCompleted(true);
        logger.info("Successfully marked todo as completed with id: {}", id);
        return true;
    }

    @Override
    public boolean deleteTodo(String id) {
        logger.debug("Deleting todo with id: {}", id);
        
        if (todos.remove(id) == null) {
            logger.info("No todo found with id: {}", id);
            return false;
        }
        
        logger.info("Successfully deleted todo with id: {}", id);
        return true;
    }
}
