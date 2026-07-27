package app;

public class MediaFactory {
	
	public static Media createMedia(
            MediaType type,
            String title,
            String genre,
            int releaseYear,
            int additionalInformation) {

        if (type == MediaType.MOVIE) {
            return new Movie(
                    title,
                    genre,
                    releaseYear,
                    additionalInformation
            );
        }

        if (type == MediaType.TV_SHOW) {
            return new TVShow(
                    title,
                    genre,
                    releaseYear,
                    additionalInformation
            );
        }

        throw new IllegalArgumentException(
                "Unsupported media type."
        );
    }

}
