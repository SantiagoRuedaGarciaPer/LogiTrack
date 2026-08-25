CREATE DATABASE LogiTrack;
USE LogiTrack;


CREATE TABLE Empleados(
	id int primary key auto_increment,
	nombre varchar(50) not null,
	email varchar(50) not null unique,
	tipo_documento Enum('Cedula', 'Pasaporte'),
	documento varchar(20) not null unique,
	cargo varchar(50) not null
);

CREATE TABLE Usuarios(
	id int primary key auto_increment,
	empleado_id int not null unique,
	foreign key (empleado_id) references Empleados(id),
	usuario varchar(20) not null,
	contrasenia varchar(50) not null
);

CREATE TABLE Bodegas(
	id int primary key auto_increment,
	nombre varchar(50) not null unique,
	ubicacion varchar(50) not null,
	capacidad double not null,
	id_encargado int not null,
	foreign key (id_encargado) references Empleados(id)
);

CREATE TABLE Productos(
	id int primary key auto_increment,
	nombre varchar(50) not null,
	descripcion varchar(255) not null,
	stock int not null,
	precio_compra double not null,
	precio_venta double not null,
	bodega_id int not null,
	foreign key (bodega_id) references Bodegas(id)
);
