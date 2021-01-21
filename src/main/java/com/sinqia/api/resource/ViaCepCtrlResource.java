package com.sinqia.api.resource;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sinqia.api.model.Endereco;

@RestController
@RequestMapping("/cep")
public class ViaCepCtrlResource implements Serializable {

	private static final String URL = "http://viacep.com.br/ws";
	private static final long serialVersionUID = 1L;

	@GetMapping(value = "/{cep}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CEP') and #oauth2.hasScope('read')")
	public ResponseEntity<Endereco> buscarEnderecoPorCep(@PathVariable(name = "cep") String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = URL + "/{cep}/json/";
		String cepSemSimbolos = cep.replaceAll("\\D", "");

		Endereco retornoCepEndereco = restTemplate.getForObject(uri, Endereco.class, cepSemSimbolos);
		return retornoCepEndereco != null ? new ResponseEntity<Endereco>(retornoCepEndereco, HttpStatus.OK)
				: new ResponseEntity<Endereco>(retornoCepEndereco, HttpStatus.NO_CONTENT);

	}

}
