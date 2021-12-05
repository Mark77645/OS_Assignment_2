import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static int numberOfConnections;
    public static int numberOfDevices;
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Device> devices = new ArrayList<>();





    public static void main(String[] args) throws InterruptedException {
        System.out.println("What is the number of WI-FI Connections?");
        numberOfConnections=input.nextInt();
        System.out.println("What is the number of devices Clients want to connect?");
        numberOfDevices=input.nextInt();
        String name = "";
        String type = "";

        for (int i = 0; i < numberOfDevices; i++) {
            name = input.next();
            type = input.next();
            Device deviceDummy=new Device(name,type);
            devices.add(deviceDummy);
        }
        Router r=new Router();
        r.connect();


    }
}
