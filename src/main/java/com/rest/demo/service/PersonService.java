package com.rest.demo.service;

import com.rest.demo.dto.PersonDTO;
import com.rest.demo.entity.Person;
import com.rest.demo.mapper.PersonMapper;
import com.rest.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> findAll() {
        return personMapper.mapEntityToDto(personRepository.findAll());
    }

    public PersonDTO findById(long personId) {
        return personMapper.mapEntityToDto(personRepository.findById(personId));
    }

    public void updatePersonById(long personId, PersonDTO personDTO) {
        final Person personById = personRepository.findById(personId);
        personMapper.update(personDTO, personById);
    }

    public void deleteById(long personId) {
        personRepository.deleteById(personId);
    }
}
