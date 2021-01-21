
CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE participante_permissao (
	codigo_participante BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_participante, codigo_permissao),
	FOREIGN KEY (codigo_participante) REFERENCES participante(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_PARTICIPANTE');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_PARTICIPANTE');
INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_REMOVER_PARTICIPANTE');
INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_ATUALIZAR_PARTICIPANTE');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_ATUALIZAR_PARTICIPANTE_CPF');
insert INTO permissao (codigo,descricao) values (6,  'ROLE_PESQUISAR_PARTICIPANTE_POR_CODIGO');
insert INTO permissao (codigo,descricao) values (7,  'ROLE_PESQUISAR_CEP');
insert INTO permissao (codigo,descricao) values (8,  'ROLE_ADMIN');
insert INTO permissao (codigo,descricao) values (9,  'ROLE_USER');


-- admin
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 1);
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 2);
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 3);
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 4);
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 5);
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 6);
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 7);
INSERT INTO participante_permissao (codigo_participante, codigo_permissao) values (1, 8);




