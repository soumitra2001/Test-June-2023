package com.example.Simple.Project;

import com.example.Simple.Project.model.User;
import com.example.Simple.Project.repository.IUserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class SimpleProjectApplicationTests {

	@Autowired
	IUserRepo userRepo;

	@Container
	private static MySQLContainer container= new MySQLContainer("mysql:8.0.33")
			.withDatabaseName("simpleproject")
			.withUsername("root")
			.withPassword("Ghorai@2001");


	@DynamicPropertySource
	public static void myProperties(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url",container::getJdbcUrl);
		registry.add("spring.datasource.username",container::getUsername);
		registry.add("spring.datasource.password",container::getPassword);
	}

	@Test
	void contextLoads() {
		User user = new User(0L,"Supriya","sg@gmail.com","password");

		userRepo.save(user);
		System.out.println(user);
	}

}