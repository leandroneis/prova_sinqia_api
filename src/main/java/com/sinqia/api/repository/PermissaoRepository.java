package com.sinqia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinqia.api.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	
	public Permissao findByCodigo(Long  codigo);

	

}
