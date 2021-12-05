public class Router implements Runnable {
    public Semaphore semaphore;

    public Router() {
        semaphore = new Semaphore(Network.numberOfConnections); //initialize the bound.
    }

    public void connect() {
        //For each device there is a thread for it.
        for (int i = 0; i < Network.devices.size(); i++) {
            Thread t = new Thread(this, Network.devices.get(i).getName());
            t.start();
        }

    }






    @Override
    public void run() {

    }
}
