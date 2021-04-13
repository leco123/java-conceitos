package br.com.projeto.estudo.conhecimentosb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	// exemplo 1 http://localhost:8080/calculadora/somar/10/20
    @GetMapping("/somar/{vala}/{valb}")
    public int somar(@PathVariable int vala, @PathVariable int valb) {
        return vala + valb;
    }
    
    // exemplo 2 http://localhost:8080/calculadora/subtrair?vala=100&valb=25
    @GetMapping("/subtrair")
    public int subtrair(@RequestParam(name = "vala") int vala, @RequestParam(name = "valb")int valb) {
    		return vala - valb;
    }
}
