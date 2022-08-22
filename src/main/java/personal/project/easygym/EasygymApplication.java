package personal.project.easygym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EasygymApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasygymApplication.class, args);
	}

}
