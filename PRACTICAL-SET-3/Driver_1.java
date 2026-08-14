

public class Driver_1 {
    public static void main(String[] args) {

        Card[] cards = new Card[6];
        Card[] input = {
                new Card("Ace", "Spades"),
                new Card("King", "Hearts"),
                new Card("Queen", "Diamonds"),
                new Card("Ace", "Spades"),     // Duplicate
                new Card("Jack", "Clubs"),
                new Card("King", "Hearts")     // Duplicate
        };
        int size = 0;
        boolean duplicatePrinted = false;
        for (Card card : input) {
            boolean duplicate = false;
            for (int i = 0; i < size; i++) {
                if (cards[i].equals(card)) {
                    duplicate = true;
                    if (!duplicatePrinted) {
                        System.out.println("Duplicate found: " + card);
                        duplicatePrinted = true;
                    }
                    break;
                }
            }
            cards[size++] = card;
        }
    }   
}

