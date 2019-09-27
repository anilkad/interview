package crypto.decision.strategy;

import crypto.decision.domain.PriceData;

import reactor.core.publisher.Flux;

public interface DecisionStrategy {
    String decide(Flux<PriceData> pricePoints);
}
