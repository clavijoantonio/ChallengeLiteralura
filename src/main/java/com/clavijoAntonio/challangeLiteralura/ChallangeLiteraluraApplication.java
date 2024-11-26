package com.clavijoAntonio.challangeLiteralura;

import com.clavijoAntonio.challangeLiteralura.repository.IAuthorRepository;
import com.clavijoAntonio.challangeLiteralura.service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clavijoAntonio.challangeLiteralura.principal.Principal;
import com.clavijoAntonio.challangeLiteralura.repository.ILibroRepository;

@SpringBootApplication
public class ChallangeLiteraluraApplication implements CommandLineRunner {

    @Autowired
	ILibroRepository repository;
	@Autowired
	LibrosService librosService;
	@Autowired
	IAuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallangeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository,librosService,authorRepository);
		principal.menu();
	}
}
