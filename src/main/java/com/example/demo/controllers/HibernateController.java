package com.example.demo.controllers;

import com.example.demo.hibernate.model.Actor;
import com.example.demo.hibernate.repository.ActorRepository;
import com.example.demo.hibernate.repository.CategoryRepository;
import com.example.demo.jooq.TestJooq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
public class HibernateController {
    private final ActorRepository actorRepository;
    private final CategoryRepository categoryRepository;
    private final TestJooq testJooq;

    @Autowired
    public HibernateController(ActorRepository actorRepository, CategoryRepository categoryRepository, TestJooq testJooq) {
        this.actorRepository = actorRepository;
        this.categoryRepository = categoryRepository;
        this.testJooq = testJooq;
    }

    @GetMapping(path = "/actors")
    public Collection<Actor> getActors() {
        return actorRepository.findAll();
    }

    @PostMapping(path = "/jooq/actors")
    public void createNewActorsJooq() {
        testJooq.saveNewActor();
    }

    @GetMapping(path = "/jooq/actors")
    public List<org.jooq.codegen.maven.example.tables.pojos.Actor> getActorsJooq() {
        return testJooq.getAll();
    }

    @GetMapping(path = "/actors/{actorIds}")
    public Collection<Actor> getActorsByIds(@PathVariable Set<Integer> actorIds) {
        return actorRepository.findAllByActorIdIn(actorIds);
    }

    @GetMapping(path = "/jooq/actors/{actorIds}")
    public String getActorsByIdsJooq(@PathVariable Set<Integer> actorIds) {
        return testJooq.getByIds(actorIds);
    }

    @GetMapping(path = "/film-list")
    public ResponseEntity<?> findFilmList() {
        return ResponseEntity.ok(categoryRepository.findFilmList());
    }

    @GetMapping(path = "/jooq/film-list")
    public ResponseEntity<?> findFilmListJooq() {
        return ResponseEntity.ok(testJooq.findFilmList());
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(testJooq.findFilmList());
    }

    @GetMapping(path = "/actors/name/{firstName}")
    public Collection<Actor> getActorsByFirstNameLike(@PathVariable String firstName) {
        return actorRepository.findAll();
    }
}
