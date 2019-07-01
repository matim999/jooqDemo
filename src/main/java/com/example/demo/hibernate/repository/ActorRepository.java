package com.example.demo.hibernate.repository;

import com.example.demo.hibernate.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Collection<Actor> findAllByActorIdIn(Collection<Integer> actorIds);

    Collection<Actor> findAllByFirstNameContainingIgnoreCase(String firstName);
}
