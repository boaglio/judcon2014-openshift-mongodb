package com.boaglio.filmes.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.boaglio.filmes.model.Filme;
import com.boaglio.filmes.repository.FilmesRepository;

@Service
public class FilmesDAO implements FilmesRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Filme> buscaTodos(String criterioDeBusca) {

		List<Filme> filmes = null;

		// db.filmes.find({"titulo":/.*he matrix.*/i})
		Query queryDeBuscaPorTitulo = new Query(Criteria.where("titulo").regex(".*" + criterioDeBusca + ".*","i"));

		filmes = mongoTemplate.find(queryDeBuscaPorTitulo,Filme.class);

		return filmes;
	}

	@Override
	public Filme buscaFilme(Long filmeID) {

		Filme filme = null;

		// db.filmes.find({"_id":1972399})
		Query queryDeBuscaPorID = new Query(Criteria.where("id").is(filmeID));

		filme = mongoTemplate.findOne(queryDeBuscaPorID,Filme.class);

		return filme;
	}

}
