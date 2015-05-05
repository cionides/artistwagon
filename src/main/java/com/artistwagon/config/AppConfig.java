package com.artistwagon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.artistwagon.web*" })
@Import({ SecurityConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter {
 
	@Bean
    public SessionFactory sessionFactory() {
            LocalSessionFactoryBuilder builder = 
		new LocalSessionFactoryBuilder(dataSource());
            builder.scanPackages("com.artistwagon.web.domain")
                  .addProperties(getHibernateProperties());

            return builder.buildSessionFactory();
    }

	private Properties getHibernateProperties() {
            Properties prop = new Properties();
            prop.put("hibernate.format_sql", "true");
            prop.put("hibernate.show_sql", "true");
            prop.put("hibernate.dialect", 
                "org.hibernate.dialect.MySQL5Dialect");
            return prop;
    }

	@Bean
    public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/**");
		 
    }
	
	@Bean(name = "dataSource")
		public DriverManagerDataSource dataSource() {
		    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		    //driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		    //driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/artistwagon");
		    //driverManagerDataSource.setUsername("root");
		    

			driverManagerDataSource.setDriverClassName("com.mysql.jdbc.GoogleDriver");
			driverManagerDataSource.setUrl("jdbc:google:mysql://arcane-mission-217:aw-dev?user=root");

		    return driverManagerDataSource;
	 }
	
	 @Bean
	 public InternalResourceViewResolver viewResolver() {
		 	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
		
			return viewResolver;
	 }
	
}
