package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_category", schema = "public", catalog = "test")
@IdClass(FilmCategoryPK.class)
public class FilmCategory {
    @Id
    @Column(name = "film_id", nullable = false)
    private Short filmId;
    @Id
    @Column(name = "category_id", nullable = false)
    private Short categoryId;
    @ManyToOne
    @JoinColumn(/*name = "film_id", */referencedColumnName = "film_id", nullable = false)
    private Film filmByFilmId;
    @ManyToOne
    @JoinColumn(/*name = "category_id", */referencedColumnName = "category_id", nullable = false)
    private Category categoryByCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategory that = (FilmCategory) o;
        return Objects.equals(filmId, that.filmId) &&
                Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }

}
