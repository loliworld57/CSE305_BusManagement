
public interface IRoute {
    String getRouteName();
    String getStart();
    String getEnd();
    Long getDistance();
    Long getDuration();
    double getPrice();

    void setRouteName(String routeName);
    void setStart(String start);
    void setEnd(String end);
    void setDistance(Long distance);
    void setDuration(Long duration);
    void setPrice(double price);
}