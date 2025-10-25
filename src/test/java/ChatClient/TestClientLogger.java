package ChatClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.ChatClient.Client;
import ru.netology.ChatClient.ClientLogger;


public class TestClientLogger {
    @Test
    public void testLogger_correctlyLogging() {
        String example = "Test string";
        String logPath = Client.LOGPATH;
        Client client = Mockito.mock(Client.class);
        Assertions.assertTrue(ClientLogger.log(logPath, example));
    }
}

