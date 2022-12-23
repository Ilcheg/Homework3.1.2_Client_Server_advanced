package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);

            String enterName = in.readLine();
            System.out.println(enterName);
            String name = scanner.nextLine();
            out.println(name);

            String enterPass = in.readLine();
            System.out.println(enterPass);
            String password = scanner.nextLine();
            out.println(password);

            String enterEmail = in.readLine();
            System.out.println(enterEmail);
            String email = scanner.nextLine();
            out.println(email);

            String enterDateOfBirth = in.readLine();
            System.out.println(enterDateOfBirth);
            String dateOfBirth = scanner.nextLine();
            out.println(dateOfBirth);

            String registrationSuccess = in.readLine();
            System.out.println(registrationSuccess);

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
