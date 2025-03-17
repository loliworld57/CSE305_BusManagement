import java.io.*;
import java.util.*;

public class BusSchedule {

    private ArrayList<Line> lines;
    private ArrayList<Route> routes;
    private ArrayList<Bus> buses;
    private TreeMap<String, Line> busSchedule = new TreeMap<>();

    private static final String SCHEDULE_PATH = "db/schedule.txt";
    private static final String LINES_PATH = "db/lines.txt";
    private static final String ROUTES_PATH = "db/routes.txt";
    private static final String BUSES_PATH = "db/buses.txt";

    public BusSchedule() {
        loadBuses();
        loadRoutes();
        loadLines();
        this.busSchedule = loadSchedule();
    }

    private void loadBuses() {
        this.buses = new ArrayList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(BUSES_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String busName = parts[0] + " " + parts[1];
                int capacity = Integer.parseInt(parts[2]);

                Bus bus = new Bus.Builder()
                        .busName(busName)
                        .capacity(capacity)
                        .build();
                this.buses.add(bus);
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error loading buses: " + e.getMessage());
        }
    }

    private void loadRoutes() {
        this.routes = new ArrayList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(ROUTES_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
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
                routes.add(route);
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error loading routes: " + e.getMessage());
        }
    }

    private void loadLines() {
        this.lines = new ArrayList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(LINES_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String lineName = parts[0] + " " + parts[1];
                String busName = parts[2] + " " + parts[3];
                String routeName = parts[4] + " " + parts[5];

                // Find corresponding bus and route
                Bus matchingBus = null;
                Route matchingRoute = null;

                for (Bus b : buses) {
                    if (b.getBusName().equals(busName)) {
                        matchingBus = b;
                        break;
                    }
                }

                for (Route r : routes) {
                    if (r.getRouteName().equals(routeName)) {
                        matchingRoute = r;
                        break;
                    }
                }

                if (matchingBus != null && matchingRoute != null) {
                    Line newLine = new Line.Builder()
                            .lineName(lineName)
                            .bus(matchingBus)
                            .route(matchingRoute)
                            .build();
                    this.lines.add(newLine);
                } else {
                    System.err.println("Could not find matching bus or route for line: " + lineName);
                }
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error loading lines: " + e.getMessage());
        }
    }

    private TreeMap<String, Line> loadSchedule() {
        TreeMap<String, Line> sortedSchedule = new TreeMap<>((t1, t2) -> {
            String[] time1 = t1.split(":");
            String[] time2 = t2.split(":");
            int hour1 = Integer.parseInt(time1[0]);
            int hour2 = Integer.parseInt(time2[0]);
            int min1 = Integer.parseInt(time1[1]);
            int min2 = Integer.parseInt(time2[1]);

            if (hour1 != hour2) {
                return hour1 - hour2;
            }
            return min1 - min2;
        });

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(SCHEDULE_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("//")) {
                    continue;
                }

                String[] parts = line.split(" ");
                String time = parts[0];
                String lineName = parts[1] + " " + parts[2];

                for (Line l : lines) {
                    if (l.getLineName().equals(lineName)) {
                        sortedSchedule.put(time, l);
                        break;
                    }
                }
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error loading schedule: " + e.getMessage());
        }
        return sortedSchedule;
    }

    public void setLineSchedule(String lineName, String time) {
        for (Line line : lines) {
            if (line.getLineName().equals(lineName)) {
                busSchedule.put(time, line);
                saveScheduleToFile(time, lineName);
            }
        }
    }

    private void saveScheduleToFile(String time, String lineName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("db/schedule.txt", true))) {
            String scheduleData = String.format("%s %s", time, lineName);
            writer.write(scheduleData);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving schedule: " + e.getMessage());
        }
    }

    public TreeMap<String, Line> getBusSchedule() {
        return this.busSchedule;
    }

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public ArrayList<Route> getRoutes() {
        return this.routes;
    }

    public ArrayList<Bus> getBuses() {
        return this.buses;
    }

    public static class Builder {
        private BusSchedule schedule;

        public Builder() {
            schedule = new BusSchedule();
        }

        public BusSchedule build() {
            return schedule;
        }
    }
}