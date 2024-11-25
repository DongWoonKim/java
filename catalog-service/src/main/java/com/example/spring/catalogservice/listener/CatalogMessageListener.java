package com.example.spring.catalogservice.listener;

import com.example.spring.catalogservice.config.RabbitMQConfig;
import com.example.spring.catalogservice.domain.Book;
import com.example.spring.catalogservice.domain.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CatalogMessageListener {

    private final BookService bookService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleProductUpdate(Book book) {
        log.info("Received product update: {}", book);
        bookService.addBookToCatalog(book);
        log.info("Added product to catalog success!");
    }

}
