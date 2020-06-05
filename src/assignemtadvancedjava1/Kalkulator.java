package assignemtadvancedjava1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Kalkulator extends Thread {

    Socket socket;
    public Kalkulator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            System.out.println(br.readLine());
            output.write("Izvoli\r\n".getBytes());

            System.out.println("Prvi broj je:");
            String operandi = br.readLine();
            System.out.println(operandi);

            System.out.println("Drugi broj je:");
            String operandi1 = br.readLine();
            System.out.println(operandi1);

            int op1 = Integer.parseInt(operandi.split(",")[0]);
            int op2 = Integer.parseInt(operandi1.split(",")[0]);

            String rezulat = "";
            rezulat = String.valueOf(op1 + op2);
            output.write((rezulat + "\r\n").getBytes());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
