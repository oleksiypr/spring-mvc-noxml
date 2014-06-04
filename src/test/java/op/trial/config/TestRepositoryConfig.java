package op.trial.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class TestRepositoryConfig {
	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;
	
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
    }
 
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean result = new LocalSessionFactoryBean();
        result.setDataSource(dataSource());
        result.setPackagesToScan(new String[] { "op.trial.domain" });
 
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        
		result.setHibernateProperties(properties);
        return result;        
    }
 
    @Bean
    public SessionFactory sessionFactory() {
        return sessionFactoryBean().getObject();
    }
 
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager man = new HibernateTransactionManager();
        man.setSessionFactory(sessionFactory());
        return man;
    }
}
