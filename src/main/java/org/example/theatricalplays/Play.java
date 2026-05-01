package org.example.theatricalplays;

public class Play {

    public String name;
    public String type;
    public PlayState playState;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
        this.playState = setPlayState(type);
    }

    private PlayState setPlayState(String type) {
        return switch (type) {
            case "tragedy" -> new PlayStateTragedy();
            case "comedy" -> new PlayStateComedy();
            default -> throw new Error("unknown type: %s".formatted(type));
        };
    }

    int amountFor(Performance performance) {
        return playState.amountFor(performance);
    }

    int creditsFor(Performance performance) {
        var result = Math.max(performance.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(type)) result += Math.floor(performance.audience / 5);
        return result;
    }
}
