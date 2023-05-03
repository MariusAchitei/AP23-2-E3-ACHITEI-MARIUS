package compulsory;

import compulsory.models.Artist;
import compulsory.models.Genre;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class GenreDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id, name) values (?, ?)")) {
            int maxId = getMaxId();
            pstmt.setInt(1, maxId + 1);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }

    public int getMaxId() {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select max(id) from genres")) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Genre> getAll() {
        List<Genre> genres = new LinkedList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres")) {
            while (rs.next() == true) {
                genres.add(new Genre(rs.getInt(1), rs.getString(2)));
            }
            return genres;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
