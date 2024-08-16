package companies.adyne.card_network_identification;

import java.io.*;
import java.util.*;

/**
 * An entity to hold card range details. A card range is a pair of 12 digit numbers that
 * marks the boundaries of the range which is maped to the card network. The range boundaries are inclusive.
 */
final class CardRange {
    final String start;
    final String end;
    final String cardNetwork;

    CardRange(String start, String end, String cardNetwork) {
        this.start = start;
        this.end = end;
        this.cardNetwork = cardNetwork;
    }
}

final class CardNetworkCache {
    private final List<CardRange> cardRanges;

    CardNetworkCache(List<CardRange> cardRanges) {
        this.cardRanges = cardRanges;
    }

    /**
     * @param cardNumber 16 to 24 digit card number.
     * @return the card network for this cardNumber or null if the card number does not
     * fall into any valid range.
     */
    public String get(String cardNumber) {
        if (cardNumber.length() < 16 || cardNumber.length() > 24) {
            return null;
        }

        String cardNumberPrefix = cardNumber.substring(0, 12);

        for (CardRange cardRange : cardRanges) {
            if (cardNumberPrefix.compareTo(cardRange.start) >= 0 && cardNumberPrefix.compareTo(cardRange.end) <= 0) {
                return cardRange.cardNetwork;
            }
        }

        return null;
    }
}


/**
 * No changes required in the Solution class
 **/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        try (final Scanner scanner = new Scanner(System.in)) {
            List<CardRange> ranges = new ArrayList<>();

            String cardNumber = scanner.next();
            scanner.nextLine();

            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext()) {
                String start = scanner.next();
                String end = scanner.next();
                String cardNetwork = scanner.next();
                ranges.add(new CardRange(start, end, cardNetwork));
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            CardNetworkCache cache = new CardNetworkCache(ranges);
            if (cache != null) {
                bufferedWriter.write(String.valueOf(cache.get(cardNumber)));
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}


//4111111111111111
//400000000000,499999999999,visa
//500000000000,599999999999,mc

//visa