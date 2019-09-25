package crypto.decision;

import static org.junit.Assert.assertFalse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import crypto.domain.PricePoint;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;


public class RequestPricePointTest {
	
	@Rule
    public PactProviderRule mockTestProvider = new PactProviderRule("PricingService", "localhost", 8082, this);

	@Pact(provider = "PricingService", consumer = "DecisionService")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
		return builder.given("PricingService has price-points data")
				.uponReceiving("request for price-points")
					.path("/fetchprices/after")
					.query("numSeconds=300")
					.method("GET")
				.willRespondWith()
					.status(200)
					.headers(headers)
					.body("[{\"btcPrice\":9616.49,\"ethPrice\":194.51,\"timeOfPrice\":\"2019-09-24T13:50:39.123+0000\"},{\"btcPrice\":9616.49,\"ethPrice\":194.51,\"timeOfPrice\":\"2019-09-24T13:50:40.307+0000\"},{\"btcPrice\":9616.49,\"ethPrice\":194.51,\"timeOfPrice\":\"2019-09-24T13:50:42.335+0000\"},{\"btcPrice\":9616.38,\"ethPrice\":194.45,\"timeOfPrice\":\"2019-09-24T13:50:44.307+0000\"},{\"btcPrice\":9616.38,\"ethPrice\":194.45,\"timeOfPrice\":\"2019-09-24T13:50:46.313+0000\"}]")
				.toPact();
	}
	
	@Test
	 @PactVerification("PricingService")
	    public void pricePointRequestTest() {
		 //execute a DecisionService request to mockserver	
		 DecisionService decisionService = new DecisionService();
		 decisionService.setBaseURL(mockTestProvider.getUrl());
		 List<PricePoint> result = decisionService.getPricepoints();

		 assertFalse(result.isEmpty());
		 }
}
