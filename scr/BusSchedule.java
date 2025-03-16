import java.io.*;
import java.util.*;

public class BusSchedule {
    private Line[] lines;
    private String[] times;
    private HashMap<String, Line> busSchedule;
    private static final String SCHEDULE_PATH = "e:\\AllAboutCode\\CSE305\\CSE305_BusManagement\\db\\schedule.txt";
    private static final String LINES_PATH = "e:\\AllAboutCode\\CSE305\\CSE305_BusManagement\\db\\lines.txt";

    // Private constructor for Builder pattern
    public BusSchedule() {
        loadLines();
        busSchedule = new HashMap<>();
        loadSchedule();
    }

    private void loadLines() {
        List<Line> lineList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LINES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String lineName = parts[0] + " " + parts[1];
                String busName = parts[2] + " " + parts[3];
                String routeName = parts[4] + " " + parts[5];

                Line newLine = new Line.Builder()
                    .lineName(lineName)
                    .build();
                lineList.add(newLine);
            }
        } catch (IOException e) {
            System.err.println("Error loading lines: " + e.getMessage());
        }
        lines = lineList.toArray(new Line[0]);
    }

    private void loadSchedule() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SCHEDULE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String time = parts[0];
                String lineName = parts[1] + " " + parts[2];

                for (Line l : lines) {
                    if (l.getLineName().equals(lineName)) {
                        busSchedule.put(time, l);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading schedule: " + e.getMessage());
        }
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCHEDULE_PATH, true))) {
            String scheduleData = String.format("%s %s", time, lineName);
            writer.write(scheduleData);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving schedule: " + e.getMessage());
        }
    }

    public HashMap<String, Line> getBusSchedule() {
        return this.busSchedule;
    }

    public void printSchedule() {
        for (Map.Entry<String, Line> entry : busSchedule.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getLineName());
        }
    }

    // Builder pattern
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