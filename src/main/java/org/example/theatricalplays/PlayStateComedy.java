package org.example.theatricalplays;

public class PlayStateComedy extends PlayState{

    @Override
    public int amountFor(Performance performance){
        int result = 30_000;
        if (performance.audience > 20) {
            result += 10_000 + 500 * (performance.audience - 20);
        }
        result += 300 * performance.audience;
        return result;
    };

    @Override
    public int creditsFor(Performance performance){
        var result = Math.max(performance.audience - 30, 0);
        // add extra credit for every 5 comedy attendees
        result += Math.floor(performance.audience / 5);
        return result;
    }
}
