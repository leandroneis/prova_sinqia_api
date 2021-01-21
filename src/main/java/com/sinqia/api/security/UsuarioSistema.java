package com.sinqia.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.sinqia.api.model.Participante;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;

	private Participante participante;

	public UsuarioSistema(Participante participante, Collection<? extends GrantedAuthority> authorities) {
		super(participante.getEmail(), participante.getSenha(), authorities);
		this.participante = participante;
	}

	public Participante getParticipante() {
		return participante;
	}

}