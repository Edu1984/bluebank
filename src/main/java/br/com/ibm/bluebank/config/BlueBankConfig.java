package br.com.ibm.bluebank.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import br.com.ibm.bluebank.dao.AccountantDAO;
import br.com.ibm.bluebank.dao.AccountantHibernateDAO;
import br.com.ibm.bluebank.entity.Accountant;
import br.com.ibm.bluebank.entity.ElectronicTransfer;
import br.com.ibm.bluebank.service.AccountantService;
import br.com.ibm.bluebank.service.AccountantServiceImpl;

@Configuration
public class BlueBankConfig {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) 
			.addScript("db/sql/create-db.sql")
			.addScript("db/sql/insert-data.sql")
			.build();
		return db;
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new LocalSessionFactoryBuilder(dataSource())
	        .addProperties(getHibernateProperties())
	        .addAnnotatedClass(Accountant.class)
	        .addAnnotatedClass(ElectronicTransfer.class)
	        .buildSessionFactory();
	    return sessionFactory;
	}

	private Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		hibernateProperties.put("hibernate.current_session_context_class", "thread");
		hibernateProperties.put("hibernate.show_sql", "true");
		return hibernateProperties;
	}
	
	@Bean
	public AccountantService accountantService(){
		AccountantService accountantService = new AccountantServiceImpl(accountantDAO());
		return accountantService;
	}
	
	@Bean
	public AccountantDAO accountantDAO(){
		AccountantDAO accountantDAO = new AccountantHibernateDAO(sessionFactory());
		return accountantDAO;
	}
	
}
