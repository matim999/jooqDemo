package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_actor", schema = "public", catalog = "test")
@IdClass(FilmActorPK.class)
public class FilmActor {
    @Id
    @Column(name = "actor_id", nullable = false)
    private Short actorId;
    @Id
    @Column(name = "film_id", nullable = false)
    private Short filmId;
    @ManyToOne
    @JoinColumn(/*name = "actor_id", */referencedColumnName = "actor_id", nullable = false)
    private Actor actorByActorId;
    @ManyToOne
    @JoinColumn(/*name = "film_id", */referencedColumnName = "film_id", nullable = false)
    private Film filmByFilmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActor filmActor = (FilmActor) o;
        return Objects.equals(actorId, filmActor.actorId) &&
                Objects.equals(filmId, filmActor.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

}
