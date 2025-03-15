package BusServiceSystem.scr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Main {
    static StringBuilder infor = new StringBuilder();

    public static void main(String[] args) {
        Map graph = new Map();

        // Read routes and buses from files
        List<String> routeLines = readLinesFromFile("d:\\works\\BusManagement\\BusServiceSystem\\db\\routes.txt");
        List<String> busLines = readLinesFromFile("d:\\works\\BusManagement\\BusServiceSystem\\db\\buses.txt");
        List<String> scheduleLines = readLinesFromFile("d:\\works\\BusManagement\\BusServiceSystem\\db\\schedule.txt");

        // Load routes and buses
        for (int i = 0; i < routeLines.size(); i++) {
            String[] routeData = routeLines.get(i).split(" ");
            String routeName = routeData[0] + " " + routeData[1];
            String start = routeData[2];
            String end = routeData[3];
            long distance = Long.parseLong(routeData[4]);
            long duration = Long.parseLong(routeData[5]);
            double price = Double.parseDouble(routeData[6]);

            String[] busData = busLines.get(i).split(" ");
            String busName = busData[0] + " " + busData[1];
            int capacity = Integer.parseInt(busData[2]);

            IRoute route = new RouteBuilder()
                    .setRouteName(routeName)
                    .setStart(start)
                    .setEnd(end)
                    .setDistance(distance)
                    .setDuration(duration)
                    .setPrice(price)
                    .build();

            IBus bus = new BusBuilder()
                    .setBusName(busName)
                    .setCapacity(capacity)
                    .setRoute(route)
                    .build();

            // Set the bus for the route after both are built
            ((Route) route).setBus(bus);
            graph.addRoute((Route) route);
            graph.addBus((Bus) bus);
            graph.addBusToRoute((Bus) bus, routeName);

    
        }

        // Append existing schedules to infor
        infor.append("\nExisting Schedules:\n");
        for (String scheduleLine : scheduleLines) {
            String[] scheduleData = scheduleLine.split(" ");
            String busName = scheduleData[0] + " " + scheduleData[1];
            String routeName = scheduleData[2] + " " + scheduleData[3];
            String departureTime = scheduleData[4];

            // Find the route details from the graph
            Route route = null;
            for (Route r : graph.routes) {
                if (r.getRouteName().equalsIgnoreCase(routeName)) {
                    route = r;
                    break;
                }
            }

            // Append schedule and route details to infor
            if (route != null) {
                infor.append("Bus: ").append(busName)
                        .append(", Route: ").append(routeName)
                        .append(", Departure Time: ").append(departureTime).append("\n");
                infor.append("    Start: ").append(route.getStart())
                        .append(", End: ").append(route.getEnd()).append("\n");
                infor.append("    Distance: ").append(route.getDistance()).append(" km")
                        .append(", Duration: ").append(formatDuration(route.getDuration()))
                        .append(", Price: $").append(route.getPrice()).append("\n");
            } else {
                infor.append("Bus: ").append(busName)
                        .append(", Route: ").append(routeName)
                        .append(", Departure Time: ").append(departureTime).append("\n");
                infor.append("    Route details not found.\n");
            }
        }

        // Display the infor StringBuilder
        System.out.println(infor);

        // Create a new schedule
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter bus name: ");
        String busName = scanner.nextLine();
        System.out.print("Enter route name: ");
        String routeName = scanner.nextLine();
        System.out.print("Enter departure time: ");
        String departureTime = scanner.nextLine();

        // Save the new schedule to the file
        saveScheduleToFile(busName, routeName, departureTime,
                "d:\\works\\BusManagement\\BusServiceSystem\\db\\schedule.txt");

        // Append the new schedule to infor
        infor.append("New Schedule Added:\n")
                .append("Bus: ").append(busName)
                .append(", Route: ").append(routeName)
                .append(", Departure Time: ").append(departureTime).append("\n");

        // Display the updated infor StringBuilder
        System.out.println("\nUpdated Information:");
        System.out.println(infor);
    }

    private static List<String> readLinesFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private static void saveScheduleToFile(String busName, String routeName, String departureTime, String filePath) {
        String scheduleEntry = busName + " " + routeName + " " + departureTime + System.lineSeparator();
        try {
            Files.write(Paths.get(filePath), scheduleEntry.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Schedule saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save schedule.");
        }
    }

    private static String formatDuration(long duration) {
        long hours = duration / 60;
        long minutes = duration % 60;
        return hours + "h " + minutes + "m";
    }

}