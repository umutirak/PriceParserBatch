package umut.PriceTrackerJob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umut.PriceTrackerJob.Entities.ProductPrice;

import java.util.UUID;

@Repository
public interface ProductPricesRepository extends JpaRepository<ProductPrice, UUID> {
    ProductPrice findFirstByProductIdOrderByCreateDateDesc(UUID productId);
}
