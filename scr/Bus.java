import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bus implements IBus {
    private String busName;
    private int capacity;
    // Private constructor for Builder pattern
    private Bus() {}

    @Override
    public String getBusName() {
        return busName;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setBusName(String busName) {
        this.busName = busName;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Static Builder class
    public static class Builder {
        private Bus bus;

        public Builder() {
            bus = new Bus();
        }

        public Builder busName(String busName) {
            bus.setBusName(busName);
            return this;
        }

        public Builder capacity(int capacity) {
            bus.setCapacity(capacity);
            return this;
        }

        public Bus build() {
            return bus;
        }
    }
}