CREATE TABLE participante (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome_completo VARCHAR(50) NOT NULL,
    cpf VARCHAR(14) NOT NULL ,
    data_nascimento DATE NULL,
    email VARCHAR(100) NOT NULL,
	telefone VARCHAR(20) NULL,
    senha VARCHAR(150) NOT NULL,
    logradouro VARCHAR(150) NULL,
	numero VARCHAR(30) NULL,
	complemento VARCHAR(40) NULL,
	bairro VARCHAR(150) NULL,
	cep VARCHAR(10) NULL,
	localidade VARCHAR(150) NULL,
	uf VARCHAR(150) NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    

INSERT INTO participante (nome_completo,cpf,data_nascimento,email,telefone,senha, logradouro,numero,complemento,bairro,cep,localidade,uf) VALUES
 ("Admin","573.667.110-71","2021-01-19","admin@sinqia.com.br","(048)99999999","$2a$10$vJlYgcB.YmuT9G3SBBZk8OY6Xov2oKlsY8mFyyizAzoL8PvcRabaG","R. Cônego Bernardo","57","2º Andar Sala 201","Trindade","88036570","Florianópolis","SC");


	










