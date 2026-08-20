package app;

public class TVShow extends Media {

    private int numberOfSeasons;

    public TVShow(
            String title,
            String genre,
            int releaseYear,
            int numberOfSeasons) {

        super(title, genre, releaseYear);

        this.numberOfSeasons = numberOfSeasons;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    @Override
    public String getMediaType() {
        return "TV Show";
    }

    @Override
    public String toString() {
        return getMediaType()
                + ": "
                + super.toString()
                + " | Seasons: "
                + numberOfSeasons;
    }
}