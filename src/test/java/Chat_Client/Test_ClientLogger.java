package Chat_Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.Chat_Client.Client;
import ru.netology.Chat_Client.ClientLogger;


public class Test_ClientLogger {
    @Test
    public void testLogger_correctlyLogging() {
        String example = "Test string";
        String logPath = Client.LOGPATH;
        Client client = Mockito.mock(Client.class);
        Assertions.assertTrue(ClientLogger.log(logPath, example));
    }
}

