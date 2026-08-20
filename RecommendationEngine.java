package app;

import java.util.List;

public class RecommendationEngine {

    private RecommendationStrategy strategy;

    public RecommendationEngine(
            RecommendationStrategy strategy) {

        this.strategy = strategy;
    }

    public void setStrategy(
            RecommendationStrategy strategy) {

        this.strategy = strategy;
    }

    public Media recommend(
            List<UserMediaEntry> watched,
            List<Media> candidates) {

        return strategy.recommend(
                watched,
                candidates
        );
    }
}