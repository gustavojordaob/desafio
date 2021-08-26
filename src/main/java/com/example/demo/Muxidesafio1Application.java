package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Terminal;
import com.example.demo.repository.TerminalRepository;

@SpringBootApplication
public class Muxidesafio1Application implements CommandLineRunner {

	@Autowired
	private TerminalRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Muxidesafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Terminal terminal = new Terminal(44332211,"123", "PWWIN", 0, "F04A2E4088B", 4, "8.00b3", 0, 16777216, "PWWIN");
		repo.save(terminal);
		
	}

}
