package com.boaglio.filmes.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.boaglio.filmes.model.Filme;
import com.boaglio.filmes.model.Voto;
import com.boaglio.filmes.repository.VotosRepository;

@Service
public class VotosDAO implements VotosRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void gravaVoto(Long filmeID) {

		Voto voto = null;
		Filme filme = null;

		// db.filmes.find({"_id":1972399})
		Query queryDeBuscaFilmePorTitulo = new Query(Criteria.where("id").is(filmeID));
		filme = mongoTemplate.findOne(queryDeBuscaFilmePorTitulo,Filme.class);

		// db.filmes.insert
		Query queryDeBuscaVotoPorTitulo = new Query(Criteria.where("filme").is(filme.getTitulo()));
		voto = mongoTemplate.findOne(queryDeBuscaVotoPorTitulo,Voto.class);

		if (voto == null) {
			voto = new Voto();
			voto.setFilme(filme.getTitulo());
			voto.setTotalDeVotos(0l);
		}
		long totalDeVotos = voto.getTotalDeVotos();
		voto.setTotalDeVotos(totalDeVotos + 1);
		mongoTemplate.save(voto);

	}

	@Override
	public List<Voto> buscaVotos() {
		List<Voto> votos = null;
		// db.votos.find()
		votos = mongoTemplate.findAll(Voto.class);
		return votos;
	}

}
