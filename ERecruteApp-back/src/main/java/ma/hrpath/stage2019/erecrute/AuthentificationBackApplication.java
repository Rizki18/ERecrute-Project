package ma.hrpath.stage2019.erecrute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ma")
@EntityScan("ma.*")
@EnableJpaRepositories("ma.*")
public class AuthentificationBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationBackApplication.class, args);
	}

}
