package com.endava.quote.generator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class ProductionAuthorService implements AuthorService{

    @Value("${quote.author}")
    private String author;

    @Override
    public String getAuthor() {
        return author;
    }
}