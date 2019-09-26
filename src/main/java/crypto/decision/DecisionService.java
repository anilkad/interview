package crypto.decision;

import crypto.decision.strategy.AveragePriceIncreaseDecisionStrategy;
import crypto.domain.PricePoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class DecisionService {

    Logger logger = LoggerFactory.getLogger(DecisionService.class);
    
    private final String SERVICE_PATH = "/fetchprices/after?numSeconds=";
    private final int DURATION_TO_LOOK = 300;
    private String baseURL = "http://localhost:8080";
    
    
    public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
   
    public List<PricePoint> getPricepoints() { 	
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<List<PricePoint>>  prResponseEntity = restTemplate.exchange(
        		baseURL + SERVICE_PATH + DURATION_TO_LOOK,
        		HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PricePoint>>() {}
        );
        List<PricePoint> pricePoints = prResponseEntity.getBody();
        logger.debug(pricePoints.toString());
        return pricePoints;
    }
    
    /***
     * Looks at the trend of BTC and ETH pricing in the last DURATION_TO_LOOK seconds
     * @return the asset that has the most %age gain in dollar price
     */
    public String decide() {
    	return (new AveragePriceIncreaseDecisionStrategy()).decide(getPricepoints());
    }

	
}
