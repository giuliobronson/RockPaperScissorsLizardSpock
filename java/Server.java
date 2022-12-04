import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    private int PORT;
    private ServerSocket server;
    private Socket client;

    Server(int PORT) throws IOException {
        this.PORT = PORT;
        server = new ServerSocket(PORT);
        client = server.accept();
    }

    int getPORT() {
        return PORT;
    }

    int getMessage(int feedback) throws IOException {
        Scanner input = new Scanner(client.getInputStream());
        int msg = Integer.parseInt(input.nextLine());
        
        OutputStream output = client.getOutputStream();
        output.write(Integer.toString(feedback).getBytes(StandardCharsets.UTF_8));

        return msg;
    }
}
