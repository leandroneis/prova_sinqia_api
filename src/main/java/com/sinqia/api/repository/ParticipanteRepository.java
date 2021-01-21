package com.sinqia.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinqia.api.model.Participante;
import com.sinqia.api.repository.participante.ParticipanteRepositoryQuery;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>,ParticipanteRepositoryQuery {

	public Optional<Participante> findByEmail(String email);

	public List<Participante> findByPermissoesDescricao(String permissaoDescricao);

}
