package com.example.demo.hibernate.repository;

import com.example.demo.dto.FilmList;
import com.example.demo.hibernate.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(nativeQuery = true, value = "SELECT film.film_id AS fid, " +
            "film.title, " +
            "film.description, " +
            "category.name AS category, " +
            "film.rental_rate AS price, " +
            "film.length, " +
            "film.rating, " +
            "group_concat((actor.first_name || ' ') || actor.last_name) AS actors " +
            "FROM category " +
            "LEFT JOIN film_category ON category.category_id = film_category.category_id " +
            "LEFT JOIN film ON film_category.film_id = film.film_id " +
            "JOIN film_actor ON film.film_id = film_actor.film_id " +
            "JOIN actor ON film_actor.actor_id = actor.actor_id " +
            "GROUP BY film.film_id, film.title, film.description, category.name, film.rental_rate, film.length, film.rating;")
    Collection<FilmList> findFilmList();
}
