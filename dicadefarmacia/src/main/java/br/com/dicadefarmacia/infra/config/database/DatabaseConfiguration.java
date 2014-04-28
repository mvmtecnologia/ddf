package br.com.dicadefarmacia.infra.config.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource("classpath:/br/com/dicadefarmacia/infra/config/database/jdbc.properties")
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Autowired
	private Environment environment;
 
	@Bean
	public DataSource dataSource(){
		final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setPassword(environment.getProperty("jdbc.password"));
		driverManagerDataSource.setUrl(environment.getProperty("jdbc.databaseurl"));
		driverManagerDataSource.setUsername(environment.getProperty("jdbc.username"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		return driverManagerDataSource;
	}
 
	@Bean
	@DependsOn("dataSource")
	public LocalSessionFactoryBean sessionFactory(){
		final LocalSessionFactoryBean  localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setAnnotatedPackages("br.com.dicadefarmacia.domain");
        localSessionFactoryBean.setPackagesToScan("br.com.dicadefarmacia.domain");
		final Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.hbm2ddl.auto",environment.getProperty("jdbc.hbm2ddl.auto"));
		hibernateProperties.put("hibernate.dialect", environment.getProperty("jdbc.dialect"));
		hibernateProperties.put("hibernate.show_sql", environment.getProperty("jdbc.show_sql"));
		hibernateProperties.put("hibernate.format_sql", environment.getProperty("jdbc.format_sql"));
		localSessionFactoryBean.setHibernateProperties(hibernateProperties );
		
		return localSessionFactoryBean;
	}
 
	@Bean
	@DependsOn("sessionFactory")
	public HibernateTransactionManager transactionManager(){
		final HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
 		return hibernateTransactionManager;
	}


}
