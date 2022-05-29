package com.rest.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private List<Book> books;
    private LocalDateTime createdDate;

}
