package org;

import java.util.Scanner;
import org.handler.HandleMessage;

public class Run {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter a message (type 'exit' to end): ");
            String message = scanner.nextLine();

            HandleMessage handleMessage = new HandleMessage();
            handleMessage.Message(message);
        }
    }
}
