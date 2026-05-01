package org.example.theatricalplays;

public class PlayStateTragedy extends PlayState {

    @Override
    public int amountFor(Performance performance) {
        int result = 40_000;
        result += Math.max(performance.audience - 30, 0) * 1000;
        return result;
    }

}
