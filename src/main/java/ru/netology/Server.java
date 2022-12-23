package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    Person person = new Person();

                    out.println("Enter your name to register");
                    person.setName(in.readLine());

                    out.println("Enter your password");
                    person.setPassword(in.readLine());

                    out.println("Enter your email");
                    person.setEmail(in.readLine());

                    out.println("Enter your date of birth");
                    person.setDateOfBirth(in.readLine());

                    out.println("You successfully registered!");

                    System.out.println("Account was created: " + person);
                }
            }
        }
    }
}