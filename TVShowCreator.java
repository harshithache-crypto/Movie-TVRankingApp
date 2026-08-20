package app;

public class TVShowCreator extends MediaCreator {

    @Override
    public Media createMedia(
            String title,
            String genre,
            int releaseYear,
            int numberOfSeasons) {

        return new TVShow(
                title,
                genre,
                releaseYear,
                numberOfSeasons
        );
    }
}