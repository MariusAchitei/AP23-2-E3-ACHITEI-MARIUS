package compulsory.models;

public class Album {
    int id;
    int year;
    String title;
    int artist;

    public Album(int id, int year, String title, int artist) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.artist = artist;
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
