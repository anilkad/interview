package crypto.decision.strategy;

import crypto.domain.PricePoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class AveragePriceIncreaseDecisionStrategyTest {

    @Test
    public void decideThatBTCIsTheOnlyCoin() {
        AveragePriceIncreaseDecisionStrategy strategy = new AveragePriceIncreaseDecisionStrategy();
        List<PricePoint> pricePointList = new ArrayList<>();
        pricePointList.add(new PricePoint(1.0,1.0,new Date()));
        pricePointList.add(new PricePoint(2.0,2.0,new Date()));
        pricePointList.add(new PricePoint(3.0,2.5,new Date()));
        pricePointList.add(new PricePoint(4.0,3.0,new Date()));

        assertEquals("BTC",strategy.decide(pricePointList));


    }
}