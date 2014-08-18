package com.boaglio.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boaglio.filmes.model.Voto;
import com.boaglio.filmes.repository.VotosRepository;

@Controller
public class VotosController {

	@Autowired
	private VotosRepository repository;

	@RequestMapping(value = "/votar",method = RequestMethod.GET)
	public String votar(@RequestParam("id") Long filmeID,ModelMap model) {

		repository.gravaVoto(filmeID);

		List<Voto> votos = repository.buscaVotos();
		model.addAttribute("votos",votos);

		return "votos";

	}

	@RequestMapping(value = "/votos",method = RequestMethod.GET)
	public String votos(ModelMap model) {

		List<Voto> votos = repository.buscaVotos();
		model.addAttribute("votos",votos);

		return "votos";

	}

}
