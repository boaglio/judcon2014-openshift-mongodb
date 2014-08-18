package com.boaglio.filmes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "votos")
public class Voto {

	@Id
	private String filme;

	private Long totalDeVotos;

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public Long getTotalDeVotos() {
		return totalDeVotos;
	}

	public void setTotalDeVotos(Long totalDeVotos) {
		this.totalDeVotos = totalDeVotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (filme == null ? 0 : filme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		Voto other = (Voto) obj;
		if (filme == null) {
			if (other.filme != null) { return false; }
		} else if (!filme.equals(other.filme)) { return false; }
		return true;
	}

	@Override
	public String toString() {
		return "Voto [filme=" + filme + ", totalDeVotos=" + totalDeVotos + "]";
	}

}
