package br.com.alura.mvc.mundi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MundiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MundiApplication.class, args);
	}

}
