package crypto.decision;

import com.google.common.collect.ImmutableMap;
import crypto.decision.domain.PriceData;
import crypto.decision.strategy.AveragePriceIncreaseDecisionStrategy;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class DecisionService {

    private final Logger logger = LoggerFactory.getLogger(DecisionService.class);

    //TODO pick form app properties see for trends of price in last 5 minutes to decide what to trade
    private final int DURATION_TO_LOOK = 300;

    private WebClient client;

    @PostConstruct
    public void init() {
        this.client = WebClient
            .builder()
            //TODO ACTUALLY introduce some service discovery using eureka or some other way
            .baseUrl("http://localhost:8080/fetchprices")
            .build();
    }

    /***
     * Looks at the trend of BTC and ETH pricing in the last DURATION_TO_LOOK seconds
     * @return the asset that has the most %age gain in dollar price
     */
    public String decide() {
        Flux<PriceData> pricePoints = this.client
            .get()
            .uri(
                "/after",
                ImmutableMap.of(
                    "numSeconds",
                    DURATION_TO_LOOK))
            .retrieve()
            .bodyToFlux(PriceData.class)
            .doOnEach(pd -> logger.debug(pd.toString()));

        return (new AveragePriceIncreaseDecisionStrategy()).decide(pricePoints);
    }
}
