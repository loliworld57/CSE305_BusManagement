package BusServiceSystem.scr;

public interface ISchedule {
    Bus getBus();
    Route getRoute();
    String getTime();

    void setBus(Bus bus);
    void setRoute(Route route);
    void setTime(String time);
}
