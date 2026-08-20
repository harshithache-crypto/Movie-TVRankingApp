package app;

public abstract class MediaCreator {

    public abstract Media createMedia(
            String title,
            String genre,
            int releaseYear,
            int extraInfo
    );
}