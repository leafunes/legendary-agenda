# legendary-agenda
Mini-TP para la materia Proyecto Profesional I de la Universidad Nacional de General Sarmiento.
Es un simple ABM de personas.

## Dependencias
Para ejecutar el proyecto se requiere [Maven](https://maven.apache.org/install.html) y [MySQL](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-14-04)

## Creando la Base de Datos
Para crear la base de datos, nos paramos en la carpeta "sql" y elecutamos en la consola:

```
mysql -u usuario -p < scriptAgenda.sql
```
Donde "usuario" es el usuario deseado. Generalmente "root"

## Usar Eclipse IDE
Para usar el Eclipse IDE se debe ejecutar en la consola:

```
mnv eclipse:eclipse
```

## Ejecutar el proyecto
Para correr el proyecto se debe ejecutar en la consola:

```
mnv install exec:java
```
