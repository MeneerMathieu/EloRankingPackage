package net.winniethedampoeh.eloranking;

public class MatchResult {
    private final IPlayer player;
    private Outcome outcome;
    private double score = -1;
    private double oldRating = -1;
    private double newRating = -1;
    private double change = -1024;

    protected MatchResult(IPlayer player) {
        this.player = player;
    }

    protected IPlayer getPlayer() {
        return player;
    }

    public Outcome getOutcome() {
        if (outcome == null) throw new FieldNotSetException("Outcome of match not set");
        return outcome;
    }

    protected void setOutcome(Outcome outcome) {
        this.outcome = outcome;
        switch (outcome){
            case WIN -> score = Elo.WIN;
            case DRAW -> score = Elo.DRAW;
            case LOSE -> score = Elo.LOSE;
        }
    }

    public double getOldRating() {
        if (oldRating == -1) throw new FieldNotSetException("oldRating not set.");
        return oldRating;
    }

    protected void setOldRating(double oldRating) {
        this.oldRating = oldRating;
    }

    public double getNewRating() {
        if (newRating == -1) throw new FieldNotSetException("newRating not set.");
        return newRating;
    }

    protected void setNewRating(double newRating) {
        this.newRating = newRating;
    }

    public double getScore() {
        if (score == -1) throw new FieldNotSetException("score not calculated. Enter outcome with setOutcome(Outcome o)");
        return score;
    }

    protected double calculateChange(){
        this.change = this.getNewRating() - this.getOldRating();
        return this.change;
    }

    public double getChange() {
        if (change == -1024) throw new FieldNotSetException("result not calculated yet. Use calculateResult()");
        return change;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "player=" + player +
                ", outcome=" + outcome +
                ", score=" + score +
                ", oldRating=" + oldRating +
                ", newRating=" + newRating +
                ", result=" + change +
                '}';
    }
}
