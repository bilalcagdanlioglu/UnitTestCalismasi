import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServerBehaviorTest {

    //Belirli bir parametre ile txtWriter metodu çağrılıyor mu?
    @Test
    public void testBehavior() throws IOException {
        Server server = mock(Server.class);
        server.txtWriter("test");
        verify(server).txtWriter("test");
    }
}
