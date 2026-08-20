package app;

public class CatalogLoader {

    public static MediaCatalog createCatalog() {

        MediaCatalog catalog = new MediaCatalog();

        MediaCreator movieCreator =
                new MovieCreator();

        MediaCreator showCreator =
                new TVShowCreator();

        catalog.addMedia(
                movieCreator.createMedia(
                        "Interstellar",
                        "Science Fiction",
                        2014,
                        169
                )
        );

        catalog.addMedia(
                movieCreator.createMedia(
                        "Arrival",
                        "Science Fiction",
                        2016,
                        116
                )
        );

        catalog.addMedia(
                movieCreator.createMedia(
                        "Parasite",
                        "Thriller",
                        2019,
                        132
                )
        );

        catalog.addMedia(
                movieCreator.createMedia(
                        "Get Out",
                        "Horror",
                        2017,
                        104
                )
        );

        catalog.addMedia(
                movieCreator.createMedia(
                        "The Dark Knight",
                        "Action",
                        2008,
                        152
                )
        );

        catalog.addMedia(
                movieCreator.createMedia(
                        "Barbie",
                        "Comedy",
                        2023,
                        114
                )
        );

        catalog.addMedia(
                showCreator.createMedia(
                        "Breaking Bad",
                        "Drama",
                        2008,
                        5
                )
        );

        catalog.addMedia(
                showCreator.createMedia(
                        "The Bear",
                        "Drama",
                        2022,
                        4
                )
        );

        catalog.addMedia(
                showCreator.createMedia(
                        "Stranger Things",
                        "Science Fiction",
                        2016,
                        5
                )
        );

        catalog.addMedia(
                showCreator.createMedia(
                        "Bridgerton",
                        "Romance",
                        2020,
                        4
                )
        );

        return catalog;
    }
}