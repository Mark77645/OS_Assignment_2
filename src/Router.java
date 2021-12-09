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
        //what will be done when a thread runs.
        try{
            semaphore.reserve(Thread.currentThread().getName());
            String nameOfTheDevice= Thread.currentThread().getName();
            int index=0;
            String message= "Connection "+ Network.numberOfConnections +  ": "+ nameOfTheDevice +" occupied.";
            System.out.println(message);
            Thread.sleep(1000);
            message="Connection "+ Network.numberOfConnections +  ": "+ nameOfTheDevice +" Login.";
            System.out.println(message);
            message= "Connection "+ Network.numberOfConnections +  ": "+ nameOfTheDevice +" Performs online activity.";
            System.out.println(message);
            Thread.sleep(5000);
            semaphore.release(Thread.currentThread().getName());
            Thread.currentThread().stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
