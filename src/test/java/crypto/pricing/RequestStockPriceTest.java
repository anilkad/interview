package crypto.pricing;

import org.junit.Rule;
import org.junit.Test;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;


public class RequestStockPriceTest {
	
	@Rule
    public PactProviderRule mockTestProvider = new PactProviderRule("ExternalService", "localhost", 8082, this);

	@Pact(provider = "ExternalService", consumer = "PricingService")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
			
		return builder.given("ExternalService has stock price data")
				.uponReceiving("request for stock price")
					.path("/min-api.cryptocompare.com/data/pricemulti")
					.query("fsyms=BTC,ETH&tsyms=USD&api_key=5dda852718cb205d69188b8a5779c99d6af2da041ee4f5000f205958992662ae")
					.body("")
				.willRespondWith()
					.status(200)
					.body("{\"BTC\":{\"USD\":9473.08},\"ETH\":{\"USD\":189.77}}")
				.toPact();
	}
	
	@Test
	 @PactVerification("ExternalService")
	    public void pricePointRequestTest() {
		PricingService pricingService = new PricingService();
		pricingService.setBaseURL(mockTestProvider.getUrl());
		pricingService.getStockPrice();
		//TODO needs fetchStockPrice implementation changes for writing the verifications
		}
}
