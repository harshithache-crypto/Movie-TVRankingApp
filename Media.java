package app;

public abstract class Media
        implements MediaComponent {

    private String title;
    private String genre;
    private int releaseYear;

    public Media(
            String title,
            String genre,
            int releaseYear) {

        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public abstract String getMediaType();

    @Override
    public void displayComponent() {

        System.out.println(this);
    }

    @Override
    public String getComponentName() {

        return title;
    }

    @Override
    public String toString() {

        return title
                + " (" + releaseYear + ")"
                + " | Genre: "
                + genre;
    }
}