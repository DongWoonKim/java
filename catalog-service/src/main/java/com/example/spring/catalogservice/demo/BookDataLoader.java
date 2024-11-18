package com.example.spring.catalogservice.demo;

import com.example.spring.catalogservice.domain.Book;
import com.example.spring.catalogservice.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        Book build = Book.builder()
                .isbn("1234567891")
                .title("test")
                .author("test")
                .price(9.9)
                .build();

        Book build2 = Book.builder()
                .isbn("1234567892")
                .title("test2")
                .author("test2")
                .price(9.2)
                .build();

        bookRepository.save(build);
        bookRepository.save(build2);
    }

}
