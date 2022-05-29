package com.rest.demo.controller;

import com.rest.demo.dto.PersonDTO;
import com.rest.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable long personId) {
        return ResponseEntity.ok(personService.findById(personId));
    }

    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonById(@PathVariable long personId,
                                 @RequestBody PersonDTO personDTO) {
        personService.updatePersonById(personId, personDTO);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long personId) {
        personService.deleteById(personId);
    }
}
