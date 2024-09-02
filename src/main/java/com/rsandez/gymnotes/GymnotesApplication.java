package com.rsandez.gymnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class GymnotesApplication {

	public static void main(String[] args) {
		 // Cargar el archivo .env
		 Dotenv dotenv = Dotenv.load();

		 // Configurar las propiedades del sistema para que Spring Boot pueda usarlas
		 System.setProperty("SPRING_DATABASE_URL", dotenv.get("SPRING_DATABASE_URL"));
		 System.setProperty("SPRING_DATABASE_USERNAME", dotenv.get("SPRING_DATABASE_USERNAME"));
		 System.setProperty("SPRING_DATABASE_PASSWORD", dotenv.get("SPRING_DATABASE_PASSWORD"));
		
		 SpringApplication.run(GymnotesApplication.class, args);
	}

}
