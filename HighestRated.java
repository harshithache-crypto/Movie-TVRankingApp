package app;

import java.util.List;

public class HighestRated implements Recommendations{
	
	@Override
    public Media recommend(List<Media> mediaItems) {

        if (mediaItems == null || mediaItems.isEmpty()) {
            return null;
        }

        Media highestRated = mediaItems.get(0);

        for (Media media : mediaItems) {
            if (media.getRating()
                    > highestRated.getRating()) {

                highestRated = media;
            }
        }

        return highestRated;
    }

}
