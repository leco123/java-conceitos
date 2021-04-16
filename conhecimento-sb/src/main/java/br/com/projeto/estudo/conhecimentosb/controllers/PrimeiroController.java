package br.com.projeto.estudo.conhecimentosb.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	/**
	 * Define quais urls que seram chamadas quando carregar este método
	 * @return
	 */
	@RequestMapping(path = {"/ola","/saudacao"})
	public String ola() {
		return "Olá Spring Boot!";
	}
	
	/**
	 * Usando mesmo path, retorna erro mesmo sendo método diferente
	 * @return
	 */
	/*
	@RequestMapping(path = {"/saudacao"})
	public String saudacao() {
		return "Olá Spring Boot!";
	}
	*/
	
	@PostMapping(path = {"/saudacao"})
	public String saudacao() {
		return "Olá Spring Boot (POST)!";
	}

}
