package main.java.service;

import org.junit.jupiter.api.Test;
import service.SockPairedService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SockPairedServiceTest {
    SockPairedService service = null;

    @Test
    public void outputOfSockPairs_doesNotHaveAnySockPair() {
        String[] sockColors = {"pink", "red", "blue", "green"};
        service = new SockPairedService(sockColors);

        String actualOutput = service.outputOfSockPairs();
        assertEquals("No pairs", actualOutput);
    }

    @Test
    public void outputOfSockPairs_hasPairOfSocks() {
        String[] sockColors = {"pink", "pink", "blue", "green"};
        service = new SockPairedService(sockColors);

        String actualOutput = service.outputOfSockPairs();
        assertEquals("pink: 1 pair", actualOutput);
    }

    @Test
    public void outputOfSockPairs_hasMultiplePairOfSocks() {
        String[] sockColors = {"pink", "pink", "blue", "green", "green", "pink", "pink", "pink", "pink", "green", "green", "yellow", "yellow", "yellow", "red"};
        service = new SockPairedService(sockColors);

        String actualOutput = service.outputOfSockPairs();
        assertEquals("pink: 3 pairs, green: 2 pairs, yellow: 1 pair", actualOutput);
    }
}