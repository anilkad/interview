package crypto.decision.strategy;

import crypto.decision.domain.PriceData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;

import static org.junit.Assert.assertEquals;

public class AveragePriceIncreaseDecisionStrategyTest {

    @Test
    public void decideThatBTCIsTheOnlyCoin() {
        AveragePriceIncreaseDecisionStrategy strategy = new AveragePriceIncreaseDecisionStrategy();
        List<PriceData> priceDataList = new ArrayList<>();
        priceDataList.add(new PriceData(1.0, 1.0));
        priceDataList.add(new PriceData(2.0, 2.0));
        priceDataList.add(new PriceData(3.0, 2.5));
        priceDataList.add(new PriceData(4.0, 3.0));

        assertEquals("BTC", strategy.decide(Flux.fromIterable(priceDataList)));


    }
}