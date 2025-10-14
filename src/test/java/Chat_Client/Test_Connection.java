package Chat_Client;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.Chat_Client.Client1_Connection;
import ru.netology.Chat_Client.Client2_Connection;

public class Test_Connection {
    @Test
    public void testClient_correctlyGetAddress() {
        String filePath = "settings.txt";
        Assertions.assertTrue(Client1_Connection.getAddress(filePath));
        Assertions.assertTrue(Client2_Connection.getAddress(filePath));
    }
}
