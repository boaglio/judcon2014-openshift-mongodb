package com.boaglio.filmes.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.boaglio.filmes.model.Filme;

@Repository
public class FilmesRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Filme> buscaTodos(String criterioDeBusca) {

		List<Filme> filmes = null;

		// db.filmes.find({"titulo":/.*he matrix.*/i})
		Query queryDeBuscaPorTitulo = new Query(Criteria.where("titulo").regex(".*" + criterioDeBusca + ".*","i"));

		// exibe no maximo 100 registros
		queryDeBuscaPorTitulo.limit(100);

		filmes = mongoTemplate.find(queryDeBuscaPorTitulo,Filme.class);

		return filmes;
	}

	public Filme buscaFilme(Long filmeID) {

		Filme filme = null;

		// db.filmes.find({"_id":1972399})
		Query queryDeBuscaPorID = new Query(Criteria.where("id").is(filmeID));

		filme = mongoTemplate.findOne(queryDeBuscaPorID,Filme.class);

		return filme;
	}
}
