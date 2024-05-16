package http.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Worker {

    public void processSocket(Socket socket) {
        try (
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream()) {
//step1 обработка request
            System.out.println("Request " + new String(inputStream.readNBytes(451)));
            Thread.sleep(10000);
//step2 формирование response
            byte[] body = Files.readAllBytes(Path.of(ClassLoader.getSystemResource("example.html").toURI()));
            String headers = String.format("HTTP/1.1 200 OK\n " +
                    "content-type: text/html");
            outputStream.write(headers.getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(new String(body, StandardCharsets.UTF_8).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
