package org.example.theatricalplays;

public abstract class PlayState {

     public abstract int amountFor(Performance performance);

     public int creditsFor(Performance performance) {
          return  Math.max(performance.audience - 30, 0);
     }
}
