package companies.adyne.card_network_identification;

import java.io.*;
import java.util.*;

//4111111111111111
//400000000000,499999999999,visa
//500000000000,599999999999,mc

//visa

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

class Solution {
    public static void main(String[] args) throws IOException {
        List<CardRange> ranges = new ArrayList<>();
        ranges.add(new CardRange("400000000000","499999999999", "visa"));
        ranges.add(new CardRange("500000000000","599999999999", "mc"));

        CardNetworkCache cache = new CardNetworkCache(ranges);

        System.out.println(cache.get("4111111111111111"));
    }
}
