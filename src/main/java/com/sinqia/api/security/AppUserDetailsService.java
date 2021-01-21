package com.sinqia.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sinqia.api.model.Participante;
import com.sinqia.api.repository.ParticipanteRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Participante> participanteOptional = participanteRepository.findByEmail(email);
		Participante participante = participanteOptional.orElseThrow(() -> new UsernameNotFoundException("E-mail e/ou senha incorretos"));
		return new UsuarioSistema(participante, getPermissoes(participante));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Participante participante) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		participante.getPermissoes().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
		return authorities;
	}

}