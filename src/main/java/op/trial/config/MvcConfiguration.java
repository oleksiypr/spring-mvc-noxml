package op.trial.config;

import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import freemarker.template.TemplateException;

@Configuration
@ComponentScan(basePackages = "op.trial.web.controller")
@ImportResource("classpath:/mvc-security-enabler.xml")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public FreeMarkerConfigurer freeMarkerPreConfigurer() throws IOException, TemplateException {
		FreeMarkerConfigurer config = new FreeMarkerConfigurer();
		config.setTemplateLoaderPath("/WEB-INF/ftl/");
		return config;
	}

	@Bean
	public ViewResolver viewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setExposeSpringMacroHelpers(true);
		resolver.setCache(false);
		resolver.setSuffix(".ftl");
		resolver.setContentType("text/html;charset=UTF-8");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();        
        bean.setBasename("classpath:messages");
        bean.setDefaultEncoding("UTF-8");
        return bean;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor bean = new LocaleChangeInterceptor();        
        bean.setParamName("lang");
        return bean;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(localeChangeInterceptor());
      super.addInterceptors(registry);
   }
}
