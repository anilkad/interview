package crypto.pricing;

import crypto.pricing.domain.PricePoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
public class PricingController {

    Logger logger = LoggerFactory.getLogger(PricingController.class);

    // TODO Actually read from application properties file
    private final String API_KEY = "5dda852718cb205d69188b8a5779c99d6af2da041ee4f5000f205958992662ae";

    // TODO Needs to some from external config
    private final String PRICE_FETCH_URL = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD&api_key=" + API_KEY;

    @Autowired
    PricingService pricingService;


    @RequestMapping("/feedprices")
    public String fetchNewPricePoint() {

        pricingService.fetchStockPrice();
        return "OK";
    }

    @RequestMapping("/fetchprices/after")
    public List<PricePoint> listPricesAfter(@RequestParam(defaultValue = "30") int numSeconds) {
        Date reqDate = Date.from(Instant.now().minusSeconds(numSeconds));
        logger.info("Requesting for Date After:" + reqDate.toString());
        return pricingService.getPricePointsAfter(reqDate);
    }

}
