package org.example.theatricalplays;

public class Play {

    public String name;
    public String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    int amountFor(Performance performance) {
        int result = 0;
        switch (type) {
            case "tragedy":
                result = 40000;
                if (performance.audience > 30) {
                    result += 1000 * (performance.audience - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (performance.audience > 20) {
                    result += 10000 + 500 * (performance.audience - 20);
                }
                result += 300 * performance.audience;
                break;
            default:
                throw new Error("unknown type: %s".formatted(type));
        }
        return result;
    }

    int creditsFor(Performance performance) {
        var result = Math.max(performance.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(type)) result += Math.floor(performance.audience / 5);
        return result;
    }
}
