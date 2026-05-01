package org.example.theatricalplays;

public class PlayStateComedy extends PlayState{
    @Override
    public int amountFor(Performance performance){
        int result = 30000;
        if (performance.audience > 20) {
            result += 10000 + 500 * (performance.audience - 20);
        }
        result += 300 * performance.audience;
        return result;
    };
}
