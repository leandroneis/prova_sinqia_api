package com.sinqia.api.model;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "participante")
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
public class Participante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long codigo;

	@NotNull
	@Column(name = "nome_completo")
	@Getter @Setter private String nomeCompleto;
	
	@CPF
	@Getter @Setter private String cpf;
	@Column(name = "data_nascimento")
	@Getter @Setter private LocalDate dataNascimento;
	@Getter @Setter private String email;
	@Getter @Setter private String telefone;
	@Getter @Setter private String senha;

	@Embedded
	@Getter @Setter private Endereco endereco;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "participante_permissao", joinColumns = @JoinColumn(name = "codigo_participante"), inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))
	@Getter @Setter private List<Permissao> permissoes;


}
