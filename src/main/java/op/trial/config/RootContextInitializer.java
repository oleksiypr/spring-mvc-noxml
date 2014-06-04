package op.trial.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class RootContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	@Override
	public void initialize(ConfigurableApplicationContext  rootContext) {
		AnnotationConfigWebApplicationContext context = (AnnotationConfigWebApplicationContext) rootContext;
		context.register(RootConfig.class);
	}	
}
