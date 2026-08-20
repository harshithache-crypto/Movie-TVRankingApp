package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenrePreferenceStrategy
        implements RecommendationStrategy {

    @Override
    public Media recommend(
            List<UserMediaEntry> watched,
            List<Media> candidates) {

        if (watched.isEmpty()) {

            return null;
        }

        Map<String, Double>
                totals = new HashMap<>();

        Map<String, Integer>
                counts = new HashMap<>();

        Set<String>
                watchedTitles =
                new HashSet<>();

        for (UserMediaEntry entry
                : watched) {

            String genre =
                    entry.getMedia()
                         .getGenre();

            watchedTitles.add(
                    entry.getMedia()
                         .getTitle()
                         .toLowerCase()
            );

            totals.put(
                    genre,
                    totals.getOrDefault(
                            genre,
                            0.0
                    )
                            + entry.getRating()
            );

            counts.put(
                    genre,
                    counts.getOrDefault(
                            genre,
                            0
                    )
                            + 1
            );
        }

        String favoriteGenre = null;
        double highestAverage = -1;

        for (String genre
                : totals.keySet()) {

            double average =
                    totals.get(genre)
                            / counts.get(genre);

            if (average > highestAverage) {

                highestAverage = average;
                favoriteGenre = genre;
            }
        }

        for (Media candidate
                : candidates) {

            boolean alreadyWatched =
                    watchedTitles.contains(
                            candidate
                                    .getTitle()
                                    .toLowerCase()
                    );

            if (!alreadyWatched
                    && candidate.getGenre()
                    .equalsIgnoreCase(
                            favoriteGenre
                    )) {

                return candidate;
            }
        }

        return null;
    }
}