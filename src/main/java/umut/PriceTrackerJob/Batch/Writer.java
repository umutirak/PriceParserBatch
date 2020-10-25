package umut.PriceTrackerJob.Batch;

import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import umut.PriceTrackerJob.Repositories.ProductPricesRepository;

import java.util.List;

@AllArgsConstructor
@Component
public class Writer implements ItemWriter<CustomProductModel> {
    private final ProductPricesRepository pricesRepository;

    @Override
    public void write(List<? extends CustomProductModel> list) {
        System.out.println("Writing");
        for (CustomProductModel item : list) {
            pricesRepository.save(item.getCurrentPrice());
        }
    }


}
