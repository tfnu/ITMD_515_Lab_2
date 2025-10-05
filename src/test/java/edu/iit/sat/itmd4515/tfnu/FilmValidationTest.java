/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.tfnu;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
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
public class FilmValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void beforeAll() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    public void filmIsNotValid_futureLastUpdate() {

        Film film = new Film(
                1099, "Test",
                5,
                6,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                LocalDate.of(2023, 8, 15),
                "");

        // Validate the data
        Set<ConstraintViolation<Film>> violations = validator.validate(film);

        for (ConstraintViolation<Film> violation : violations) {
            System.out.println(violation.toString());
        }

        // Assert pass or fail
        Assertions.assertEquals(1, violations.size());
        Assertions.assertEquals("Future Date", violations.iterator().next().getMessage());
    }

    @Test
    public void filmIdNotValid_filmIdNotNull() {
        Film film = new Film(
                null,
                "Test",
                5,
                6,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                LocalDate.of(2021, 8, 15),
                "");
        
         // Validate the data
        Set<ConstraintViolation<Film>> violations = validator.validate(film);

        for (ConstraintViolation<Film> violation : violations) {
            System.out.println(violation.toString());
        }
        
        // Assertion Pass or failed
        Assertions.assertEquals(1, violations.size());
        
        Assertions.assertEquals("Null Value not allowed", violations.iterator().next().getMessage());
        

        
    }

    @AfterEach
    public void afterEach() {
    }

    @AfterAll
    public static void afterAll() {
    }
}
