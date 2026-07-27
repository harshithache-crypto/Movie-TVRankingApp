package app;

import java.util.List;

public class RecommendationStrat {
	
	private Recommendations strategy;

    public RecommendationStrat(
            Recommendations strategy) {

        setStrategy(strategy);
    }

    public void setStrategy(
            Recommendations strategy) {

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Recommendation strategy cannot be null."
            );
        }

        this.strategy = strategy;
    }

    public Media getRecommendation(
            List<Media> mediaItems) {

        return strategy.recommend(mediaItems);
    }

}
