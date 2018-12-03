package com.endava.quote.generator.service;

import com.endava.quote.generator.model.QuoteServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    @Autowired
    private AuthorService authorService;

    public QuoteServiceResponse getQuote() {
        List<String> quotes = Arrays.asList(
                "No guts, no story.",
                "My life is my message.",
                "Boldness be my friend.",
                "Keep going. Be all in.",
                "My life is my argument.",
                "Dream big.",
                "Leave no stone unturned.",
                "Fight till the last gasp.",
                "Stay hungry. Stay foolish.",
                "Screw it, let’s do it."
        );
        return QuoteServiceResponse
                .builder()
                .quote(quotes.get(new Random().nextInt(quotes.size() - 1)))
                .author(authorService.getAuthor())
                .build();
    }
}