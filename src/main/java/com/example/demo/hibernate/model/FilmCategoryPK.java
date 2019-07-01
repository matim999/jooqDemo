package com.example.demo.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmCategoryPK implements Serializable {
    @Column(name = "film_id", nullable = false)
    @Id
    private Short filmId;
    @Column(name = "category_id", nullable = false)
    @Id
    private Short categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryPK that = (FilmCategoryPK) o;
        return Objects.equals(filmId, that.filmId) &&
                Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }
}
