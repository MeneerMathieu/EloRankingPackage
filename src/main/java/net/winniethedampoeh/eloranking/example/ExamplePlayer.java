package net.winniethedampoeh.eloranking.example;


import net.winniethedampoeh.eloranking.IPlayer;

public class ExamplePlayer implements IPlayer {
    double rating;

    public ExamplePlayer(double rating) {
        this.rating = rating;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public void setRating(double newRating) {
        this.rating = newRating;
    }
}
