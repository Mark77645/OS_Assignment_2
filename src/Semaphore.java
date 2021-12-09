import java.io.IOException;

public class Semaphore {
    public  volatile int bound = 0; //Number of devices that can work concurrently.

    public Semaphore(int bound) throws IOException {
        this.bound = bound;
    }


    //To reserve a place in the "bound"
    public synchronized void wait(String name) throws InterruptedException {

            bound--;
            String message = "";
            if (bound < 0) {

                for (int i = 0; i < Network.devices.size(); i++) {
                    if (Network.devices.get(i).getName().equals(name)) {
                        message = name + " ( " + Network.devices.get(i).getType() + " )" + " Arrived and waiting";
                        break;
                    }
                }
                System.out.println(message+"\n");
                wait();
            } else {
                for (int i = 0; i < Network.devices.size(); i++) {
                    if (Network.devices.get(i).getName().equals(name)) {
                        message = name + " (" + Network.devices.get(i).getType() + ")" + " Arrived";
                        break;
                    }
                }
                System.out.println(message+"\n");

            }

        }

    //To release a place from the "bound"

    public synchronized void signal(String name) throws IOException {
            bound++;
            if (bound <= 0)
                notify();
            String message = "Connection " + 0 + ": " + name + " Logged out";
            System.out.println(message+"\n");
        }

    }
