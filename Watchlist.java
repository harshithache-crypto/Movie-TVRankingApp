package app;

import java.util.ArrayList;
import java.util.List;

public class Watchlist {
	
	private List<Media> titles;

    public Watchlist() {
        titles = new ArrayList<>();
    }

    public void addTitle(Media media) {
        titles.add(media);
    }

    public void removeTitle(Media media) {
        titles.remove(media);
    }

    public void displayWatchlist() {
        if (titles.isEmpty()) {
            System.out.println("Watchlist is empty.");
            return;
        }

        System.out.println("\nWatchlist:");

        for (int i = 0; i < titles.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + titles.get(i)
            );
        }
    }

    public List<Media> getTitles() {
        return new ArrayList<>(titles);
    }

    public int getNumberOfTitles() {
        return titles.size();
    }

}
