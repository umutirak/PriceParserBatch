package umut.PriceTrackerJob.Config;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import umut.PriceTrackerJob.Batch.CustomProductModel;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Value("${app.datasource.url}")
    private String url;
    @Value("${app.datasource.username}")
    private String username;
    @Value("${app.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public ItemProcessor<CustomProductModel, CustomProductModel> itemProcessor() {
        return new PassThroughItemProcessor<>();
    }

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<CustomProductModel> itemReader, ItemProcessor<CustomProductModel, CustomProductModel> itemProcessor, ItemWriter<CustomProductModel> itemWriter, ItemWriteListener<CustomProductModel> writeListener) {
        Step step = stepBuilderFactory.get("batch-step")
                .<CustomProductModel, CustomProductModel>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .listener(writeListener)
                .build();

        return jobBuilderFactory.get("batch-job")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

}
