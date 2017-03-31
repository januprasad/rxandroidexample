package in.hatio.rxandroidexample;

/**
 * Created by jenuprasad on 29/03/17.
 */

public class Movie {
    private String title;
    private String poster_path;
    private String release_date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster_path;
    }

    public void setPoster(String poster) {
        this.poster_path = poster;
    }

    public String getYear() {
        return release_date;
    }

    public void setYear(String year) {
        this.release_date = year;
    }
}
