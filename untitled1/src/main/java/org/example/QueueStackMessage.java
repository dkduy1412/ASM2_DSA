package org.example;

import java.util.Scanner;

public class QueueStackMessage {
    public static void main(String[] args) {
        Stack<String> messageStack = new Stack<>();
        Queue<String> messageQueue = new Queue<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1.Input Message");
            System.out.println("2.Send Message");
            System.out.println("3.View Messages");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter messages:");
                    String inputMessage;
                    do {
                        inputMessage = scanner.nextLine();
                        if (!inputMessage.isEmpty()) {
                            if (inputMessage.length() <= 250) {
                                messageQueue.enqueue(inputMessage);
                                System.out.println("Message enqueued successfully.");
                            } else {
                                System.out.println("Message length exceeds the maximum limit (250 characters).");
                            }
                        }
                    } while (!inputMessage.isEmpty());
                    break;
                case 2:

                try {
                    String sentMessage = messageQueue.dequeue();
                    messageStack.push(sentMessage);
                    System.out.println("Message sent and stored in the stack: " + sentMessage);
                } catch (IllegalStateException e) {
                    System.out.println("The queue is empty");
                }
                break;
                case 3:
                    System.out.println("Viewing Sent Messages:");
                    while (!messageStack.isEmpty()) {
                        System.out.println(messageStack.pop());
                    }
                    break;
                case 4:
                    System.out.println("Exit Succeed!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
