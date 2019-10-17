package crypto.decision.strategy;

import crypto.decision.domain.PriceData;

import reactor.core.publisher.Flux;

/**
 * Decision Strategy interface has only one method decide
 */
public interface DecisionStrategy {
    String decide(Flux<PriceData> pricePoints);
}
