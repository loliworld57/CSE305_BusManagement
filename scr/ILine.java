public interface ILine {
    String getLineName();
    Route getRoute();
    Bus getBus();

    void setLineName(String lineName);
    void setRoute(Route route);
    void setBus(Bus bus);
} 
