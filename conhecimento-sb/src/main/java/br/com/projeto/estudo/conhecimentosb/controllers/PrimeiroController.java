package br.com.projeto.estudo.conhecimentosb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	/**
	 * Define quais urls que seram chamadas quando carregar este método
	 * @return
	 */
	@RequestMapping(path = {"/ola","/home"})
	public String ola() {
		return "Olá Spring Boot!";
	}

}
