package BusServiceSystem.scr;

public class RouteBuilder {
    private String routeName;
    private String start;
    private String end;
    private Long distance;
    private Long duration;
    private double price;
    private IBus bus;

    public RouteBuilder setRouteName(String routeName) {
        this.routeName = routeName;
        return this;
    }

    public RouteBuilder setStart(String start) {
        this.start = start;
        return this;
    }

    public RouteBuilder setEnd(String end) {
        this.end = end;
        return this;
    }

    public RouteBuilder setDistance(Long distance) {
        this.distance = distance;
        return this;
    }

    public RouteBuilder setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    public RouteBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public RouteBuilder setBus(IBus bus) {
        this.bus = bus;
        return this;
    }

    public IRoute build() {
        Route route = new Route(routeName, start, end, distance, duration);
        route.setPrice(price);
        if (bus != null) {
            route.setBus(bus);
        }
        return route;
    }
}