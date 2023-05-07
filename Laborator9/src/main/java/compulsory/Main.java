package compulsory;

import compulsory.entity.Album;
import compulsory.entity.Artist;
import compulsory.entity.Genre;
import compulsory.repository.AlbumRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.eclipse.persistence.jpa.PersistenceProvider;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        AlbumRepository albumRepository = new AlbumRepository((javax.persistence.EntityManagerFactory) emf);


        Artist artist1 = new Artist("The Beatles");
        Album album1 = new Album("Abbey Road", artist1, 1969);
        Genre genre1 = new Genre("Rock");
        album1.addGenre(genre1);
        Genre genre2 = new Genre("Pop");
        album1.addGenre(genre2);
        albumRepository.create(album1);

        Album album2 = albumRepository.findById(1L);
        System.out.println(album2);

        List<Album> albums = albumRepository.findByName("Abbey%");
        for (Album album : albums) {
            System.out.println(album);
        }
        emf.close();
    }
}