package crypto.decision.strategy;

import crypto.domain.PricePoint;

import java.util.List;

/**
 * Poor Man's strategy to trade
 */
public class AveragePriceIncreaseDecisionStrategy implements DecisionStrategy {

    @Override
    public String decide(List<PricePoint> pricePoints) {

        int size = pricePoints.size();
        Double btcFirst = pricePoints.get(0).getBtcPrice();
        Double btcLast = pricePoints.get(size-1).getBtcPrice();
        Double btcRoi = btcLast/btcFirst;

        Double ethFirst = pricePoints.get(0).getEthPrice();
        Double ethLast = pricePoints.get(size-1).getEthPrice();
        Double ethRoi = ethLast/ethFirst;

        return btcRoi > ethRoi ? "BTC":"ETH";

    }
}
