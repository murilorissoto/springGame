package com.senai.murilo.PrjGame.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.murilo.PrjGame.Entities.*;
import com.senai.murilo.PrjGame.Repositories.*;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;
	
	@Autowired
	public JogoService( JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public Jogo saveJogo (Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	public Jogo getJogoById (Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public List<Jogo> getAllJogo(){
		return jogoRepository.findAll();
	}
	
	public void deleteJogo (Long id) {
		jogoRepository.deleteById(id);
	}

}


