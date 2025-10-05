/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.tfnu;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tfnu
 */
public class FilmJDBCTest {

    private Connection getConnection() throws SQLException {

        String jdbcURL = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String userName = "itmd4515";
        String password = "itmd4515";

        return DriverManager.getConnection(jdbcURL, userName, password);

    }

    private void createAFilm(Film film) throws SQLException {

        String query = "Insert into film "
                + "(film_id, title, language_id, rental_duration, rental_rate, replacement_cost, last_update, description) "
                + "values (?,?,?,?,?,?,?,?)";

        try (PreparedStatement pst = getConnection().prepareStatement(query);) {
            pst.setInt(1, film.getFilmId());
            pst.setString(2, film.getTitle());
            pst.setInt(3, film.getLanguageId());
            pst.setInt(4, film.getRentalDuration());
            pst.setBigDecimal(5, film.getRentalRate());
            pst.setBigDecimal(6, film.getReplacementCost());
            pst.setTimestamp(7, new Timestamp(System.currentTimeMillis())); // Setting Last update to current time stamp.
            pst.setString(8, film.getDescription());

            pst.executeUpdate();

        }

    }

    private void updateAFilm(Film film) throws SQLException {
        String query = "Update film set "
                + "title = ?,"
                + "language_id = ?,"
                + "rental_duration = ?,"
                + "rental_rate = ?,"
                + "replacement_cost = ?,"
                + "last_update = ?,"
                + "description = ? "
                + "where film_id = ?";

        try (PreparedStatement pst = getConnection().prepareStatement(query);) {

            pst.setString(1, film.getTitle());
            pst.setInt(2, film.getLanguageId());
            pst.setInt(3, film.getRentalDuration());
            pst.setBigDecimal(4, film.getRentalRate());
            pst.setBigDecimal(5, film.getReplacementCost());
            pst.setTimestamp(6, new Timestamp(System.currentTimeMillis())); // Setting Last update to current time stamp.
            pst.setString(7, film.getDescription());
            pst.setInt(8, film.getFilmId());

            pst.executeUpdate();

        }
    }

    private Film findAFilm(Integer id) throws SQLException {
        String query = "SELECT * from film where film_id = ?";

        Film film = null;

        try (PreparedStatement pst = getConnection().prepareStatement(query);) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setLanguageId(rs.getInt("language_id"));
                film.setRentalDuration(rs.getInt("rental_duration"));
                film.setRentalRate(rs.getBigDecimal("rental_rate"));
                film.setReplacementCost(rs.getBigDecimal("replacement_cost"));
                film.setLastUpdate(rs.getObject("last_update", LocalDate.class));
                film.setDescription(rs.getString("description"));

            }
        }

        return film;

    }

    private void deleteAFilm(Integer id) throws SQLException {
        String query = "DELETE from film where film_id = ?";

        try (PreparedStatement pst = getConnection().prepareStatement(query);) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    @BeforeAll
    public static void beforeAll() {

        //    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //    validator = factory.getValidator();
    }

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    public void jdbcCreateTest() throws SQLException {

        Film film = new Film(
                1001, "Test",
                5,
                6,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                LocalDate.of(2023, 8, 15),
                "");

        createAFilm(film);

        // read the film back from the database
        Film filmReadBackFromDb = findAFilm(film.getFilmId());

        // assert that what we got from the database matched what we initially created
        Assertions.assertEquals(film.getFilmId(), filmReadBackFromDb.getFilmId());

        // Cleaning up the customer thus created
        deleteAFilm(1001);
    }

    @Test
    public void jdbcReadTest() throws SQLException {

        // read the film back from the database
        Film filmReadBackFromDb = findAFilm(499);

        // assert that what we got from the database matched what we initially created
        Assertions.assertNotNull(filmReadBackFromDb);
        Assertions.assertEquals(499, filmReadBackFromDb.getFilmId());

    }

    @Test
    public void jdbcUpdateTest() throws SQLException {

        Film film = new Film(
                1002, "Test",
                5,
                6,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                LocalDate.of(2023, 8, 15),
                "");

        createAFilm(film);

        film.setTitle("IAMUPDATEDTITLE");

        updateAFilm(film);

        // read the film back from the database
        Film filmReadBackFromDb = findAFilm(1002);

        // assert that what we got from the database matched what we initially updated
        Assertions.assertEquals(film.getFilmId(), filmReadBackFromDb.getFilmId());
        Assertions.assertEquals("IAMUPDATEDTITLE", filmReadBackFromDb.getTitle());

        // Cleaning up the customer thus created
        deleteAFilm(1002);
    }

    @Test
    public void jdbcDeleteTest() throws SQLException {

        Film film = new Film(
                1003,
                "ToBeDeleted",
                5,
                6,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                LocalDate.of(2023, 8, 15),
                "");

        createAFilm(film);
        
        deleteAFilm(film.getFilmId());
        
        Film filmReadFromDb = findAFilm(film.getFilmId());
        
        // The result set should return null after deletion from the record.
        Assertions.assertNull(filmReadFromDb);
        
    }

    @AfterEach
    public void afterEach() {
    }

    @AfterAll
    public static void afterAll() {
    }
}
