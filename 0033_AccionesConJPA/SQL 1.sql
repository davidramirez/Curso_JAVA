create table ACCIONES(
	id_accion integer primary key NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre varchar(25) NOT NULL,
	valor float not null,
        fecha_creacion timestamp,
        fecha_modificacion timestamp);

create table ACCIONISTAS(
	id_accionista integer primary key NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre varchar(25) NOT NULL UNIQUE,
	clave varchar(25) not null,
        fecha_creacion timestamp,
        fecha_modificacion timestamp
);

create table COMPRAS_ACCIONES(
	id_compra integer primary key NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	cantidad integer,
        valor float,
        fecha_compra timestamp,
        fecha_modificacion timestamp,
        id_accion integer not null references ACCIONES(id_accion),
	id_accionista integer not null references ACCIONISTAS(id_accionista)
);

create table ACCIONES_ACCIONISTA(
	id_accion integer not null references ACCIONES(id),
	id_accionista integer not null references ACCIONISTAS(id),
	cantidad integer,
	valor_compra_total float,
        primary key (id_accion, id_accionista)
);