package umut.PriceTrackerJob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umut.PriceTrackerJob.Entities.ProductCategory;

import java.util.UUID;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategory, UUID> {
    ProductCategory findByName(String name);
}
