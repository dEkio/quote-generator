package com.endava.quote.generator.api;

import com.endava.quote.generator.model.QuoteServiceResponse;
import com.endava.quote.generator.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class QuoteController {

    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/quote", produces = {"application/json"})
    public ResponseEntity<QuoteServiceResponse> getQuote(){
            return ResponseEntity.of(Optional.of(quoteService.getQuote()));
    }
}