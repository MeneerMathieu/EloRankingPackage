package net.winniethedampoeh.eloranking.example;


import net.winniethedampoeh.eloranking.Match;
import net.winniethedampoeh.eloranking.Outcome;

public class ExampleApplication {

    public static void main(String[] args){
        ExamplePlayer player1 = new ExamplePlayer(1234);
        ExamplePlayer player2 = new ExamplePlayer(1357);

        Match match = new Match(player1, player2);
        match.setOutcome(Outcome.WIN);
        match.updateRatings();

        System.out.println();
        System.out.println(" ---------------------------- RESULTS: ---------------------------- ");
        System.out.println("    Old rating player 1: " + (int) match.getResultPlayer1().getOldRating());
        System.out.println("    New rating player 1: " + (int) match.getResultPlayer1().getNewRating());
        System.out.println("                 Change: " + (int) match.getResultPlayer1().getChange());
        System.out.println();
        System.out.println("    Old rating player 2: " + (int) match.getResultPlayer2().getOldRating());
        System.out.println("    New rating player 2: " + (int) match.getResultPlayer2().getNewRating());
        System.out.println("                 Change: " + (int) match.getResultPlayer2().getChange());
        System.out.println(" ------------------------------------------------------------------ ");
    }
}
