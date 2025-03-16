import java.io.*;
import java.util.*;

public class BusLine {
    private HashMap<String, Line> busLine;
    private Route[] routes;
    private Bus[] buses;
    private static final String LINES_PATH = "e:\\AllAboutCode\\CSE305\\CSE305_BusManagement\\db\\lines.txt";
    private static final String ROUTES_PATH = "e:\\AllAboutCode\\CSE305\\CSE305_BusManagement\\db\\routes.txt";
    private static final String BUSES_PATH = "e:\\AllAboutCode\\CSE305\\CSE305_BusManagement\\db\\buses.txt";

    public BusLine() {
        loadBuses();
        loadRoutes();
        this.busLine = new HashMap<>();
        loadLines();
    }

    private void loadBuses() {
        List<Bus> busList = new ArrayList<>();
        Set<String> uniqueBusNames = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(BUSES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length >= 3) {
                        String busName = parts[0] + " " + parts[1];

                        if (uniqueBusNames.contains(busName)) {
                            continue;
                        }

                        int capacity = Integer.parseInt(parts[2]);

                        Bus bus = new Bus.Builder()
                                .busName(busName)
                                .capacity(capacity)
                                .build();
                        busList.add(bus);
                        uniqueBusNames.add(busName);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid capacity format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading buses: " + e.getMessage());
        }

        buses = busList.toArray(new Bus[0]);
    }

    private void loadRoutes() {
        List<Route> routeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ROUTES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String routeName = parts[0] + " " + parts[1];
                String start = parts[2];
                String end = parts[3];
                Long distance = Long.parseLong(parts[4]);
                Long duration = Long.parseLong(parts[5]);

                Route route = new Route.Builder()
                        .routeName(routeName)
                        .start(start)
                        .end(end)
                        .distance(distance)
                        .duration(duration)
                        .build();
                routeList.add(route);
            }
        } catch (IOException e) {
            System.err.println("Error loading routes: " + e.getMessage());
        }
        routes = routeList.toArray(new Route[0]);
    }

    public void loadLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LINES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                // Format: "Line 1 Bus 1 Route 1"
                String lineName = parts[0] + " " + parts[1]; // "Line 1"
                String busName = parts[2] + " " + parts[3]; // "Bus 1"
                String routeName = parts[4] + " " + parts[5]; // "Route 1"

                // Find corresponding route and bus objects
                Route route = findRoute(routeName);
                Bus bus = findBus(busName);

                if (route != null && bus != null) {
                    Line newLine = new Line.Builder()
                            .lineName(lineName)
                            .bus(bus)
                            .route(route)
                            .build();
                    busLine.put(lineName, newLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading lines: " + e.getMessage());
        }
    }

    private Route findRoute(String routeName) {
        for (Route r : routes) {
            if (r.getRouteName().equals(routeName)) {
                return r;
            }
        }
        return null;
    }

    private Bus findBus(String busName) {
        for (Bus b : buses) {
            if (b.getBusName().equals(busName)) {
                return b;
            }
        }
        return null;
    }

    public void addNewLine(Bus bus, Route route) {
        for (Bus b : buses) {
            if (b.getBusName().equals(bus.getBusName())) {
                bus = b;
                break;
            }
        }
        for (Route r : routes) {
            if (r.getRouteName().equals(route.getRouteName())) {
                route = r;
                break;
            }
        }
        Line line = new Line.Builder()
                .bus(bus)
                .route(route)
                .build();
        line.setLineName("Line " + busLine.size());
        busLine.put(line.getLineName(), line);

        // Save to file with new format
        saveLineToFile(line);
    }

    private void saveLineToFile(Line line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LINES_PATH, true))) {
            String lineData = String.format("%s %s %s",
                    line.getLineName(),
                    line.getBus().getBusName(),
                    line.getRoute().getRouteName());
            writer.write(lineData);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving line: " + e.getMessage());
        }
    }

    public Line getLine(String lineName) {
        return busLine.get(lineName);
    }
}