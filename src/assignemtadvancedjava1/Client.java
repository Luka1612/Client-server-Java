package assignemtadvancedjava1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("localhost", 100);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            output.write("Dobar dan\r\n".getBytes());

            System.out.println(br.readLine());
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Unesi prvi broj:");
                String operacija = scanner.nextLine() + "\r\n";
                output.write(operacija.getBytes());
            } catch (Exception e1) {
                System.out.println("Pogrešan unos, probajte ponovo.");
            }

            try {
                System.out.println("Unesi drugi broj:");
                String operacija1 = scanner.nextLine() + "\r\n";
                output.write(operacija1.getBytes());
            } catch (Exception e2) {
                System.out.println("Pogrešan unos, probajte ponovo");
            }

            System.out.println("Rezulat je:" + br.readLine());
        } catch (Exception e3) {
            System.out.println(e3);
        }
    }

}
