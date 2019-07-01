package com.example.demo.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmActorPK implements Serializable {
    @Column(name = "actor_id", nullable = false)
    @Id
    private Short actorId;
    @Column(name = "film_id", nullable = false)
    @Id
    private Short filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorPK that = (FilmActorPK) o;
        return Objects.equals(actorId, that.actorId) &&
                Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }
}
