package com.example.demo.hibernate.model;

import org.jooq.codegen.maven.example.domains.Year;
import org.jooq.codegen.maven.example.enums.MpaaRating;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Film {
    @Id
    @Column(name = "film_id", nullable = false)
    private Integer filmId;
    @Basic
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "release_year", nullable = true)
    private Integer releaseYear;
    @Basic
    @Column(name = "rental_duration", nullable = false)
    private Short rentalDuration;
    @Basic
    @Column(name = "rental_rate", nullable = false, precision = 2)
    private BigDecimal rentalRate;
    @Basic
    @Column(name = "length", nullable = true)
    private Short length;
    @Basic
    @Column(name = "replacement_cost", nullable = false, precision = 2)
    private BigDecimal replacementCost;
    @Basic
    @Column(name = "rating", nullable = true)
    private MpaaRating rating;
    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    private Language languageByLanguageId;
    @OneToMany(mappedBy = "filmByFilmId")
    private Collection<FilmActor> filmActorsByFilmId;
    @OneToMany(mappedBy = "filmByFilmId")
    private Collection<FilmCategory> filmCategoriesByFilmId;
    @OneToMany(mappedBy = "filmByFilmId")
    private Collection<Inventory> inventoriesByFilmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(filmId, film.filmId) &&
                Objects.equals(title, film.title) &&
                Objects.equals(description, film.description) &&
                Objects.equals(releaseYear, film.releaseYear) &&
                Objects.equals(rentalDuration, film.rentalDuration) &&
                Objects.equals(rentalRate, film.rentalRate) &&
                Objects.equals(length, film.length) &&
                Objects.equals(replacementCost, film.replacementCost) &&
                Objects.equals(rating, film.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description, releaseYear, rentalDuration, rentalRate, length, replacementCost, rating);
    }
}
