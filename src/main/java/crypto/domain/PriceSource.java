package crypto.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BTC",
        "ETH"
})
public class PriceSource {

    @JsonProperty("BTC")
    private BTC bTC;
    @JsonProperty("ETH")
    private ETH eTH;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BTC")
    public BTC getBTC() {
        return bTC;
    }

    @JsonProperty("BTC")
    public void setBTC(BTC bTC) {
        this.bTC = bTC;
    }

    @JsonProperty("ETH")
    public ETH getETH() {
        return eTH;
    }

    @JsonProperty("ETH")
    public void setETH(ETH eTH) {
        this.eTH = eTH;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}