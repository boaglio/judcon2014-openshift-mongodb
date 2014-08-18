package com.boaglio.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boaglio.filmes.model.Filme;
import com.boaglio.filmes.repository.FilmesRepository;

@Controller
public class FilmesController {

	@Autowired
	private FilmesRepository repository;

	@RequestMapping(value = "/busca",method = RequestMethod.GET)
	public String buscaPorFilmes(@RequestParam("criterioDeBusca") String criterioDeBusca,ModelMap model) {

		List<Filme> filmes = repository.buscaTodos(criterioDeBusca);
		model.addAttribute("filmes",filmes);
		return "filmes";

	}

}
