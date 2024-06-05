INSERT INTO TB_ENDERECO (rua_endereco, cid_endereco, uf_endereco)
VALUES ('Avenida Presidente Wilson', 'Santos', 'SP');
INSERT INTO TB_ENDERECO (rua_endereco, cid_endereco, uf_endereco)
VALUES ('Avenida Atlântica', 'Rio de Janeiro', 'RJ');
INSERT INTO TB_ENDERECO (rua_endereco, cid_endereco, uf_endereco)
VALUES ('Avenida Zezé Diogo', 'Ceará', 'CE');

INSERT INTO TB_RESPONSAVEL (nm_responsavel, cpf_responsavel)
VALUES ('Iago Dias', '11122233300');
INSERT INTO TB_RESPONSAVEL (nm_responsavel, cpf_responsavel)
VALUES ('Vinicius Cruzeiro', '44422233300');
INSERT INTO TB_RESPONSAVEL (nm_responsavel, cpf_responsavel)
VALUES ('Henrique Abduch', '55522233300');

INSERT INTO TB_ORGANIZACAO (nm_organizacao, desc_organizacao, tp_organizacao, cnpj_organizacao, id_endereco, id_responsavel)
VALUES ('Vozes do Mar', 'Organização sem fins lucrativos criada com o intuito de auxiliar a conservação da Vida marinha',
'ONG', '11111111111442', 1, 1);
INSERT INTO TB_ORGANIZACAO (nm_organizacao, desc_organizacao, tp_organizacao, cnpj_organizacao, id_endereco, id_responsavel)
VALUES ('Prefeitura de Santos', 'Sede do poder executivo do município de Santos',
'Governamental', '11111111122432', 2, 2);
INSERT INTO TB_ORGANIZACAO (nm_organizacao, desc_organizacao, tp_organizacao, cnpj_organizacao, id_endereco, id_responsavel)
VALUES ('Projeto Tamar', 'Instituição que atua no litoral brasileiro desde a década de 80, o Projeto Tamar tem como missão promover a recuperação das tartarugas marinhas',
'ONG', '22111111111442', 3, 3);

INSERT INTO TB_USER (nm_user, email_user, senha_user, id_organizacao)
VALUES ('User Teste', 'usertese@gmail.com', '1234', 1);
INSERT INTO TB_USER (nm_user, email_user, senha_user, id_organizacao)
VALUES ('HLins', 'hebertclins@gmail.com', '4321', 3);

INSERT INTO TB_PRAIA (NOME_PRAIA, DESC_PRAIA, LIMPEZA_PRAIA, ESTRUTURA_PRAIA, SINALIZACAO_PRAIA, MONITORAMENTO_PRAIA, POLUICAO_PRAIA, CONSERVACAO_AMBIENTAL_PRAIA, TOTAL_PRAIA, ID_ENDERECO)
VALUES ('Praia do Gonzaga', 'Praia localizado entre os bairros Gonzaga, Vila Haddad e Boqueirão', 4.1, 3.5, 2, 4, 3, 3.5, 3.35, 1);

INSERT INTO TB_AVALIACAO (LIMPEZA_AVALIACAO, ESTRUTURA_AVALIACAO, SINALIZACAO_AVALIACAO, MONITORAMENTO_AVALIACAO, POLUICAO_AVALIACAO, CONSERVACAO_AMBIENTAL_AVALIACAO, ID_USER, ID_PRAIA)
VALUES (4.1, 3.5, 2, 4, 3, 3.5, 1, 1);




