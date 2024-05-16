package http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpServer {
    private final int PORT;
    private final ExecutorService pool;
    private boolean stopped;
    private Worker worker = new Worker();

    public HttpServer(int PORT, int poolSize) {
        this.PORT = PORT;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (!stopped) {
                Socket socket = server.accept();
                System.out.println("socket accepted");
                pool.submit(() -> worker.processSocket(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
