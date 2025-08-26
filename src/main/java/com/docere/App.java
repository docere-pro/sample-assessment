package com.docere;

import com.docere.service.TodoService;
import com.docere.service.TodoServiceImpl;
import com.docere.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Main application class for the Todo List CLI application.
 * This class provides a command-line interface for interacting with the Todo List system.
 * It allows users to create, read, update, and delete todo items through a menu-driven interface.
 *
 * @author Naveen Kumar
 * @version 1.0
 * @since 2025-08-26
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final TodoService todoService = new TodoServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Main entry point of the application.
     * Displays a menu-driven interface for user interaction with the Todo List system.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> createTodo();
                case 2 -> listTodos();
                case 3 -> getTodoById();
                case 4 -> updateTodo();
                case 5 -> markTodoAsCompleted();
                case 6 -> deleteTodo();
                case 7 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Todo List Application ===");
        System.out.println("1. Create new todo");
        System.out.println("2. List all todos");
        System.out.println("3. Get todo by ID");
        System.out.println("4. Update todo");
        System.out.println("5. Mark todo as completed");
        System.out.println("6. Delete todo");
        System.out.println("7. Exit");
    }

    private static void createTodo() {
        System.out.println("\n=== Create New Todo ===");
        String title = getStringInput("Enter title: ");
        String description = getStringInput("Enter description: ");

        try {
            Todo todo = todoService.createTodo(title, description);
            System.out.println("Todo created successfully with ID: " + todo.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listTodos() {
        System.out.println("\n=== All Todos ===");
        List<Todo> todos = todoService.getAllTodos();
        if (todos.isEmpty()) {
            System.out.println("No todos found.");
            return;
        }

        todos.forEach(todo -> {
            System.out.println("\nID: " + todo.getId());
            System.out.println("Title: " + todo.getTitle());
            System.out.println("Description: " + todo.getDescription());
            System.out.println("Status: " + (todo.isCompleted() ? "Completed" : "Pending"));
        });
    }

    private static void getTodoById() {
        System.out.println("\n=== Get Todo by ID ===");
        String id = getStringInput("Enter todo ID: ");

        todoService.getTodoById(id).ifPresentOrElse(
            todo -> {
                System.out.println("\nTitle: " + todo.getTitle());
                System.out.println("Description: " + todo.getDescription());
                System.out.println("Status: " + (todo.isCompleted() ? "Completed" : "Pending"));
            },
            () -> System.out.println("Todo not found with ID: " + id)
        );
    }

    private static void updateTodo() {
        System.out.println("\n=== Update Todo ===");
        String id = getStringInput("Enter todo ID: ");
        String title = getStringInput("Enter new title: ");
        String description = getStringInput("Enter new description: ");

        try {
            if (todoService.updateTodo(id, title, description)) {
                System.out.println("Todo updated successfully");
            } else {
                System.out.println("Todo not found with ID: " + id);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void markTodoAsCompleted() {
        System.out.println("\n=== Mark Todo as Completed ===");
        String id = getStringInput("Enter todo ID: ");

        if (todoService.markTodoAsCompleted(id)) {
            System.out.println("Todo marked as completed");
        } else {
            System.out.println("Todo not found with ID: " + id);
        }
    }

    private static void deleteTodo() {
        System.out.println("\n=== Delete Todo ===");
        String id = getStringInput("Enter todo ID: ");

        if (todoService.deleteTodo(id)) {
            System.out.println("Todo deleted successfully");
        } else {
            System.out.println("Todo not found with ID: " + id);
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
