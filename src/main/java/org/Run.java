package org;

import java.util.Scanner;
import org.handler.HandleMessage;

public class Run {
    public static Scanner scanner = new Scanner(System.in);
    private static int count = 1;
    private static HandleMessage handleMessage = new HandleMessage();

    public static void main(String[] args) {
        System.out.print("Enter the message number: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Enter the message number: ");
            scanner.next();
        }
        int countMessage = scanner.nextInt();

        while (true) {
            handleMessage.Message(count, countMessage);
        }
    }

    
}
