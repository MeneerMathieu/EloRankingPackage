package net.winniethedampoeh.eloranking;

/**
 * <p>This is the only class you need to use. To make a new elo calculation use</p>
 * <blockquote><pre>{@code Match match = new Match(player1, player2}</pre></blockquote>
 * <p>Then you have to enter the outcome of the match. It can either be a win, draw, or loss. Enter the outcome
 * from the perspective of player1.</p>
 * <blockquote><pre>{@code match.setResult(Outcome.WIN)}</pre></blockquote>
 * <p>To then calculate the rankings of the players you can use:</p>
 * <blockquote><pre>{@code match.updateRatings()}</pre></blockquote>
 * <p>The player objects are then automatically updated to get the correct rating.</p>
 */
public class Match {
    private MatchResult result_player1;
    private MatchResult result_player2;


    public Match(IPlayer player1, IPlayer player2) {

        this.result_player1 = new MatchResult(player1);
        this.result_player2 = new MatchResult(player2);

        this.result_player1.setOldRating(player1.getRating());
        this.result_player2.setOldRating(player2.getRating());
    }

    /**
     * @param outcome from perspective of player1
     */
    public void setOutcome(Outcome outcome){
        result_player1.setOutcome(outcome);
        switch (outcome){
            case WIN -> result_player2.setOutcome(Outcome.LOSE);
            case DRAW -> result_player2.setOutcome(Outcome.DRAW);
            case LOSE -> result_player2.setOutcome(Outcome.WIN);
        }
    }

    /**
     * Before you can use this function you have to set the result of the match using:
     * <pre>{@code setResult(Outcome o)}</pre>
     */
    public void updateRatings(){
        Elo.updatePlayers(result_player1.getPlayer(), result_player2.getPlayer(), result_player1.getScore(), result_player2.getScore());

        this.result_player1.setNewRating(result_player1.getPlayer().getRating());
        this.result_player2.setNewRating(result_player2.getPlayer().getRating());
        this.result_player1.calculateChange();
        this.result_player2.calculateChange();
    }


    public MatchResult getResultPlayer1() {
        return result_player1;
    }

    protected void setResult_player1(MatchResult result_player1) {
        this.result_player1 = result_player1;
    }

    public MatchResult getResultPlayer2() {
        return result_player2;
    }

    protected void setResultPlayer2(MatchResult result_player2) {
        this.result_player2 = result_player2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "result_player1=" + result_player1 +
                ", result_player2=" + result_player2 +
                '}';
    }
}
