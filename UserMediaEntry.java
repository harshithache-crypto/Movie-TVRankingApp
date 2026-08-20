package app;

public class UserMediaEntry {

    private Media media;

    private MediaState state;

    private double rating;
    private String comment;

    private int currentSeason;

    public UserMediaEntry(Media media) {

        this.media = media;

        this.state =
                new WantToWatchState();

        this.rating = 0.0;
        this.comment = "";
        this.currentSeason = 0;
    }

    public UserMediaEntry(
            Media media,
            MediaState state) {

        this.media = media;
        this.state = state;

        this.rating = 0.0;
        this.comment = "";
        this.currentSeason = 0;
    }

    public Media getMedia() {
        return media;
    }

    public MediaState getState() {
        return state;
    }

    public void setState(MediaState state) {
        this.state = state;
    }

    public String getStatus() {
        return state.getName();
    }

    public void advanceStatus() {
        state.next(this);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {

        if (rating < 0 || rating > 10) {

            throw new IllegalArgumentException(
                    "Rating must be between 0 and 10."
            );
        }

        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {

        if (comment == null) {
            this.comment = "";
        } else {
            this.comment = comment;
        }
    }

    public int getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(
            int currentSeason) {

        if (!(media instanceof TVShow)) {

            throw new IllegalStateException(
                    "Season tracking only applies to TV shows."
            );
        }

        TVShow show =
                (TVShow) media;

        if (currentSeason < 1
                || currentSeason
                > show.getNumberOfSeasons()) {

            throw new IllegalArgumentException(
                    "Season must be between 1 and "
                            + show.getNumberOfSeasons()
                            + "."
            );
        }

        this.currentSeason =
                currentSeason;
    }

    @Override
    public String toString() {

        String result =
                media.getTitle()
                        + " | "
                        + getStatus();

        if (state instanceof WatchingState
                && media instanceof TVShow) {

            result +=
                    " | Season "
                    + currentSeason;
        }

        if (state instanceof WatchedState) {

            result +=
                    " | Rating: "
                    + rating
                    + "/10";

            if (!comment.isBlank()) {

                result +=
                        " | Comment: "
                        + comment;
            }
        }

        return result;
    }
}