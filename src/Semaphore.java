public class Semaphore {
    public int bound = 0; //Number of devices that can work concurrently.
    public Semaphore(int bound) {
        this.bound = bound;
    }
    //To reserve a place in the "bound"
    public synchronized void reserve(String name) throws InterruptedException {
        bound--;
        String message="";
        if (bound < 0) {
            for (int i = 0; i < Network.devices.size(); i++) {
                if (Network.devices.get(i).getName().equals(name)) {
                    message = name + " ( " + Network.devices.get(i).getType() + " )" + " Arrived and waiting";
                    break;
                }
            }
            System.out.println(message);
            wait();
        } else {

            for (int i = 0; i < Network.devices.size(); i++) {
                if (Network.devices.get(i).getName().equals(name)) {
                    message = name + " ( " + Network.devices.get(i).getType() + " )" + " Arrived";
                    break;
                }
            }
            System.out.println(message);
        }

    }
    //To release a place from the "bound"

    public synchronized void release(String name){
        bound++;
        if (bound <= 0)
            notify();
        String out = "- Connection " + /*connection number +*/ ": " + name + " Logged out";
        System.out.println(out);
    }

}
