package com.boaglio.filmes.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boaglio.filmes.model.Filme;

@Repository
public interface FilmesRepository {

	List<Filme> buscaTodos(String criterioDeBusca);

	Filme buscaFilme(Long filmeID);

}
