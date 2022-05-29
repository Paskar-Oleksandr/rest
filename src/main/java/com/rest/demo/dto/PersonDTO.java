package com.rest.demo.dto;

import com.rest.demo.entity.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
//todo show validation
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private List<Book> books;

}
