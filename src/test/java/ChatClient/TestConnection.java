package ChatClient;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.ChatClient.Client1Connection;


public class TestConnection {

    @Test
    public void testClient_correctlyGetAddress() {

        String filePath = "settings.txt";
        Assertions.assertTrue(Client1Connection.getAddress(filePath));

    }
}
