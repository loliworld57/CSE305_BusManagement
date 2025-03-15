package BusServiceSystem.scr;

public class Bus implements IBus {
    private String busName;
    private int capacity;
    private IRoute route;

    public Bus(String busName, int capacity) {
        this.busName = busName;
        this.capacity = capacity;
        this.route = null;
    }

    @Override
    public void assignRoute(IRoute route) {
        this.route = route;
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
    public IRoute getRoute() {
        return route;
    }

    @Override
    public void setBusName(String busName) {
        this.busName = busName;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}