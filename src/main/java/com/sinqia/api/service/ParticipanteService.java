package com.sinqia.api.service;

import java.util.ArrayList;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sinqia.api.model.Participante;
import com.sinqia.api.model.Permissao;
import com.sinqia.api.repository.ParticipanteRepository;
import com.sinqia.api.repository.PermissaoRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	public Participante salvar(Participante participante) {
		atribuiPermissoesAoParticipante(participante);
		participante.setSenha(encriptarSenha(participante.getSenha()));
		return participanteRepository.save(participante);

	}
	
	private String encriptarSenha(String senha) {
		return encoder.encode(senha);
	}

	private void atribuiPermissoesAoParticipante(Participante participante) {
		List<Permissao> permissoes = new ArrayList<Permissao>();
		permissoes.add(permissaoRepository.findByCodigo(2L));
		permissoes.add(permissaoRepository.findByCodigo(4L));
		permissoes.add(permissaoRepository.findByCodigo(6L));
		permissoes.add(permissaoRepository.findByCodigo(7L));
		permissoes.add(permissaoRepository.findByCodigo(9L));

		participante.setPermissoes(permissoes);

	}

	public Participante atualizar(Long codigo, Participante participante) {
		Participante participanteSalvo = buscarParticipantePeloCodigo(codigo);
		BeanUtils.copyProperties(participante, participanteSalvo, "codigo");
		participanteSalvo.setSenha(encriptarSenha(participante.getSenha()));
		return participanteRepository.save(participanteSalvo);
	}

	public Participante buscarParticipantePeloCodigo(Long codigo) {
		Optional<Participante> pessoaSalva = participanteRepository.findById(codigo);
		if (!pessoaSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva.get();
	}
}
