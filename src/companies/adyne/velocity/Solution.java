package companies.adyne.velocity;

import java.util.*;
import java.time.*;

public class Solution {

    static class Payment {
        private final String paymentId;
        private final Instant timestamp;
        private final String hashedCardNumber;

        public Payment(String paymentId, Instant timestamp, String hashedCardNumber) {
            this.paymentId = paymentId;
            this.timestamp = timestamp;
            this.hashedCardNumber = hashedCardNumber;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public Instant getTimestamp() {
            return timestamp;
        }

        public String getHashedCardNumber() {
            return hashedCardNumber;
        }
    }

    interface VelocityProvider {

        /**
         * This method is called during the payment risk assessment.
         * <p>
         * It returns how many times the card in the Payment has been seen in the last minutes/seconds/hours as
         * defined in the {@code duration} parameter at the time the payment is being processed.
         *
         * @param payment  The payment being processed
         * @param duration The interval to count
         * @return The number of times the card was used in the interval defined in duration.
         */
        int getCardUsageCount(Payment payment, Duration duration);


        /**
         * After the payment is processed this method is called.
         *
         * @param payment The payment that has been processed.
         */
        void registerPayment(Payment payment);

        /**
         * @return Instance of a Velocity provider
         */
        static VelocityProvider getProvider() {
            //throw new UnsupportedOperationException("not implemented");
            VelocityProviderImplementation velocityProviderImplementation = new VelocityProviderImplementation();
            Rule rule1 = new Rule(5, Duration.ofMinutes(10));
            Rule rule2 = new Rule(10, Duration.ofHours(10));

            //velocityProviderImplementation.addRule(rule1);
            //velocityProviderImplementation.addRule(rule2);
            return velocityProviderImplementation;
        }
    }

    static class Rule {
        private final int maxUsage;
        private final Duration duration;

        public Rule(int maxUsage, Duration duration) {
            this.maxUsage = maxUsage;
            this.duration = duration;
        }

        public int getMaxUsage() {
            return maxUsage;
        }

        public Duration getDuration() {
            return duration;
        }

        public boolean isPaymentBlocked(VelocityProvider velocityProvider, Payment payment) {
            int usageCount = velocityProvider.getCardUsageCount(payment, duration);
            return usageCount >= maxUsage;
        }

        @Override
        public String toString() {
            return "Rule{" +
                    "maxUsage=" + maxUsage +
                    ", duration=" + duration +
                    '}';
        }
    }

    static class VelocityProviderImplementation implements VelocityProvider {

        private final List<Payment> payments;
        private final List<Rule> rules;

        public VelocityProviderImplementation() {
            this.payments = new ArrayList<>();
            this.rules = new ArrayList<>();
        }

        @Override
        public int getCardUsageCount(Payment payment, Duration duration) {
            Instant endInstant = payment.getTimestamp();
            Instant startInstant = endInstant.minus(duration);

            int cardUsageCount = 0;
            for (Payment p : payments) {
                if (p.getHashedCardNumber().equals(payment.getHashedCardNumber()) &&
                        !p.getTimestamp().isBefore(startInstant)) {
                    cardUsageCount++;
                }
            }

            return cardUsageCount;
        }

        @Override
        public void registerPayment(Payment payment) {
            for (Rule rule : rules) {
                if (rule.isPaymentBlocked(this, payment)) {
                    System.out.println("Payment blocked due to rule: " + rule);
                    return;
                }
            }
            payments.add(payment);
        }

        public void addRule(Rule rule) {
            rules.add(rule);
        }
    }

    public static void main(String args[]) throws Exception {
        final VelocityProvider velocityProvider = VelocityProvider.getProvider();

        try (final Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                final String assoc = scanner.next();
                final String[] split = assoc.split(":");

                final String operation = split[0];

                if (split.length == 3 && "register".equals(operation)) {
                    final long timestamp = Long.parseLong(split[1]);
                    final String hashedCardNumber = split[2];
                    final Payment payment = new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(timestamp), hashedCardNumber);

                    velocityProvider.registerPayment(payment);
                } else if (split.length == 4 && "get".equals(operation)) {
                    final long queryTime = Long.parseLong(split[1]);
                    final String hashedCardNumber = split[2];
                    final long durationInSeconds = Long.parseLong(split[3]);
                    System.out.println(velocityProvider.getCardUsageCount(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(queryTime), hashedCardNumber), Duration.ofSeconds(durationInSeconds)));
                } else {
                    throw new RuntimeException("Invalid test input");
                }
            }
        }
    }
}

//register:1662123600000:c1
//register:1662123620000:c1
//register:1662123621000:c2
//register:1662123630000:c1
//register:1662123645000:c2
//get:1662123660000:c1:60
//get:1662123660000:c1:35
//get:1662123660000:c1:15
//get:1662123660000:c3:75

//        3
//        1
//        0
//        0