package location;

public class GasStation extends Location {
    private int nrTertminals;
    private double gasPrice;

    public GasStation(String name, double x, double y, int nrTertminals, double gasPrice) {
        super(name, x, y);
        this.nrTertminals = nrTertminals;
        this.gasPrice = gasPrice;
    }


    public GasStation(String name, double x, double y) {
        super(name, x, y);
    }


    public int getNrTertminals() {
        return nrTertminals;
    }

    public void setNrTertminals(int nrTertminals) {
        this.nrTertminals = nrTertminals;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }
}
