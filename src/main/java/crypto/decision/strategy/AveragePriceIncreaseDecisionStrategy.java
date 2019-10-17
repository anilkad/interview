package crypto.decision.strategy;

import com.google.common.collect.Iterables;
import crypto.decision.domain.PriceData;

import java.util.List;
import reactor.core.publisher.Flux;

/**
 * Poor Man's strategy to trade
 */
public class AveragePriceIncreaseDecisionStrategy implements DecisionStrategy {

    /**
     * It takes a list of price points and then decides if one has to buy a BTC or ETH
     * @param pricePoints
     * @return
     */
    @Override
    public String decide(Flux<PriceData> pricePoints) {

        List<PriceData> priceData = pricePoints
            .collectList()
            .block();

        PriceData first = Iterables.getFirst(priceData, null);
        PriceData last = Iterables.getLast(priceData);

        Double btcFirst = first.getBtcPrice();
        Double btcLast = last.getBtcPrice();
        Double btcRoi = btcLast / btcFirst;

        Double ethFirst = first.getEthPrice();
        Double ethLast = last.getEthPrice();
        Double ethRoi = ethLast / ethFirst;

        return btcRoi > ethRoi ? "BTC" : "ETH";

    }
}
