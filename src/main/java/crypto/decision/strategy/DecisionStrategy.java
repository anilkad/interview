package crypto.decision.strategy;

import crypto.decision.domain.PriceData;

import java.util.List;

public interface DecisionStrategy {
    String decide(List<PriceData> pricePoints);
}
