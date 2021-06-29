package parallel.chapter6.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class LifecycleWebServer {

    private final ExecutorService exec = Executors.newSingleThreadExecutor();

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (!exec.isShutdown()) {
            try {
                final Socket connection = socket.accept();
                exec.execute(new Runnable() {
                    public void run() {
                        handleRequest(connection);
                    }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) {
                    // log("task submission rejected", e);
                }
            }
        }
    }

    public void stop() {
        exec.shutdown();
    }

    void handleRequest(Socket connection) {
        Request req = readRequest(connection);
        if (isShutdownRequest(req)) {
            stop();
        } else {
            dispatchRequest(req);
        }
    }

    private void dispatchRequest(Request req) {
        // Do Something
    }

    private boolean isShutdownRequest(Request req) {
        return false;
    }

    private Request readRequest(Socket connection) {
        return null;
    }
}
