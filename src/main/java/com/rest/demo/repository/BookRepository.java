package com.rest.demo.repository;

import com.rest.demo.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
@AllArgsConstructor
public class BookRepository {
    private final Set<Book> books;

    @EventListener(ContextRefreshedEvent.class)
    public void enrichBooksList() {
        for (int i = 0; i < 10; i++) {
            books.add(new Book()
                    .setPrice(10.47 + i)
                    .setAuthor("John" + i)
                    .setCreatedDate(LocalDateTime.now()));
        }
    }
}
