package com.example.demo.jooq;

import com.example.demo.dto.FilmList;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.codegen.maven.example.Tables;
import org.jooq.codegen.maven.example.tables.Category;
import org.jooq.codegen.maven.example.tables.Film;
import org.jooq.codegen.maven.example.tables.FilmActor;
import org.jooq.codegen.maven.example.tables.FilmCategory;
import org.jooq.codegen.maven.example.tables.pojos.Actor;
import org.jooq.codegen.maven.example.tables.records.ActorRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class TestJooq {
    private final DSLContext create;

    @Autowired
    public TestJooq(DSLContext create) {
        this.create = create;
    }

    public List<Actor> getAll() {
        return create.select()
                .from(Tables.ACTOR)
                .fetchInto(Actor.class);
    }

    public String getByIds(Collection<Integer> actorIds) {
        return create.select()
                .from(Tables.ACTOR)
                .where(Tables.ACTOR.ACTOR_ID
                        .in(actorIds))
                .fetch()
                .formatHTML();
//                .fetchInto(Actor.class);

    }

    public List<FilmList> findFilmList() {
        Field<Integer> fid = Film.FILM.FILM_ID.as("fid");
        Field<String> category = Category.CATEGORY.NAME.as("category");
        Field<java.math.BigDecimal> price = Film.FILM.RENTAL_RATE.as("price");
        Field<String> actors = DSL.groupConcat(org.jooq.codegen.maven.example.tables.Actor.ACTOR.FIRST_NAME).as("actors");

        return create.select(fid, Film.FILM.TITLE, Film.FILM.DESCRIPTION, category, price, Film.FILM.LENGTH, Film.FILM.RATING, actors)
                .from(Category.CATEGORY)
                .leftOuterJoin(FilmCategory.FILM_CATEGORY).on(Category.CATEGORY.CATEGORY_ID.eq(FilmCategory.FILM_CATEGORY.CATEGORY_ID.cast(SQLDataType.INTEGER)))
                .leftOuterJoin(Film.FILM).on(FilmCategory.FILM_CATEGORY.FILM_ID.equal(Film.FILM.FILM_ID.cast(SQLDataType.SMALLINT)))
                .join(FilmActor.FILM_ACTOR).on(Film.FILM.FILM_ID.eq(FilmActor.FILM_ACTOR.FILM_ID.cast(SQLDataType.INTEGER)))
                .join(org.jooq.codegen.maven.example.tables.Actor.ACTOR).on(FilmActor.FILM_ACTOR.ACTOR_ID.eq(org.jooq.codegen.maven.example.tables.Actor.ACTOR.ACTOR_ID.cast(SQLDataType.SMALLINT)))
                .groupBy(Film.FILM.FILM_ID, Film.FILM.TITLE, Film.FILM.DESCRIPTION, Category.CATEGORY.NAME, Film.FILM.RENTAL_RATE, Film.FILM.LENGTH, Film.FILM.RATING)
                .orderBy(Film.FILM.FILM_ID.desc())
                .seek(888)
                .fetchInto(FilmList.class);
    }

    public void saveNewActor() {
        Result<ActorRecord> execute = create.insertInto(Tables.ACTOR, org.jooq.codegen.maven.example.tables.Actor.ACTOR.FIRST_NAME, org.jooq.codegen.maven.example.tables.Actor.ACTOR.LAST_NAME)
                .values("LUL", "tewtwe")
                .returning(org.jooq.codegen.maven.example.tables.Actor.ACTOR.LAST_NAME)
                .fetch();
        System.out.println(execute.toString());
    }
}
