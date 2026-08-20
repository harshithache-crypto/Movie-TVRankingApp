package app;

import java.util.List;

public interface RecommendationStrategy {

    Media recommend(
            List<UserMediaEntry> watched,
            List<Media> candidates
    );
}