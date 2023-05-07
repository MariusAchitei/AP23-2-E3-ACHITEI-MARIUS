package homework.repositories;

import homework.Database;
import homework.models.Artist;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ArtistRepository {
    static public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (id, name) values (?,?)")) {
            int maxId = getMaxId();
            pstmt.setInt(1, maxId + 1);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }

    static public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where name='" + name + "'")) {
            if (rs.next() == false)
                return null;
            return new Artist(rs.getInt(1), rs.getString(2));
        }
    }

    public String findById(int id) throws SQLException {
//        TODO
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }

    static public int getMaxId() {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select max(id) from artists")) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Artist> getAll() {
        List<Artist> artists = new LinkedList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists")) {
            while (rs.next() == true) {
                artists.add(new Artist(rs.getInt(1), rs.getString(2)));
            }
            return artists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}