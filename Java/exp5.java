import java.util.*;

class Card {
    private String symbol;
    private int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }
}

public class exp5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Card> cards = new HashSet<>();

        while (cards.size() < 4) {
            System.out.println("Enter a card:");
            String symbol = scanner.next();
            int number = scanner.nextInt();
            Card card = new Card(symbol, number);
            cards.add(card);
        }

        System.out.println("Four symbols gathered in " + cards.size() + " cards.");
        System.out.println("Cards in Set are:");
        List<Card> sortedCards = new ArrayList<>(cards);
        Collections.sort(sortedCards, Comparator.comparing(Card::getSymbol));
        for (Card card : sortedCards) {
            System.out.println(card);
        }

        scanner.close();
    }
}
