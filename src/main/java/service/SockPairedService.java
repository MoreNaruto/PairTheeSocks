package service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SockPairedService {
    private String[] sockColors;

    public SockPairedService(String... sockColors) {
        this.sockColors = sockColors;
    }

    public String outputOfSockPairs() {
        boolean hasPair = false;
        Map<String, Integer> sockColorToNumberOfEach = new LinkedHashMap<>(Map.of());
        for (String sockColor : sockColors) {
            if (sockColorToNumberOfEach.containsKey(sockColor)) {
                hasPair = true;
                sockColorToNumberOfEach.put(sockColor, sockColorToNumberOfEach.get(sockColor) + 1);
            } else {
                sockColorToNumberOfEach.put(sockColor, 1);
            }
        }
        String unmatchedStringValue = unmatchedString(sockColorToNumberOfEach);

        if (!hasPair) {
            return "No pairs" + unmatchedStringValue;
        } else {
            StringBuilder outputOfSockPair = new StringBuilder();
            for (Map.Entry sockColor : sockColorToNumberOfEach.entrySet()) {
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
            return
                    outputOfSockPair.delete(outputOfSockPair.length() - 2, outputOfSockPair.length()).append(unmatchedStringValue).toString();
        }
    }

    private String unmatchedString(Map<String, Integer> sockColors) {
        StringBuilder unmatchedValue = new StringBuilder();
        for (Map.Entry<String, Integer> sockColor : sockColors.entrySet()) {
            if (sockColor.getValue() % 2 == 1) {
                unmatchedValue.append(" ").append(sockColor.getKey());
            }

        }

        String initialUnmatchedValue = unmatchedValue.toString();
        return (initialUnmatchedValue.isEmpty() ? "" : ", Unmatched:" + initialUnmatchedValue);
    }
}
