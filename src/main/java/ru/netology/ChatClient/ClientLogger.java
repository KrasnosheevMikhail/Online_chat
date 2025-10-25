package ru.netology.ChatClient;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ClientLogger {

    public static boolean log(String logPath, String msg) {
        try (FileWriter fileWriter = new FileWriter("log1.txt", true)) {
            fileWriter.write(LocalDateTime.now().
                    format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    + " -> " + msg + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

