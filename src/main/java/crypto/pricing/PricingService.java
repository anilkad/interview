package crypto.pricing;

import crypto.pricing.domain.PricePoint;
import crypto.pricing.domain.PricePointRepository;
import crypto.pricing.domain.PriceSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class PricingService {

    Logger logger = LoggerFactory.getLogger(PricingService.class);

    // TODO Actually read from application properties file
    private final String API_KEY = "5dda852718cb205d69188b8a5779c99d6af2da041ee4f5000f205958992662ae";

    // TODO Needs to some from external config
    private final String PRICE_FETCH_URL = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD&api_key=" + API_KEY;


    @Autowired
    private PricePointRepository pricingRepository;

    public List<PricePoint> getPricePointsAfter(Date dateTime) {
        return pricingRepository.findAllByTimeOfPriceAfter(dateTime);
    }

    /**
     * This is going to save the given price point in the repository
     * @param pricePoint
     */
    public void savePricePoint(PricePoint pricePoint) {
        pricingRepository.save(pricePoint);
    }

    /**
     * Fetches a price from external servuce crypto compare and saves in the repo
     */
    public void fetchStockPrice() {
        RestTemplate restTemplate = new RestTemplate();
        PriceSource priceSource = restTemplate.getForEntity(PRICE_FETCH_URL, PriceSource.class).getBody();

        PricePoint pricePoint = new PricePoint(priceSource.getBTC().getUSD(), priceSource.getETH().getUSD(), Date.from(Instant.now()));

        savePricePoint(pricePoint);
        logger.trace("Saved a nee pricing data point");
    }
}
