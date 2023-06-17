package springmvc_configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages= {"spring_MVC"})
public class Config {
	@Bean
	@Scope(value="prototype")
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rakesh");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		}
	
	

}
