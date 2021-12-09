import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Router implements Runnable {
    public Semaphore semaphore;


    public int conncetionNumber=0;

    public Router() throws IOException {
        semaphore = new Semaphore(Network.numberOfConnections); //initialize the bound.
    }

    public void connect() {
        //For each device there is a thread for it.
        for (int i = 0; i < Network.devices.size(); i++) {
            Thread t = new Thread(this, Network.devices.get(i).getName());
            conncetionNumber=i;
            t.start();
        }


    }







    @Override
    public void run() {
        //what will be done when a thread runs.
        try{
            semaphore.reserve(Thread.currentThread().getName());
            String nameOfTheDevice= Thread.currentThread().getName();

            String message= "Connection " + ": "+ nameOfTheDevice +" occupied.";
            System.out.println(message+"\n");
            Thread.sleep(1000);
            message="Connection "  +  ": "+ nameOfTheDevice +" Login.";
            System.out.println(message+"\n");
            message= "Connection "  +  ": "+ nameOfTheDevice +" Performs online activity.";
            System.out.println(message+"\n");
            Thread.sleep(5000);
            semaphore.release(Thread.currentThread().getName());
            Thread.currentThread().stop();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}