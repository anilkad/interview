package crypto.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PricePointRepository extends PagingAndSortingRepository<PricePoint,Long> {
    List<PricePoint> findAllByTimeOfPriceBetween(Date start, Date end);
    List<PricePoint> findAllByTimeOfPriceAfter(Date date);
    PricePoint findById(long id);
}
