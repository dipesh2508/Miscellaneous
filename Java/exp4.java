import java.util.*;

class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }
}

class exp4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Cards: ");
        int n = scanner.nextInt();

        Map<String, List<Card>> cards = collectCards(n);

        System.out.println("\nDistinct Symbols are:");
        List<String> sortedSymbols = new ArrayList<>(cards.keySet());
        sortedSymbols.sort(null);
        for (String symbol : sortedSymbols) {
            System.out.println(symbol);
        }

        for (Map.Entry<String, List<Card>> entry : cards.entrySet()) {
            String symbol = entry.getKey();
            List<Card> cardList = entry.getValue();
            printSymbolCards(symbol, cardList);
        }

        scanner.close();
    }

    private static Map<String, List<Card>> collectCards(int n) {
        Map<String, List<Card>> cards = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter card %d:\n", i + 1);
            String symbol = scanner.next();
            int number = scanner.nextInt();

            Card card = new Card(symbol, number);

            if (!cards.containsKey(symbol)) {
                cards.put(symbol, new ArrayList<>());
            }
            cards.get(symbol).add(card);
        }

        scanner.close();

        return cards;
    }

    private static void printSymbolCards(String symbol, List<Card> cards) {
        System.out.println("\nCards in " + symbol + " Symbol");
        for (Card card : cards) {
            System.out.println(card);
        }
        int totalCards = cards.size();
        int sumOfNumbers = cards.stream().mapToInt(c -> c.number).sum();
        System.out.println("Number of cards: " + totalCards);
        System.out.println("Sum of Numbers: " + sumOfNumbers);
    }
}
