import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static int numberOfConnections;
    public static int numberOfDevices;
    public static int counter=numberOfConnections;
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Device> devices = new ArrayList<>();





    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("What is the number of WI-FI Connections?");
        numberOfConnections=input.nextInt();
        System.out.println("What is the number of devices Clients want to connect?");
        numberOfDevices=input.nextInt();
        String name = "";
        String type = "";
        PrintStream ps = new PrintStream(new File("output.txt"));
        System.setOut(ps);

        for (int i = 0; i < numberOfDevices; i++) {
            name = input.next();
            type = input.next();
            Device deviceDummy=new Device(name,type,i);
            devices.add(deviceDummy);
        }
        Router r=new Router();
        r.connect();


    }
}