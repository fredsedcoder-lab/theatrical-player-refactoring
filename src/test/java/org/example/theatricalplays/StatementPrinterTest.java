package org.example.theatricalplays;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.approvaltests.Approvals.verify;


public class StatementPrinterTest {
    @Test
    void simplePrintTest(){
        var plays = Map.of(
                "hamlet", new Play("Hamlet", "tragedy"),
                "as-like", new Play("As You Like It", "comedy"),
                "othello", new Play("Othello", "tragedy")
        );
        var invoice = new Invoice("BigCo", java.util.List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        ));
        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }
}
