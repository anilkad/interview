package crypto.decision.domain;

public class PriceData {

    private Double btcPrice;
    private Double ethPrice;

    public PriceData() { }

    public PriceData(Double btcPrice, Double ethPrice) {
        this.btcPrice = btcPrice;
        this.ethPrice = ethPrice;
    }

    public Double getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(Double btcPrice) {
        this.btcPrice = btcPrice;
    }

    public Double getEthPrice() {
        return ethPrice;
    }

    public void setEthPrice(Double ethPrice) {
        this.ethPrice = ethPrice;
    }

}
