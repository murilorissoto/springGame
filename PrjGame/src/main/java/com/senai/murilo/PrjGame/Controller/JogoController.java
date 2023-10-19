package com.senai.murilo.PrjGame.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senai.murilo.PrjGame.Entities.*;
import com.senai.murilo.PrjGame.Services.*;

@RestController
@RequestMapping("/jogos")
public class JogoController {

	private final JogoService jogoService;

	@Autowired
	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // Nome do arquivo HTML
	}

	@GetMapping("/(id)")
	public ResponseEntity<Jogo> getjogo(@PathVariable Long id) {
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Jogo createJogo(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);

	}

	@GetMapping("/{id}")
	public Jogo getJogo(@PathVariable Long id) {
		return jogoService.getJogoById(id);
	}
	
	@GetMapping
	public List<Jogo> getAllJogo() {
		return jogoService.getAllJogo();
	}

	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}
}
