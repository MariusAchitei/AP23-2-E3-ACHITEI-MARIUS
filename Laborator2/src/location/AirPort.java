package location;

public class AirPort extends Location {
    private int nrTerminals;

    public AirPort(String name, double x, double y, int nrTerminals) {
        super(name, x, y);
        this.nrTerminals = nrTerminals;
    }

    public AirPort(String name, double x, double y) {
        super(name, x, y);
    }

    public int getNrTerminals() {
        return nrTerminals;
    }

    public void setNrTerminals(int nrTerminals) {
        this.nrTerminals = nrTerminals;
    }

}
