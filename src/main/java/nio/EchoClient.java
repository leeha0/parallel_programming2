package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {
    private static SocketChannel client;
    private static ByteBuffer buffer;
    private static EchoClient instance;

    public static EchoClient start() throws IOException {
        if (instance == null) {
            instance = new EchoClient();
        }

        return instance;
    }

    public static void stop() throws IOException {
        client.close();
        buffer = null;
    }

    private EchoClient() throws IOException {
        client = SocketChannel.open(new InetSocketAddress("localhost", 3000));
        buffer = ByteBuffer.allocate(256);
    }

    public String sendMessage(String msg) throws IOException {
        buffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;

        client.write(buffer);
        buffer.clear();
        client.read(buffer);
        response = new String(buffer.array()).trim();
        System.out.println("response=" + response);
        buffer.clear();

        return response;
    }
}
