package edu.senac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OlaMundoController {
	
	@GetMapping("olaMundo")
	public String olaMundo() {
		return "Olá Mundo";
	}

}
