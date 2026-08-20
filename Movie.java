package app;

public class Movie extends Media {

    private int runtimeMinutes;

    public Movie(
            String title,
            String genre,
            int releaseYear,
            int runtimeMinutes) {

        super(title, genre, releaseYear);

        this.runtimeMinutes = runtimeMinutes;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    @Override
    public String getMediaType() {
        return "Movie";
    }

    @Override
    public String toString() {
        return getMediaType()
                + ": "
                + super.toString()
                + " | Runtime: "
                + runtimeMinutes
                + " minutes";
    }
}