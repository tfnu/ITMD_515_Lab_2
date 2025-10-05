/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.tfnu;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author tfnu
 */
public class Film {

    @NotNull(message = "Null Value not allowed")
    @Positive
    private Integer filmId;

    @NotBlank
    private String title;

    @NotNull
    private Integer languageId;

    @NotNull
    private Integer rentalDuration;

    @NotNull
    private BigDecimal rentalRate;

    @NotNull
    private BigDecimal replacementCost;

    @NotNull
    @PastOrPresent(message = "Future Date")
    private LocalDate lastUpdate;

    private String description;

    public Film() {
    }

    public Film(Integer filmId, String title, Integer languageId, Integer rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, LocalDate lastUpdate, String description) {
        this.filmId = filmId;
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.lastUpdate = lastUpdate;
        this.description = description;
    }

    /**
     * Get the value of filmId
     *
     * @return the value of filmId
     */
    public Integer getFilmId() {
        return filmId;
    }

    /**
     * Set the value of filmId
     *
     * @param filmId new value of filmId
     */
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film{" + "filmId=" + filmId + ", title=" + title + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", replacementCost=" + replacementCost + ", lastUpdate=" + lastUpdate + ", description=" + description + '}';
    }

}
