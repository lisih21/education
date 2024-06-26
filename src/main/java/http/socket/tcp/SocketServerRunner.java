package http.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(80);
             Socket socket = serverSocket.accept(); // accept - блокирующий метод, пока клиент не подключился, ждем
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {
            String request = inputStream.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("Client request: " + request);
                String response = scanner.nextLine();
                outputStream.writeUTF(response);
                request = inputStream.readUTF();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
