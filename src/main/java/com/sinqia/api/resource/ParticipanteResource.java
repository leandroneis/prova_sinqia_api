package com.sinqia.api.resource;

import java.util.Optional;

import com.sinqia.api.event.RecursoCriadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sinqia.api.model.Participante;
import com.sinqia.api.repository.ParticipanteRepository;
import com.sinqia.api.repository.filter.ParticipanteFilter;
import com.sinqia.api.service.ParticipanteService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/participantes")
public class ParticipanteResource {

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private ParticipanteService participanteService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PARTICIPANTE') and #oauth2.hasScope('write')")
	public ResponseEntity<Participante> criar(@Validated @RequestBody Participante participante, HttpServletResponse response) {
		Participante participanteSalva = participanteService.salvar(participante);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, participanteSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(participanteSalva);
	}

	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PARTICIPANTE_POR_CODIGO') and #oauth2.hasScope('write')")
	public ResponseEntity<Participante> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Participante> participante = participanteRepository.findById(codigo);
		return participante.isPresent() ? ResponseEntity.ok(participante.get()) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_PARTICIPANTE') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		participanteRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_PARTICIPANTE') and #oauth2.hasScope('write')")
	public ResponseEntity<Participante> atualizar(@PathVariable Long codigo, @Validated @RequestBody Participante participante) {
		Participante ParticipanteSalva = participanteService.atualizar(codigo, participante);
		return ResponseEntity.ok(ParticipanteSalva);
	}


	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PARTICIPANTE') and #oauth2.hasScope('read')")
	public Page<Participante> pesquisar(ParticipanteFilter participanteFilter, Pageable pageable) {
		return participanteRepository.filtrar(participanteFilter, pageable);
	}

}
