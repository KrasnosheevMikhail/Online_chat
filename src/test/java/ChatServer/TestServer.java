package ChatServer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.ChatServer.Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestServer {

    @Test
    public void testCreateSettings_correctlyCreating() {
        String[] strings;
        try (BufferedReader fr = new BufferedReader(new FileReader("settings.txt"))) {
            strings = fr.readLine().split(" ");
            Assertions.assertEquals(Server.ADDRESS, strings[strings.length - 1]);
            strings = fr.readLine().split(" ");
            Assertions.assertEquals(Server.PORT, Integer.parseInt(strings[strings.length - 1]));
        } catch (FileNotFoundException e) {
            System.out.println("File settings.txt not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}