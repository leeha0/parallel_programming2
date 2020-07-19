package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Sample3 {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("http://naver.com", 80));

        while (!socketChannel.finishConnect()) {
            // waiting
        }

        ByteBuffer[] dsts = new ByteBuffer[125];
        long readBytes = socketChannel.read(dsts);

        if (readBytes > 0) {
            // do something
        }
    }
}
