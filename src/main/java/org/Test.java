package org;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

class MessageSystem {
    private Queue<String> messageQueue;
    private Stack<String> messageStack;

    public MessageSystem() {
        this.messageQueue = new LinkedList<>();
        this.messageStack = new Stack<>();
    }

    public boolean isValidMessage(String message) {
        // Thêm điều kiện để xác định xem một tin nhắn có hợp lệ hay không
        // Ví dụ: Tin nhắn phải có ít nhất 5 ký tự và không được chứa ký tự đặc biệt
        return message.length() >= 5 && message.matches("^[a-zA-Z0-9 ]+$");
    }

    public void sendMessage(String message) {
        if (isValidMessage(message)) {
            System.out.println("Sending message: " + message);
            messageQueue.offer(message);
        } else {
            System.out.println("Invalid message. Please enter a valid message.");
        }
    }

    public void processMessages() {
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            messageStack.push(message);
        }

        while (!messageStack.isEmpty()) {
            String processedMessage = messageStack.pop();
            System.out.println("Processed message: " + processedMessage);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageSystem messageSystem = new MessageSystem();

        System.out.println("Enter a message (type 'exit' to end):");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            messageSystem.sendMessage(input);
        }

        System.out.println("\nProcessing messages:");
        messageSystem.processMessages();
    }
}
