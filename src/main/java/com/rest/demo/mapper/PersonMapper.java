package com.rest.demo.mapper;

import com.rest.demo.dto.PersonDTO;
import com.rest.demo.entity.Book;
import com.rest.demo.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonMapper {

    public List<PersonDTO> mapEntityToDto(List<Person> people) {
        return people.stream()
                .map(person -> new PersonDTO()
                        .setId(person.getId())
                        .setAge(person.getAge())
                        .setBooks(person.getBooks())
                        .setEmail(person.getEmail())
                        .setFirstName(person.getFirstName())
                        .setLastName(person.getLastName()))
                .collect(Collectors.toList());
    }

    public PersonDTO mapEntityToDto(Person person) {
        return new PersonDTO()
                .setId(person.getId())
                .setAge(person.getAge())
                .setBooks(person.getBooks())
                .setEmail(person.getEmail())
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName());
    }

    public void update(PersonDTO personDTO, Person personById) {
        final Integer newAge = personDTO.getAge();
        if (newAge != null) {
            personById.setAge(newAge);
        }

        final List<Book> books = personDTO.getBooks();
        if (books != null) {
            personById.setBooks(books);
        }

        final String firstName = personDTO.getFirstName();
        if (firstName != null) {
            personById.setFirstName(firstName);
        }

        final String lastName = personDTO.getLastName();
        if (lastName != null) {
            personById.setLastName(lastName);
        }

        final String email = personDTO.getEmail();
        if (email != null) {
            personById.setEmail(email);
        }
    }
}
