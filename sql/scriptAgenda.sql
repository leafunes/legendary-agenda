
CREATE DATABASE tpi_g7;
USE tpi_g7;

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

CREATE TABLE personas
(
	idPersona int(11) NOT NULL AUTO_INCREMENT,
	nombrePersona varchar(45) NOT NULL,
	telefonoPersona varchar(20) NOT NULL,
	callePersona varchar(20) NOT NULL,
	alturaPersona int(11) NOT NULL,
	pisoPersona int(11),
	departamentoPersona int(11),
	idLocalidad int(11) NOT NULL,
	emailPersona varchar(45) NOT NULL,
	cumplePersona long NOT NULL,
	idTipoContacto int(11) NOT NULL,
	PRIMARY KEY (idPersona),
	FOREIGN KEY (idLocalidad) REFERENCES localidades(idLocalidad),
	FOREIGN KEY (idTipoContacto) REFERENCES tipoContactos(idTipoContacto)
);

