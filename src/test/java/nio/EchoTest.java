package nio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class EchoTest {

    //    Process server;
    EchoClient client;

    @Before
    public void setup() throws IOException {
//        server = EchoServer.start();
        client = EchoClient.start();
    }

    @Test
    public void givenServerClient_whenServerEchoMessage_thenCorrect() throws IOException {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        assertEquals("hello", resp1);
        assertEquals("world", resp2);
    }

    @After
    public void teardown() throws IOException {
//        server.destroy();
        EchoClient.stop();
    }
}
