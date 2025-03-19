
public class Route implements IRoute {
    private String routeName;
    private String start;
    private String end;
    private Long distance;
    private Long duration;
    private double price;

    // Private constructor for Builder pattern
    private Route() {}

    // Getters
    @Override
    public String getRouteName() {
        return routeName;
    }

    @Override
    public String getStart() {
        return start;
    }

    @Override
    public String getEnd() {
        return end;
    }

    @Override
    public Long getDistance() {
        return distance;
    }

    @Override
    public String getDuration() {
        long hours = duration / 60;
        long minutes = duration % 60;
        return hours + "h " + minutes + "m";
    }

    @Override
    public double getPrice() {
        return price;
    }

    // Setters
    @Override
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Override
    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public void setDistance(Long distance) {
        this.distance = distance;
        this.price = distance * 5000; // Update price when distance changes
    }

    @Override
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    // Static Builder class
    public static class Builder {
        private Route route;

        public Builder() {
            route = new Route();
        }

        public Builder routeName(String routeName) {
            route.setRouteName(routeName);
            return this;
        }

        public Builder start(String start) {
            route.setStart(start);
            return this;
        }

        public Builder end(String end) {
            route.setEnd(end);
            return this;
        }

        public Builder distance(Long distance) {
            route.setDistance(distance);
            return this;
        }

        public Builder duration(Long duration) {
            route.setDuration(duration);
            return this;
        }

        public Route build() {
            return route;
        }
    }
}