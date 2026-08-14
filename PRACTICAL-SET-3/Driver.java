public class Driver {

    public static void main(String[] args) {

        Points[] point = {
            new Points(1, 2),
            new Points(3, 4),
            new Points(1, 2),
            new Points(5, 6),
            new Points(3, 4),
            new Points(7, 8)
        };

        int distinct = 0;

        for (int i = 0; i < point.length; i++) {

            boolean found = false;

            for (int j = 0; j < i; j++) {

                if (point[i].equals(point[j])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                distinct++;
            }
        }

        System.out.println("Points:");

        for (Points p : point) {
            System.out.println(p);
        }

        System.out.println("\nDistinct: " + distinct);
    }
}