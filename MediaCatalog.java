package app;

import java.util.ArrayList;
import java.util.List;

public class MediaCatalog {

    private List<Media> mediaItems;

    public MediaCatalog() {
        mediaItems = new ArrayList<>();
    }

    public void addMedia(Media media) {
        mediaItems.add(media);
    }

    public List<Media> getAllMedia() {
        return new ArrayList<>(mediaItems);
    }

    public List<Media> search(String text) {

        List<Media> results = new ArrayList<>();

        for (Media media : mediaItems) {

            if (media.getTitle()
                    .toLowerCase()
                    .contains(text.toLowerCase())) {

                results.add(media);
            }
        }

        return results;
    }

    public void displayAll() {

        System.out.println("\n--- MEDIA CATALOG ---");

        for (int i = 0; i < mediaItems.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + mediaItems.get(i)
            );
        }
    }
}