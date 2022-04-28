import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Standing {
    private String position;
    private String positionText;
    private String points;
    private String wins;

    @JsonProperty("Driver")
    private Driver driver;

    @JsonProperty("Constructors")
    private List<Constructor> constructors;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
    }

    @Override
    public String toString() {
        return "Standing{" +
                "position='" + position + '\'' +
                ", positionText='" + positionText + '\'' +
                ", points='" + points + '\'' +
                ", wins='" + wins + '\'' +
                ", driver=" + driver +
                ", constructors=" + constructors +
                '}';
    }
}
