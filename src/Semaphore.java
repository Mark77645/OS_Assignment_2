public class Semaphore {
    public int bound = 0; //Number of devices that can work concurrently.
    public Semaphore(int bound) {
        this.bound = bound;
    }
    //To reserve a place in "bound"
    public synchronized void reserve(String name) throws InterruptedException {
        bound--;
        if (bound < 0) {
            int g = 0;
            String out="";
            for (int i = 0; i < Network.devices.size(); i++) {
                if (Network.devices.get(i).getName().equals(name)) {
                    out = name + " ( " + Network.devices.get(i).getType() + " )" + " Arrived and waiting";
                    break;
                }
            }
            System.out.println(out);
            wait();
        } else {
            int g = 0;
            String out = "";

            for (int i = 0; i < Network.devices.size(); i++) {
                if (Network.devices.get(i).getName().equals(name)) {
                    out = name + " ( " + Network.devices.get(i).getType() + " )" + " Arrived";
                    break;
                }
            }
            System.out.println(out);

        }

    }
    public synchronized void release(String name){
        bound++;
        if (bound <= 0)
            notify();
        String out = "- Connection " + /*connection number +*/ ": " + name + " Logged out";
        System.out.println(out);
    }

}
