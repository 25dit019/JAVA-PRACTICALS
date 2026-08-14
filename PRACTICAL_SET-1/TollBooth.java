
import java.util.Scanner;

public class TollBooth {

    record Vehicle(String number, String type) {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {

            System.out.print("Enter vehicle number: ");
            String number = sc.nextLine();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type: ");
            String type = sc.nextLine();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type().toLowerCase()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            totalToll = totalToll + toll;

            if (v.type().equalsIgnoreCase("bike")) {
                bikeCount++;
            } else if (v.type().equalsIgnoreCase("car")) {
                carCount++;
            } else if (v.type().equalsIgnoreCase("truck")) {
                truckCount++;
            }
        }

        String mostFrequent;

        if (carCount >= bikeCount && carCount >= truckCount) {
            mostFrequent = "car";
        } else if (bikeCount >= carCount && bikeCount >= truckCount) {
            mostFrequent = "bike";
        } else {
            mostFrequent = "truck";
        }

        System.out.println("Total toll: " + totalToll);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}