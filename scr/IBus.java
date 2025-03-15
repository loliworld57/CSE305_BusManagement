package BusServiceSystem.scr;

public interface IBus {
    String getBusName();
    int getCapacity();
    IRoute getRoute();

    void setBusName(String busName);
    void setCapacity(int capacity);
    void assignRoute(IRoute route);
}