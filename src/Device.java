public class Device  {
    String name;
    String type;
    int counter;

    public Device(String name, String type, int counter) {
        this.name = name;
        this.type = type;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCounter() {
        return counter;
    }
}