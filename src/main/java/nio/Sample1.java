package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Sample1 {

    public static void main(String[] args) throws IOException {
        // 셀렉터 생성
        Selector selector = Selector.open();

        // 채널 등록
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        SelectionKey selectionKey = socketChannel.register(selector, interestSet);

        Printer.printInterestSet(selectionKey);
        Printer.printReadySet(selectionKey);

        // 준비된 채널 반환
        int prepareChannels = selector.select(3000L); // block
        System.out.println("prepared channels " + prepareChannels);
        if (prepareChannels > 0) {
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    System.out.println("a connection was accepted by a ServerSocketChannel.");
                } else if (key.isConnectable()) {
                    System.out.println("a connection was established with a remove server.");
                } else if (key.isReadable()) {
                    System.out.println("a channel is ready for reading.");
                } else if (key.isWritable()) {
                    System.out.println("a channel is ready for writing.");
                }
            }

            keyIterator.remove();
        }
    }
}
