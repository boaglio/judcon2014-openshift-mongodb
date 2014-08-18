package com.boaglio.filmes.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boaglio.filmes.model.Voto;

@Repository
public interface VotosRepository {

	void gravaVoto(Long filmeID);

	List<Voto> buscaVotos();

}
