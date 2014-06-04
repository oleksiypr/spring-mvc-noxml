package op.trial.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Import({TestRepositoryConfig.class})
@ComponentScan(basePackages = {"op.trial.dao"})
public class TestConfig {
	@Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("test_db.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
}
