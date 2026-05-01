package org.example.theatricalplays;

public class PlayStateTragedy extends PlayState {
    @Override
    public int amountFor(Performance performance) {
        int result = 40000;
        if (performance.audience > 30) {
            result += 1000 * (performance.audience - 30);
        }
        return result;
    }

}
