package BusServiceSystem.scr;

public class Route implements IRoute {
    private String routeName;
    private String start;
    private String end;
    private Long distance;
    private Long duration;
    private double price;
    private IBus bus;

    public Route(String routeName, String start, String end, Long distance, Long duration) {
        this.routeName = routeName;
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.duration = duration;
        this.price = distance * 5000;
    }

    // Getters
    @Override
    public String getRouteName() {
        return routeName;
    }

    @Override
    public String getStart() {
        return start;
    }

    @Override
    public String getEnd() {
        return end;
    }

    @Override
    public Long getDistance() {
        return distance;
    }

    @Override
    public Long getDuration() {
        return duration;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public IBus getBus() {
        return bus;
    }

    // Setters
    @Override
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Override
    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public void setDistance(Long distance) {
        this.distance = distance;
    }

    @Override
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setBus(IBus bus) {
        this.bus = bus;
        this.bus.assignRoute(this);
    }
}