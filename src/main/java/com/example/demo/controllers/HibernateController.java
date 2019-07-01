package com.example.demo.controllers;

import com.example.demo.hibernate.model.Actor;
import com.example.demo.hibernate.repository.ActorRepository;
import com.example.demo.jooq.TestJooq;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
public class HibernateController {
    private final ActorRepository actorRepository;
    private final TestJooq testJooq;

    @Autowired
    public HibernateController(ActorRepository actorRepository, TestJooq testJooq) {
        this.actorRepository = actorRepository;
        this.testJooq = testJooq;
    }

    @GetMapping(path = "/actors/{actorIds}")
    public Collection<Actor> getActorsByIds(@PathVariable Set<Integer> actorIds) {
        return actorRepository.findAllByActorIdIn(actorIds);
    }

    @GetMapping(path = "/jooq/actors/{actorIds}")
    public Result<Record> getActorsByIdsJooq(@PathVariable Set<Integer> actorIds) {
        return testJooq.getBtIds(actorIds);
    }

    @GetMapping(path = "/actors/name/{firstName}")
    public Collection<Actor> getActorsByFirstNameLike(@PathVariable String firstName) {
        return actorRepository.findAll();
    }
}
