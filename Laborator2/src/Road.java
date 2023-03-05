public class Road {
    private RoadType type;
    private int length;
    private int speedLimit;

    public Road(RoadType newType, int newLength, int newSpeedLimit) {
        type = newType;
        length = newLength;
        speedLimit = newSpeedLimit;
    }

    public Road() {
    }

    @Override
    public String toString() {
        return "Application.Road{" +
                "type=" + type +
                ", length=" + length + " km" +
                ", speedLimit=" + speedLimit +
                '}';
    }

    public RoadType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}
