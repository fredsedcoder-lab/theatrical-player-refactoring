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
    @Test
    void allComedyPrintTest(){
        var plays = Map.of(
                "madame", new Play("Madame", "comedy"),
                "as-like", new Play("As You Like It", "comedy"),
                "scapin", new Play("Scapin", "comedy")
        );
        var invoice = new Invoice("BigCo", java.util.List.of(
                new Performance("madame", 4),
                new Performance("as-like", 15),
                new Performance("scapin", 40)
        ));
        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }
    @Test
    void allTragedyPrintTest(){
        var plays = Map.of(
                "hamlet", new Play("Hamlet", "tragedy"),
                "misanthrope", new Play("Misanthrope", "tragedy"),
                "othello", new Play("Othello", "tragedy")
        );
        var invoice = new Invoice("BigCo", java.util.List.of(
                new Performance("hamlet", 4),
                new Performance("misanthrope", 30),
                new Performance("othello", 40)
        ));
        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }
}
