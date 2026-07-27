package app;

public class Media {
	
	private String title;
    private String genre;
    private int releaseYear;
    private double rating;
    
    public Media(String title, String genre, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = 0.0;
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

    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 10."
            );
        }
    }
    
    @Override
    public String toString() {
        return title + " (" + releaseYear + ")"
                + " - Genre: " + genre
                + " - Rating: " + rating;
    }
    

}
