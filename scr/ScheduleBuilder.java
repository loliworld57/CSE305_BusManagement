package BusServiceSystem.scr;

public class ScheduleBuilder {
    private Bus bus;
    private Route route;
    private String time;

    public ScheduleBuilder setBus(Bus bus) {
        this.bus = bus;
        return this;
    }

    public ScheduleBuilder setRoute(Route route) {
        this.route = route;
        return this;
    }

    public ScheduleBuilder setTime(String time) {
        this.time = time;
        return this;
    }

    public Bus getBus() {
        return bus;
    }

    public Route getRoute() {
        return route;
    }

    public String getTime() {
        return time;
    }

    public Schedule build() {
        return new Schedule(this);
    }
}