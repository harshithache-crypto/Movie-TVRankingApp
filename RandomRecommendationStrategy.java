package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomRecommendationStrategy
        implements RecommendationStrategy {

    private Random random;

    public RandomRecommendationStrategy() {

        random = new Random();
    }

    @Override
    public Media recommend(
            List<UserMediaEntry> watched,
            List<Media> candidates) {

        Set<String> watchedTitles =
                new HashSet<>();

        for (UserMediaEntry entry
                : watched) {

            watchedTitles.add(
                    entry.getMedia()
                         .getTitle()
                         .toLowerCase()
            );
        }

        List<Media> available =
                new ArrayList<>();

        for (Media media
                : candidates) {

            if (!watchedTitles.contains(
                    media.getTitle()
                         .toLowerCase())) {

                available.add(media);
            }
        }

        if (available.isEmpty()) {

            return null;
        }

        return available.get(
                random.nextInt(
                        available.size()
                )
        );
    }
}