package BusServiceSystem.scr;

import java.util.*;

public class Map {
    List<Route> routes;
    List<Bus> buses;

    public Map(){
        routes = new ArrayList<Route>();
        buses = new ArrayList<Bus>();
    };
    
    public Map(List<Route> routes, List<Bus> buses) {
        this.routes = routes;
        this.buses = buses;
    }

    public void addRoute(Route route) {
        routes.add(route);
    }
    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void addBusToRoute(Bus busName, String routeName) {
        for (Route route : routes) {
            if (route.getRouteName().equals(routeName)) {
                route.setBus(busName);
            }
        }
    }
    
    public boolean findRoute(String start, String end) {
        for (Route route : routes) {
            if (route.getStart().equalsIgnoreCase(start) && route.getEnd().equalsIgnoreCase(end)) {
                System.out.println("Route found: " + route.getRouteName() + " " + route.getBus().getBusName() + " Distance: " + route.getDistance() + "m Duration: " + formatDuration(route.getDuration()) + " Price: " + route.getPrice() + "$");
                return true;
            }
        }
        System.out.println("Route not found");
        return false;
    }
    private String formatDuration(long duration) {
        long hours = duration / 60;
        long minutes = duration % 60;
        return hours + "h " + minutes + "m";
    }
}
