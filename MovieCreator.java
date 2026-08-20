package app;

public class MovieCreator extends MediaCreator {

    @Override
    public Media createMedia(
            String title,
            String genre,
            int releaseYear,
            int runtimeMinutes) {

        return new Movie(
                title,
                genre,
                releaseYear,
                runtimeMinutes
        );
    }
}