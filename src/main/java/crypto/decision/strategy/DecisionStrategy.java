package crypto.decision.strategy;

import crypto.domain.PricePoint;

import java.util.List;

public interface DecisionStrategy {
    String decide(List<PricePoint> pricePoints);
}
