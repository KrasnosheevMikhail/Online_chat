package ru.netology.Chat_Server;

import ru.netology.Chat_Client.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {

    public static final String ADDRESS = "localhost";
    public static final int PORT = 8080;
    static final String SETTINGSPATH = "settings.txt";
    static final String LOGPATH = "Log.txt";
    private static Map<String, Client> clients = new HashMap<>();

    public static void main(String[] args) {
        try {
            createsettings(SETTINGSPATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> {
                    try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        out.println("Enter your name:");
                        Client client = new Client(clientSocket, out);
                        client.setName(in.readLine());
                        clients.put((client.getName() + "#" + clientSocket.getPort()), client);
                        sendMessage(client.getName() + " connected!", client);
                        waitMessage(clientSocket, client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void createsettings(String filePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("settings.txt", false));
        bw.write("address: " + ADDRESS);
        bw.newLine();
        bw.write("port: " + PORT);
        System.out.println("Setting file created");
        bw.close();
    }

    public static void sendMessage(String msg, Client client) {
        for (Map.Entry<String, Client> entryMap : clients.entrySet()) {
            if (entryMap.getValue() == client) continue;
            entryMap.getValue().sendMsg(msg);
            ServerLogger.log(LOGPATH, msg, client);

        }

    }

    public static void waitMessage(Socket clientSocket, Client client) {
        try (Scanner scanner = new Scanner(clientSocket.getInputStream())) {
            while (true) {
                if (scanner.hasNext()) {
                    String str = scanner.nextLine();
                    if (str.equalsIgnoreCase("/exit")) {
                        sendMessage(client.getName() + " :Disconected ", client);
                        break;
                    }
                    sendMessage(client.getName() + " : " + str, client);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}