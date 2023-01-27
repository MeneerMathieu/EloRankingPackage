package net.winniethedampoeh.eloranking;

public class Elo {

    protected static final double WIN = 1;
    protected static final double DRAW =  0.5;
    protected static final double LOSE = 0;

    protected static double getWinProbability(IPlayer a, IPlayer b){
        double winProbabilityPlayerA = 1 / (1 + Math.pow(10,  ( b.getRating() - a.getRating())/400));
        return winProbabilityPlayerA;
    }

    protected static double getExpectedScore(IPlayer a, IPlayer b) {
        return getWinProbability(a, b) * WIN;
    }

    protected static double getNewRating(IPlayer a, IPlayer b, double scorePlayerA){
        double newRatingPlayerA = a.getRating() + 32 * (scorePlayerA - getExpectedScore(a, b));
        return  newRatingPlayerA;
    }

    protected static void updatePlayers(IPlayer a, IPlayer b, double pointsA, double pointsB){
        double newRatingA = getNewRating(a, b, pointsA);
        double newRatingB = getNewRating(b, a, pointsB);
        a.setRating(newRatingA);
        b.setRating(newRatingB);
    }

}
