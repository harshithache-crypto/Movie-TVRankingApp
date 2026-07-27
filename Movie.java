package app;

public class Movie extends Media {
	
	private int totalMinutes;

    public Movie(
            String title,
            String genre,
            int releaseYear,
            int totalMinutes) {

        super(title, genre, releaseYear);
        this.totalMinutes = totalMinutes;
    }

    public int getRuntimeMinutes() {
        return totalMinutes;
    }

    @Override
    public String toString() {
        return "Movie: " + super.toString()
                + " - Runtime: " + totalMinutes
                + " minutes";
    }
    


}
