package umut.PriceTrackerJob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umut.PriceTrackerJob.Entities.Product;

import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Product, UUID> {
    Product findByUrl(String url);
}
