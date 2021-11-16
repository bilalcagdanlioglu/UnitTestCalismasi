import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServerFileTest {

    //Txt dosyamız için gerekli kontrolleri test ediyoruz.
    @Test
    public void testFile() throws IOException {
        File file = new File("server.txt");

        assertThat(file)
                .exists()
                .canWrite()
                .canRead()
                .hasExtension("txt")
                .hasName("server.txt");
    }
}
