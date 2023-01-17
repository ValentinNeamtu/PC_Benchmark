package Model;

public class Memory {
    private String name;
    private double freq;
    private long capacity;
    private String type;

    public Memory(String name, double freq, long capacity, String type) {
        this.name = name;
        this.freq = freq;
        this.capacity = capacity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFreq() {
        return freq;
    }

    public void setFreq(double freq) {
        this.freq = freq;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "name='" + name + '\'' +
                ", freq=" + freq +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}
