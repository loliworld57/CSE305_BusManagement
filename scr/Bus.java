import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bus implements IBus {
    private String busName;
    private int capacity;
    private static final String BUSES_PATH = "e:\\AllAboutCode\\CSE305\\CSE305_BusManagement\\db\\buses.txt";

    // Private constructor for Builder pattern
    private Bus() {}

    private void saveBusToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BUSES_PATH, true))) {
            String busData = String.format("%s %d", busName, capacity);
            writer.write(busData);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving bus: " + e.getMessage());
        }
    }

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