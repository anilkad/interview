package crypto.decision.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class PriceData {
    private Double btcPrice;
    private Double ethPrice;
}
