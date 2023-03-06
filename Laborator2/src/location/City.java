package location;

public class City extends Location {
    private int population;

    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }

    public City(String name, int x, int y) {
        super(name, x, y);
        population = 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.deleteCharAt(s.length() - 1);
        s.append(", population=");
        s.append(population);
        s.append(" }");
        return s.toString();
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
