package BusServiceSystem.scr;

public class BusBuilder {
    private String busName;
    private int capacity;
    private IRoute route;

    public BusBuilder setBusName(String busName) {
        this.busName = busName;
        return this;
    }

    public BusBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public BusBuilder setRoute(IRoute route) {
        this.route = route;
        return this;
    }

    public IBus build() {
        Bus bus = new Bus(busName, capacity);
        if (route != null) {
            bus.assignRoute(route);
        }
        return bus;
    }
}