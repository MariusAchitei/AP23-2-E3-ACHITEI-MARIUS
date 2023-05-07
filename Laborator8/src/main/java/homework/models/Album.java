package homework.models;

import java.util.List;

public class Album {
    int id;
    int year;
    String title;
    int artist;
    String artistName;
    List<Genre> genres;


    public Album(int id, int year, String title, int artist) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.artist = artist;
    }
    public Album(int year, String title, String artistName) {
        this.id = 0;
        this.year = year;
        this.title = title;
        this.artistName = artistName;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                '}';
    }
}
