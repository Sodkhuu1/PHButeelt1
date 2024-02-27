package lab1buteelt;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskManager {
    private static LinkedList<String> taskList = new LinkedList<>();

    public static void addTask(String task) {
        taskList.add(task);
        System.out.println("Task added: " + task);
    }

    public static void removeTask(String task) {
        if (taskList.remove(task)) {
            System.out.println("Task removed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    /**
     * 
     */
    public static void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (String task : taskList) {
                System.out.println("- " + task);
            }
        }
    }

    public static void markTaskAsCompleted(String task) {
        if (taskList.contains(task)) {
            System.out.println("Task marked as completed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    public static int getTaskCount() {
        return taskList.size();
    }

    public static void clearAllTasks() {
        taskList.clear();
        System.out.println("All tasks cleared.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. ажил нэмэх");
            System.out.println("2. ажил хасах");
            System.out.println("3. ажлуудыг харуулах");
            System.out.println("4. ажлуудыг хийснээр тооцох");
            System.out.println("5. ажлын тоог харах");
            System.out.println("6. бүх ажлыг устгах");
            System.out.println("0. гарах");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("Enter task to remove: ");
                    String taskToRemove = scanner.nextLine();
                    removeTask(taskToRemove);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.print("Enter task to mark as completed: ");
                    String taskToMark = scanner.nextLine();
                    markTaskAsCompleted(taskToMark);
                    break;
                case 5:
                    System.out.println("Task count: " + getTaskCount());
                    break;
                case 6:
                    clearAllTasks();
                    break;
                case 0:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
