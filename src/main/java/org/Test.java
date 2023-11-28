package org;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

import org.lib.MyQueue;
import org.lib.MyStack;

class HandleMessage {
    private MyQueue<String> queue = new MyQueue<>();
    private MyStack<String> stack = new MyStack<>();

    public HandleMessage() {
    }

    // handle input
    public void processInput(String message, String note, int count) {
        if (!message.trim().isEmpty()) {
            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                }, 4000);
            } else {
                Supplier<Boolean> isValidMessage = () -> message.length() >= 2 && message.matches("^[a-zA-Z0-9]+$");

                if (isValidMessage.get()) {
                    count++;
                    handleMessage(message, count);
                } else {
                    System.out.println(note);
                }
            }
        } else {
            System.out.println(note);
        }

    }

    public void handleMessage(String message, int count) {
        queue.offer(message);
        System.out.println("Message added to queue. Current queue size: " + queue.size());
        if (count >= 5 || queue.size() >= 5) {
            System.out.println("Maximum count reached. Exiting...");
            System.exit(0);
        }
    }

    public void Message(String message, int count) {
        if (count <= 4) {
            String note = "Please enter a message with at least 2 characters and do not start with special characters :)";
            processInput(message, note, count);
        } else {
            System.exit(0);
        }
    }

    public boolean isValidMessage(String message) {
        return message.length() >= 2 && message.matches("^[a-zA-Z0-9]+$");
    }
}

public class Test {
    public static Scanner scanner = new Scanner(System.in);
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println("Welcome to Message System!");

        HandleMessage handleMessage = new HandleMessage();

        while (true) {
            System.out.print("Enter the " + count + getSuffix(count) + " message (type 'exit' to end): ");
            String message = scanner.nextLine();

            handleMessage.Message(message, count);
        }
    }

    public static String getSuffix(int i) {
        switch (i) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
