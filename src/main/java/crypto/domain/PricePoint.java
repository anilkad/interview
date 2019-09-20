package crypto.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class PricePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double btcPrice;
    private Double ethPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfPrice;

    protected PricePoint() {

    }

    public PricePoint(Double btcPrice, Double ethPrice, Date timeOfPrice) {
        this.btcPrice = btcPrice;
        this.ethPrice = ethPrice;
        this.timeOfPrice = timeOfPrice;
    }

    public Double getBtcPrice() {
        return btcPrice;
    }

    public Double getEthPrice() {
        return ethPrice;
    }


    public Date getTimeOfPrice() {
        return timeOfPrice;
    }


    public String toString() {
        return "At time " + timeOfPrice + " price of BTC is:"
                + btcPrice + "$ and price of ETH is:" + ethPrice + "$";
    }
}
