package umut.PriceTrackerJob.Batch;

import lombok.Getter;
import lombok.Setter;
import umut.PriceTrackerJob.Entities.Product;
import umut.PriceTrackerJob.Entities.ProductPrice;

@Getter
@Setter
public class CustomProductModel {
    private Product product;
    private ProductPrice lastPrice;
    private ProductPrice currentPrice;
}
