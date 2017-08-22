CREATE DATABASE agenda;
USE agenda;
CREATE TABLE personas
(
	idPersona int(11) NOT NULL AUTO_INCREMENT,
	nombrePersona varchar(45) NOT NULL,
	telefonoPersona varchar(20) NOT NULL,
	PRIMARY KEY (idPersona)
);

CREATE TABLE localidades
(
	idLocalidad int(11) NOT NULL AUTO_INCREMENT,
	nombreLocalidad varchar(45) NOT NULL,
	PRIMARY KEY (idLocalidad)

);

CREATE TABLE tipoContactos
(
   idTipoContacto int(11) NOT NULL AUTO_INCREMENT,
   	nombreTipo varchar(45) NOT NULL,
   	PRIMARY KEY (idTipoContacto)


);