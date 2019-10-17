package crypto.pricing.domain;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Slf4j
@Entity
public class PricePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double btcPrice;
    private Double ethPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfPrice;

    public PricePoint(Double btcPrice, Double ethPrice, Date timeOfPrice) {
        this.btcPrice = btcPrice;
        this.ethPrice = ethPrice;
        this.timeOfPrice = timeOfPrice;
    }

    public String toString() {
        return "At time " + timeOfPrice + " price of BTC is:"
                + btcPrice + "$ and price of ETH is:" + ethPrice + "$";
    }
}
