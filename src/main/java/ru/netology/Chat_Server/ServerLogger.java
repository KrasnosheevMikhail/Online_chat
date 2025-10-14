package ru.netology.Chat_Server;

import ru.netology.Chat_Client.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ServerLogger {

    public static boolean log(String logPath, String msg, Client client) {
        try (FileWriter fileWriter = new FileWriter("log.txt", true)) {
            fileWriter.write(client.getName() + " ("
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    + ") " + msg + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
