package app;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome!");
        
        Media movieOne = MediaFactory.createMedia(
                MediaType.MOVIE,
                "Interstellar",
                "Science Fiction",
                2014,
                169
        );

        Media movieTwo = MediaFactory.createMedia(
                MediaType.MOVIE,
                "The Dark Knight",
                "Action",
                2008,
                152
        );

        Media showOne = MediaFactory.createMedia(
                MediaType.TV_SHOW,
                "Stranger Things",
                "Science Fiction",
                2016,
                4
        );

        movieOne.setRating(9.5);
        movieTwo.setRating(9.2);
        showOne.setRating(8.7);

        Watchlist watchlist = new Watchlist();

        watchlist.addTitle(movieOne);
        watchlist.addTitle(movieTwo);
        watchlist.addTitle(showOne);


        watchlist.displayWatchlist();
        
        RecommendationStrat engine =
                new RecommendationStrat(
                        new HighestRated()
                );

        Media recommendation =
                engine.getRecommendation(
                        watchlist.getTitles()
                );

        System.out.println();

        if (recommendation != null) {
            System.out.println(
                    "Highest-rated recommendation:"
            );

            System.out.println(recommendation);
        }

    
    }
}