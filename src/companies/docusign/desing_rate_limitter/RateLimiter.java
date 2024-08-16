package companies.docusign.desing_rate_limitter;

import java.util.*;

class Rule {
    int maxNumberOfRequests;
    int windowSize;

    public Rule(int numberOfRequest, int windowSize) {
        this.maxNumberOfRequests = numberOfRequest;
        this.windowSize = windowSize;
    }
}

class Response {
    String status;
    String message;

    @Override
    public String toString() {
        return "{" + "status: " + status + "," + " message: " + message + "}";
    }
}

class RateLimiter {
    Map<String, Deque<Integer>> domainTimeStampMap;
    List<Rule> rulesList;

    public RateLimiter() {
        this.domainTimeStampMap = new HashMap<>();
        this.rulesList = new LinkedList<>();
    }

    public void addRule(Rule rule) {
        rulesList.add(rule);
    }

    public String[] getRequestStatus(String[] requests) {
        String[] result = new String[requests.length];

        for (int currentTimeStamp = 0; currentTimeStamp < requests.length; currentTimeStamp++) {
            Response response = new Response();

            String domain = requests[currentTimeStamp];

            boolean isRequestDropped = false;
            for (Rule rule : rulesList) {
                if (!isValidRequest(currentTimeStamp, domain, rule)) {
                    response.status = "429";
                    response.message = "Too many requests";
                    isRequestDropped = true;
                    break;
                }
            }

            if (!isRequestDropped) {
                processRequest(currentTimeStamp, domain);

                response.status = "200";
                response.message = "OK";
            }

            result[currentTimeStamp] = response.toString();
        }
        return result;
    }

    private void processRequest(int currentTimeStamp, String domain) {
        Deque<Integer> timeStampQueue = domainTimeStampMap.getOrDefault(domain, new LinkedList<>());
        timeStampQueue.offerLast(currentTimeStamp);
        domainTimeStampMap.put(domain, timeStampQueue);
    }

    private boolean isValidRequest(int currentTimeStamp, String domain, Rule rule) {
        Deque<Integer> timeStampQueue = domainTimeStampMap.getOrDefault(domain, new LinkedList<>());

        while (!timeStampQueue.isEmpty() && timeStampQueue.peekFirst() <= currentTimeStamp - rule.windowSize) {
            timeStampQueue.pollFirst();
        }

        return timeStampQueue.size() < rule.maxNumberOfRequests;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        Rule rule1 = new Rule(5, 30);
        Rule rule2 = new Rule(2, 5);

        rateLimiter.addRule(rule1);
        rateLimiter.addRule(rule2);

        //String[] requests = {"www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com", "www.abc.com", "www.pqr.com", "www.pqr.com"};
        String[] requests = {"www.xyz.com", "www.abc.com", "www.xyz.com", "www.pqr.com", "www.abc.com", "www.xyz.com", "www.xyz.com", "www.abc.com", "www.xyz.com" };

        String[] results = rateLimiter.getRequestStatus(requests);

        for (String result : results) {
            System.out.println(result);
        }
    }
}

