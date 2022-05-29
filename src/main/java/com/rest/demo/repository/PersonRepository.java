package com.rest.demo.repository;

import com.rest.demo.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
@AllArgsConstructor
public class PersonRepository {
    private final List<Person> people;

    public List<Person> findAll() {
        return people;
    }

    public Person findById(long personId) {
        return people.stream()
                .filter(person -> person.getId() == personId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("There`s not person with id " + personId));
    }

    @EventListener(ContextRefreshedEvent.class)
    public void enrichPeopleList() {
        IntStream.range(0, 10).forEach(i ->
                people.add(new Person()
                        .setId((long) i)
                        .setAge(i + 15)
                        .setBooks(new ArrayList<>())
                        .setFirstName("Alex" + i)
                        .setLastName("Jakson" + i)
                        .setEmail("jakson" + i + "@gmail.com")
                        .setCreatedDate(LocalDateTime.now())));
    }

    public void deleteById(long personId) {
        people.stream()
                .filter(person -> person.getId() == personId)
                .forEach(people::remove);
    }
}
