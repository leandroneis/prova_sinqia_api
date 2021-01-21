package com.sinqia.api.repository.participante;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sinqia.api.model.Participante;
import com.sinqia.api.repository.filter.ParticipanteFilter;

public interface ParticipanteRepositoryQuery {

	public Page<Participante> filtrar(ParticipanteFilter participanteFilter, Pageable pageable);

}