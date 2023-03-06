package road;

import location.Location;

public class Country extends Road {
    private static int speedLimit = 70;

    public Country(String name, int length) {
        super(name, length);
    }
}
