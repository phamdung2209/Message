package org.handler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.lib.MyQueue;
import org.lib.MyStack;

public class HandleMessage {

    public HandleMessage() {
    }

    // handle input
    public void processInput(String message, String note) {
        if (!message.trim().isEmpty()) {
            if (message.equalsIgnoreCase("exit")) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                }, 4000);
            } else {
                Supplier<Boolean> isValidMessage = () -> message.length() >= 2 && message.matches("^[a-zA-Z0-9]+$");

                if (isValidMessage.get()) {
                    handleMessage(message);
                } else {
                    System.out.println(note);
                }
            }
        } else {
            System.out.println(note);
        }

    }

    public void handleMessage(String message) {
        MyQueue queue = new MyQueue<>();
        MyStack stack = new MyStack<>();

        queue.offer(message);
        stack.push(queue.poll());
        message = stack.pop().toString();

        System.out.println("User: " + message);
    }

    public void Message(String message) {
        String note = "Please enter a message with at least 2 characters and do not start with special characters :)";
        processInput(message, note);
    }

    public boolean isValidMessage(String message) {
        return message.length() >= 2 && message.matches("^[a-zA-Z0-9]+$");
    }
}
