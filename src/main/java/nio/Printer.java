package nio;

import java.nio.channels.SelectionKey;

public class Printer {

    public static void printInterestSet(SelectionKey selectionKey) {
        int interestSet = selectionKey.interestOps();

        int isInterestedInAccept = interestSet & SelectionKey.OP_ACCEPT;
        int isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
        int isInterestedInRead = interestSet & SelectionKey.OP_READ;
        int isInterestedInWrite = interestSet & SelectionKey.OP_WRITE;

        System.out.println(isInterestedInAccept);
        System.out.println(isInterestedInConnect);
        System.out.println(isInterestedInRead);
        System.out.println(isInterestedInWrite);
    }

    public static void printReadySet(SelectionKey selectionKey) {
//        int readySet = selectionKey.readyOps();

        System.out.println(selectionKey.isAcceptable());
        System.out.println(selectionKey.isConnectable());
        System.out.println(selectionKey.isReadable());
        System.out.println(selectionKey.isWritable());
    }
}
