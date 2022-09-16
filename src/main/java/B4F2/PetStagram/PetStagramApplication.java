package B4F2.PetStagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ServletComponentScan
public class PetStagramApplication {

	// main branch
	public static void main(String[] args) {
		SpringApplication.run(PetStagramApplication.class, args);
	}

}
