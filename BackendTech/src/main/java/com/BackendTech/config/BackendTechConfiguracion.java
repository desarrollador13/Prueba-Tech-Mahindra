package com.BackendTech.config;


import javax.sql.DataSource;
import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.JpaTransactionManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ws.config.annotation.WsConfigurationSupport;

import org.springframework.transaction.PlatformTransactionManager;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@ConfigurationProperties
@EnableAsync
@EnableAutoConfiguration

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.BackendTech.repositorio"})
public class BackendTechConfiguracion extends WsConfigurationSupport{
	
	@Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
	 public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
	
	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix ="spring.datasource.tomcat")
	public HikariDataSource dataSource(DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = builder.dataSource(dataSource).packages("com.BackendTech.modelo")
				.persistenceUnit("GI").build();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.globally_quoted_identifiers", "true");
		properties.put("hibernate.default_schema", "PRUEBA"); // XXX COMENTARIAR ESTA LINEA EN MODO LOCAL o DESARROLLO
		System.out.println("LocalContainerEntityManagerFactoryBean=======>");

		em.setJpaPropertyMap(properties);
		em.afterPropertiesSet();
		return em;
	}
	
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
