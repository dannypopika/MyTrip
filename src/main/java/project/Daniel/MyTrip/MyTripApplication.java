package project.Daniel.MyTrip;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import project.Daniel.MyTrip.Model.StorageDirectory;
import project.Daniel.MyTrip.Service.StorageService;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(StorageDirectory.class)
public class MyTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTripApplication.class, args);
	}


	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.createDirectory();
		};
	}
}
