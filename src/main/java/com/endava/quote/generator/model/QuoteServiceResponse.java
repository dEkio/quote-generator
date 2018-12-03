package com.endava.quote.generator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteServiceResponse {

    @JsonProperty("author")
    private String author;
    @JsonProperty("quote")
    private String quote;


}