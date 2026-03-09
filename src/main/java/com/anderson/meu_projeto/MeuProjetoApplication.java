package com.anderson.meu_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MeuProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuProjetoApplication.class, args);
	}

}
