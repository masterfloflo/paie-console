package dev.paie.console;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //on met cet en-tete

// Ensuite on peut par exemple avec un @Import {Menu.class, ..... } listé toutes les classes qui feront partie du contexte. Mais on va utiliser une autre possibilité
// ici meme chose mais on liste des packages
// ensuite on annotera les classes qui font partie de la config DANS ces packages avec des @Controller pour ihm et @Service pour le package service 
// Etape 4 : On creer une methode scanner avec @Bean pour qu'il soit executable partout avec un @Autowired scanner


@ComponentScan ({"dev.paie.ihm", "dev.paie.service"})
//Permet d’utiliser @transactional
@EnableTransactionManagement
//détecter les super-interfaces Spring Data Jpa
@EnableJpaRepositories("dev.paie.repository")


public class AppConfig {
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	/*
	@PreDestroy
	public void onDestroy() {
		System.out.println("On détruit");
		scanner.close();
	}
		*/
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/postgres"); //a modifier
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }

	
	@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(emf);
      return txManager;
    }

  @Bean
  // Cette configuration nécessite une source de données configurée.
  // Elle s'utilise donc en association avec un autre fichier de configuration définissant un bean DataSource.
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      vendorAdapter.setGenerateDdl(true);
      // activer les logs SQL
      vendorAdapter.setShowSql(true);

      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setJpaVendorAdapter(vendorAdapter);
      // alternative au persistence.xml
      factory.setPackagesToScan("dev.paie.domain");
      factory.setDataSource(dataSource);
      factory.afterPropertiesSet();

      return factory;
  }

	
	
	

}
