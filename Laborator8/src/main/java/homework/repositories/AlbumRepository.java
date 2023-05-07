package homework.repositories;

import homework.Database;
import homework.models.Album;
import homework.models.Artist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AlbumRepository {
    public void create(int year, String title, String artist, String[] genres) throws SQLException {
        Connection con = Database.getConnection();
        var artistsRepository = new ArtistRepository();
        int album_id;
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, year, title, artist) values (?, ?, ?, ?)")) {
            album_id = getMaxId() + 1;
            pstmt.setInt(1, album_id);
            pstmt.setInt(2, year);
            pstmt.setString(3, title);
            int artistId = ArtistRepository.findByName(artist).getId();
            pstmt.setInt(4, artistId);
            pstmt.executeUpdate();
        }
        var genresRepository = new GenreRepository();
        for (String genre :
                genres) {
            if (genresRepository.findByName(genre) == null)
                genresRepository.create(genre);
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into album_genre (album, genre) values (?,?)")) {
                pstmt.setInt(1, album_id);
                int genre_id = genresRepository.findByName(genre).getId();
                pstmt.setInt(2, genre_id);
                pstmt.executeUpdate();
            }
        }
    }


    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
//        TODO
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where name='" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }

    public int getMaxId() {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select max(id) from albums")) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Album> getAll() {
        List<Album> albums = new LinkedList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums")) {
            while (rs.next() == true) {
                albums.add(new Album(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
            }
            return albums;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Album> readFromCsv(String fileName) {
        List<Album> albums = new LinkedList<>();
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] values = line.split(",");

                int year = Integer.parseInt(values[1]);
                String title = values[2];
                Artist artist = ArtistRepository.findByName(values[3]);
                if (artist == null) {
                    ArtistRepository.create(values[3]);
                    artist = ArtistRepository.findByName(values[3]);
                }

                String[] genres = new String[40];
                for (int i = 4; i < values.length; i++) {
                    genres[i - 4] = values[i];
                }

                Album album = findByYearTitleArtist(year, title, artist);
                if (album == null) {
                    create(year, title, artist.getName(), genres);
                }

                albums.add(album);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return albums;

    }

    public Album findByYearTitleArtist(int year, String title, Artist artist) {
        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "select * from albums where year=? and title=? and artist=?")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setInt(3, artist.getId());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next() == false)
                return null;
            return new Album(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public
}