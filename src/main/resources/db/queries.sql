CREATE DATABASE IF NOT EXISTS digital_innovation_one;
USE digital_innovation_one;

CREATE TABLE estado (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    sigla CHAR(2) NOT NULL UNIQUE
);

CREATE TABLE aluno (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(89) NOT NULL,
    idade INTEGER NOT NULL,
    id_estado INTEGER,
    FOREIGN KEY (id_estado) REFERENCES estado(id)
);

INSERT INTO estado (sigla) VALUE ('AM');
INSERT INTO estado (sigla) VALUE ('AL');
INSERT INTO estado (sigla) VALUE ('AP');
INSERT INTO estado (sigla) VALUE ('BA');
INSERT INTO estado (sigla) VALUE ('CE');

INSERT INTO aluno (nome, idade, id_estado) VALUES ('Moacir', 65, 1);
INSERT INTO aluno (nome, idade, id_estado) VALUES ('Ester', 10, 4);
INSERT INTO aluno (nome, idade, id_estado) VALUES ('Jasmine', 34, 4);
INSERT INTO aluno (nome, idade, id_estado) VALUES ('Lammén', 54, 3);


SELECT * FROM aluno;
SELECT * FROM estado;