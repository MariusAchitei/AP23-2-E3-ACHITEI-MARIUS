package homework;

import homework.models.Album;
import homework.models.Artist;
import homework.models.Genre;
import homework.repositories.AlbumRepository;
import homework.repositories.ArtistRepository;
import homework.repositories.GenreRepository;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        try {

            Database.getConnection();
            var artists = new ArtistRepository();
            var genres = new GenreRepository();
            var albums = new AlbumRepository();

            List<Album> readAlbums = albums.readFromCsv("D:\\.facultate\\.Lab-Java\\Laborator8\\utils\\albumlist.csv");

//            artists.create("Pink Floyd");
//            artists.create("Michael Jackson");
//            genres.create("Rock");
//            genres.create("Funk");
//            genres.create("Soul");
//            genres.create("Pop");
//            Database.getConnection().commit();
//            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
//            //findByName
//            albums.create(1982, "Thriller", "Michael Jackson", "Funk", "Soul", "Pop");


            List<Artist> artistsEntities = artists.getAll();
            artistsEntities.stream().forEach(a -> System.out.println(a));

            List<Genre> genreEntities = genres.getAll();
            genreEntities.stream().forEach(a -> System.out.println(a));

            List<Album> albumEntities = albums.getAll();
            albumEntities.stream().forEach(a -> System.out.println(a));


            Database.getConnection().commit();


            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
