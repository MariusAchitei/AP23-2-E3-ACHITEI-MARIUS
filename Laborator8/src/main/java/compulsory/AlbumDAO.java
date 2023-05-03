package compulsory;

import compulsory.models.Album;
import compulsory.models.Artist;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AlbumDAO {
    public void create(int year, String title, String artist, String... genres) throws SQLException {
        Connection con = Database.getConnection();
        var artistsDAO = new ArtistDAO();
        int album_id;
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, year, title, artist) values (?, ?, ?, ?)")) {
            album_id = getMaxId() + 1;
            pstmt.setInt(1, album_id);
            pstmt.setInt(2, year);
            pstmt.setString(3, title);
            int artistId = artistsDAO.findByName(artist);
            pstmt.setInt(4, artistId);
            pstmt.executeUpdate();
        }
        var genresDAO = new GenreDAO();
        for (String genre :
                genres) {
            genresDAO.create(genre);
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into album_genre (album, genre) values (?,?)")) {
                pstmt.setInt(1, album_id);
                int genre_id = genresDAO.findByName(genre);
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

//    public
}
