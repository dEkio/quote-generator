package com.endava.quote.generator;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import com.endava.quote.generator.model.QuoteServiceResponse;
import com.endava.quote.generator.service.QuoteService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@RunWith(SpringRestPactRunner.class)
@Provider("quote-generator")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//pact_broker is the service name in docker-compose
@PactBroker(host = "localhost", tags = "${pactbroker.tags:feature1}")
public class ApplicationContractTest {


    @TestTarget
    public final Target target = new SpringBootHttpTarget();

    @MockBean
    private QuoteService quoteService;

    @State("quote generator")
    public void toDefaultState() {
//		final boolean userExists = (boolean) params.get("userExists");
        when(quoteService.getQuote()).thenReturn(QuoteServiceResponse.builder()
                .author("test author")
                .quote("test quote")
                .build());
    }
}