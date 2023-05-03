package compulsory;

import compulsory.models.Album;
import compulsory.models.Artist;
import compulsory.models.Genre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        try {

            Database.createConnection();
            var artists = new ArtistDAO();
            var genres = new GenreDAO();
            var albums = new AlbumDAO();

            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.getConnection().commit();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            albums.create(1982, "Thriller", "Michael Jackson", "Funk", "Soul", "Pop");


            List<Artist> artistsEntities = artists.getAll();
            artistsEntities.stream().forEach(a -> System.out.println(a));

            List<Genre> genreEntities = genres.getAll();
            genreEntities.stream().forEach(a -> System.out.println(a));

            List<Album> albumEntities = albums.getAll();
            albumEntities.stream().forEach(a -> System.out.println(a));


//            Database.getConnection().commit();

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
