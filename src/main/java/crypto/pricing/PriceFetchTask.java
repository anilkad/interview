package crypto.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PriceFetchTask {

    @Autowired
    PricingService pricingService;

    /**
     * Fetches prices from external services every two seconds
     */
    @Scheduled(fixedRate = 2000)
    public void fetchStockPrice() {
        pricingService.fetchStockPrice();
    }
}
