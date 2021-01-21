package com.sinqia.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Participante.class)
public abstract class Participante_ {

	public static volatile SingularAttribute<Participante, String> senha;
	public static volatile ListAttribute<Participante, Permissao> permissoes;
	public static volatile SingularAttribute<Participante, Long> codigo;
	public static volatile SingularAttribute<Participante, String> telefone;
	public static volatile SingularAttribute<Participante, Endereco> endereco;
	public static volatile SingularAttribute<Participante, LocalDate> data_nascimento;
	public static volatile SingularAttribute<Participante, String> cpf;
	public static volatile SingularAttribute<Participante, String> email;
	public static volatile SingularAttribute<Participante, String> nomeCompleto;

	public static final String SENHA = "senha";
	public static final String PERMISSOES = "permissoes";
	public static final String CODIGO = "codigo";
	public static final String TELEFONE = "telefone";
	public static final String ENDERECO = "endereco";
	public static final String DATA_NASCIMENTO = "data_nascimento";
	public static final String CPF = "cpf";
	public static final String EMAIL = "email";
	public static final String NOME_COMPLETO = "nomeCompleto";

}

