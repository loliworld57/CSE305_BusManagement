package BusServiceSystem.scr;

public class Schedule implements ISchedule {
    private Bus bus;
    private Route route;
    private String time;

    Schedule(ScheduleBuilder builder) {
        this.bus = builder.getBus();
        this.route = builder.getRoute();
        this.time = builder.getTime();
    }

    @Override
    public Bus getBus() {
        return bus;
    }

    @Override
    public Route getRoute() {
        return route;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }
}