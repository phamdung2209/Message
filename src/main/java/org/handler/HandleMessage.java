package org.handler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;
import org.lib.MyQueue;
import org.lib.MyStack;

public class HandleMessage {
    private Scanner scanner = new Scanner(System.in);
    private MyQueue<String> queue = new MyQueue<>();
    private MyStack<String> stack = new MyStack<>();

    public HandleMessage() {
    }

    // handle input
    public void processInput(String message, String note, int count, int countMessage) {
        if (!message.trim().isEmpty()) {
            if (message.equalsIgnoreCase("exit")) {
                exit();
            } else {
                Supplier<Boolean> isValidMessage = () -> message.length() >= 2 && message.matches("^[a-zA-Z0-9]+$");

                if (isValidMessage.get()) {
                    handleMessage(message, count, countMessage);
                } else {
                    System.out.println(note);
                }
            }
        } else {
            System.out.println(note);
        }

    }

    public void handleMessage(String message, int count, int countMessage) {
        queue.offer(message);
        System.out.println("Message added to queue. Current queue size: " + queue.size());
        if (count >= 5 || queue.size() > countMessage) {
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
        }

        // pop stack and print
        if (stack.size() > 0) {
            System.out.println("Printing messages from stack...");
            while (!stack.isEmpty()) {
                System.out.println("Message " + count + ": " + stack.pop());
                count++;
            }
        }
    }

    public void Message(int count, int countMessage) {
        System.out.print("Enter the " + count + getSuffix(count) + " message (type 'exit' to end): ");
        String message = scanner.nextLine();

        countMessage--;
        String note = "Please enter a message with at least 2 characters and do not start with special characters :)";
        processInput(message, note, count, countMessage);
    }

    public String getSuffix(int i) {
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

    // handle exit
    public void exit() {
        System.out.println("Exiting...");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, 4000);
    }

}