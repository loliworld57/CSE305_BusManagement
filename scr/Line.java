
public class Line implements ILine {

    private String lineName;
    private Route route;
    private Bus bus;

    // Private constructor - objects will be created using Builder
    private Line() {}

    @Override
    public String getLineName() {
        return lineName;
    }

    @Override
    public Route getRoute() {
        return route;
    }

    @Override
    public Bus getBus() {
        return bus;
    }

    @Override
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    // Static Builder class
    public static class Builder {
        private Line line;

        public Builder() {
            line = new Line();
        }

        public Builder lineName(String lineName) {
            line.setLineName(lineName);
            return this;
        }

        public Builder route(Route route) {
            line.setRoute(route);
            return this;
        }

        public Builder bus(Bus bus) {
            line.setBus(bus);
            return this;
        }

        public Line build() {
            return line;
        }
    }
}