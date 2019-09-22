package crypto.decision;

import crypto.decision.domain.PriceData;
import crypto.decision.strategy.AveragePriceIncreaseDecisionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DecisionService {

    Logger logger = LoggerFactory.getLogger(DecisionService.class);

    //TODO ACTUALLY introduce some service discovery using eureka or some other way

    private final String SERVICE_URL = "http://localhost:8080/fetchprices/after?numSeconds=";

    //TODO pick form app properties see for trends of price in last 5 minutes to decide what to trade
    private final int DURATION_TO_LOOK = 300;

    /***
     * Looks at the trend of BTC and ETH pricing in the last DURATION_TO_LOOK seconds
     * @return the asset that has the most %age gain in dollar price
     */
    public String decide() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PriceData>> prResponseEntity = restTemplate.exchange(
                SERVICE_URL + DURATION_TO_LOOK,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PriceData>>() {
                }
        );
        List<PriceData> pricePoints = prResponseEntity.getBody();
        logger.debug(pricePoints.toString());
        return (new AveragePriceIncreaseDecisionStrategy()).decide(pricePoints);
    }
}
