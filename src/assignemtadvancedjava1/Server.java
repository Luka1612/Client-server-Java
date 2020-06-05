package assignemtadvancedjava1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(100);

        try {
            System.out.println("Server slusa");
            Socket socket = server.accept();
            new Kalkulator(socket).start();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
