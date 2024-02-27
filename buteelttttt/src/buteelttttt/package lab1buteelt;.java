package buteelttttt;

import java.util.LinkedList;
import java.util.Scanner;


public class TaskManager<T> {
    private LinkedList<T> taskList = new LinkedList<>();

    public void addTask(T task) {
        taskList.add(task);
        System.out.println("Нэмэгдсэн ажил: " + task);
    }

    public void removeTask(T task) {
        if (taskList.remove(task)) {
            System.out.println("ажлыг хаслааaa: " + task);
        } else {
            System.out.println("ажил олдсонгүй: " + task);
        }
    }

    
    public void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("ажил байхгүй байна.");
        } else {
            System.out.println("ажлууд:");
            for (T task : taskList) {
                System.out.println("- " + task);
            }
        }
    }

    public void markTaskAsCompleted(T task) {
        if (taskList.contains(task)) {
            System.out.println("ажлыг дуусгаснаар тэмдэглэлээ: " + task);
        } else {
            System.out.println("ажил олдсонгүй: " + task);
        }
    }

    public int getTaskCount() {
        return taskList.size();
    }

    public void clearAllTasks() {
        taskList.clear();
        System.out.println("бүх ажлуудыг устгалаа");
    }

    public static void main(String[] args) {
        TaskManager<String> circle = new TaskManager<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nСонголтын дугаарыг оруулна уу:");
            System.out.println("1. ажил нэмэх");
            System.out.println("2. ажил хасах");
            System.out.println("3. хүлээгдэж буй ажлуудыг харуулах");
            System.out.println("4. ажлыг хийснээр тооцох");
            System.out.println("5. ажлын тоог харуулах");
            System.out.println("6. ажлуудыг устгах");
            System.out.println("0. гарах");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("нэмэх ажлаа оруулна уу: ");
                    String taskToAdd = scanner.nextLine();
                    circle.addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("хасах ажлаа оруулна уу ");
                    String taskToRemove = scanner.nextLine();
                    circle.removeTask(taskToRemove);
                    break;
                case 3:
                    circle.displayTasks();
                    break;
                case 4:
                    System.out.print("гүйцэтгэсэн ажлаа оруул: ");
                    String taskToMark = scanner.nextLine();
                    circle.markTaskAsCompleted(taskToMark);
                    break;
                case 5:
                    System.out.println("ажлын тоо: " + circle.getTaskCount());
                    break;
                case 6:
                    circle.clearAllTasks();
                    break;
                case 0:
                    System.out.println(" баяртай!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("0-6 оруулна уу.");
            }
        }
    }
}
