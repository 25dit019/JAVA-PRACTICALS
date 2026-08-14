public class Thermostat {

    private String location;
    private int temperature;

    private static final int MIN = 16;
    private static final int MAX = 30;

    private static int activeCount = 0;

    public Thermostat(String location, int startTemp) {
        this.location = location;

        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }

        activeCount++;
    }

    public Thermostat(String location) {
        this(location, 22);
    }

    public void raise() {
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (30)");
        }
    }

    public void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (16)");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }

    public static int getActiveCount() {
        return activeCount;
    }

    public static void main(String[] args) {

        Thermostat t1 = new Thermostat("Bedroom", 20);
        Thermostat t2 = new Thermostat("Living Room");

    
        System.out.println("Thermostat 2 Location: " + t2.getLocation());
        System.out.println("Thermostat 2 Temperature: " + t2.getTemperature());

        System.out.println("\nRaising temperature:");

        for (int i = 1; i <= 10; i++) {
            t1.raise();
            System.out.println("Temperature: " + t1.getTemperature());
        }

        System.out.println("\nLowering temperature:");

        for (int i = 1; i <= 20; i++) {
            t1.lower();
            System.out.println("Temperature: " + t1.getTemperature());
        }

        System.out.println("\nActive thermostats: " + Thermostat.getActiveCount());
    }
}