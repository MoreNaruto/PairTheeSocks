package service;

import java.util.HashMap;
import java.util.Map;

public class SockPairedService {
    private String[] sockColors;

    public SockPairedService(String... sockColors) {
        this.sockColors = sockColors;
    }

    public String outputOfSockPairs() {
        boolean hasPair = false;
        Map<String, Integer> sockColorToNumberOfEach = new HashMap<>(Map.of());
        for (String sockColor: sockColors) {
            if (sockColorToNumberOfEach.containsKey(sockColor)) {
                hasPair = true;
                sockColorToNumberOfEach.put(sockColor, sockColorToNumberOfEach.get(sockColor) + 1);
            } else {
                sockColorToNumberOfEach.put(sockColor, 1);
            }
        }
        if (!hasPair) {
            return "No pairs";
        } else {
            StringBuilder outputOfSockPair = new StringBuilder();
            for(Map.Entry sockColor: sockColorToNumberOfEach.entrySet()) {
                Integer numberOfPairOfSocks = (Integer) sockColor.getValue() / 2;
                if (numberOfPairOfSocks > 0) {
                    String pairString = numberOfPairOfSocks == 1 ? "pair, " : "pairs, ";
                    outputOfSockPair
                            .append(sockColor.getKey().toString())
                            .append(": ").append(numberOfPairOfSocks)
                            .append(" ")
                            .append(pairString);
                }
            }
            return outputOfSockPair.delete(outputOfSockPair.length() - 2, outputOfSockPair.length()).toString();
        }
    }
}
