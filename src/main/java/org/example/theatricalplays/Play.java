package org.example.theatricalplays;

public class Play {

    public String name;
    public PlayState playState;

    public Play(String name, String type) {
        this.name = name;
        this.playState = setPlayState(type);
    }

    public void setType(String type){
        setPlayState(type);
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
       return playState.creditsFor(performance);
    }
}
