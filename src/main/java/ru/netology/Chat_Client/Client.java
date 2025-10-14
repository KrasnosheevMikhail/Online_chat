package ru.netology.Chat_Client;

import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private String name;
    private Socket socket;
    private PrintWriter out;
    public static final String LOGPATH = "log.txt";

    public Client(Socket socket, PrintWriter out) {
        this.socket = socket;
        this.out = out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMsg(String msg) {
        out.println(msg);
        out.flush();
        ClientLogger.log(LOGPATH, msg);
    }
}

