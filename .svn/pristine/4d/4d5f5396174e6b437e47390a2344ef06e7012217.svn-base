-- DROP SCHEMA banco;

CREATE SCHEMA banco AUTHORIZATION azure_pg_admin;

-- DROP SEQUENCE banco.cliente_id_cliente_seq;

CREATE SEQUENCE banco.cliente_id_cliente_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE banco.cliente_id_cliente_seq OWNER TO azure_pg_admin;
GRANT ALL ON SEQUENCE banco.cliente_id_cliente_seq TO azure_pg_admin;

-- DROP SEQUENCE banco.historial_prestamo_id_prestamo_seq;

CREATE SEQUENCE banco.historial_prestamo_id_prestamo_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE banco.historial_prestamo_id_prestamo_seq OWNER TO azure_pg_admin;
GRANT ALL ON SEQUENCE banco.historial_prestamo_id_prestamo_seq TO azure_pg_admin;

-- DROP SEQUENCE banco.pagos_codigo_pago_seq;

CREATE SEQUENCE banco.pagos_codigo_pago_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE banco.pagos_codigo_pago_seq OWNER TO azure_pg_admin;
GRANT ALL ON SEQUENCE banco.pagos_codigo_pago_seq TO azure_pg_admin;

-- DROP SEQUENCE banco.prestamo_id_prestamo_seq;

CREATE SEQUENCE banco.prestamo_id_prestamo_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE banco.prestamo_id_prestamo_seq OWNER TO azure_pg_admin;
GRANT ALL ON SEQUENCE banco.prestamo_id_prestamo_seq TO azure_pg_admin;

-- DROP SEQUENCE banco.solicitud_no_solicitud_seq;

CREATE SEQUENCE banco.solicitud_no_solicitud_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE banco.solicitud_no_solicitud_seq OWNER TO azure_pg_admin;
GRANT ALL ON SEQUENCE banco.solicitud_no_solicitud_seq TO azure_pg_admin;
-- banco.catalogos definition

-- Drop table

-- DROP TABLE banco.catalogos;

CREATE TABLE banco.catalogos (
	codigo_catalogo int4 NOT NULL,
	nombre varchar(250) NOT NULL,
	descripcion varchar(250) NOT NULL,
	fecha_creacion timestamp NOT NULL,
	usuario_creacion varchar(50) NOT NULL,
	ip_usuario_creacion varchar(20) NOT NULL,
	fecha_modificacion timestamp NULL,
	usuario_modificacion varchar(50) NULL,
	ip_usuario_modificacion varchar(20) NULL,
	CONSTRAINT banco_catalogos_pk PRIMARY KEY (codigo_catalogo)
);

-- Permissions

ALTER TABLE banco.catalogos OWNER TO azure_pg_admin;
GRANT ALL ON TABLE banco.catalogos TO azure_pg_admin;


-- banco.cliente definition

-- Drop table

-- DROP TABLE banco.cliente;

CREATE TABLE banco.cliente (
	id_cliente serial4 NOT NULL,
	nombre varchar(100) NOT NULL,
	apellido varchar(100) NOT NULL,
	numero_identificacion varchar(30) NOT NULL,
	fecha_nacimiento timestamp NOT NULL,
	correo_electronico varchar(100) NULL,
	telefono varchar(20) NULL,
	usuario_adiciono varchar(20) NULL,
	fecha_adiciono timestamp NULL,
	usuario_modifico varchar(20) NULL,
	fecha_modifico timestamp NULL,
	estado int4 NOT NULL,
	CONSTRAINT banco_cliente_pk PRIMARY KEY (id_cliente),
	CONSTRAINT cliente_numero_identificacion_key UNIQUE (numero_identificacion)
);

-- Permissions

ALTER TABLE banco.cliente OWNER TO azure_pg_admin;
GRANT ALL ON TABLE banco.cliente TO azure_pg_admin;


-- banco.historial_prestamo definition

-- Drop table

-- DROP TABLE banco.historial_prestamo;

CREATE TABLE banco.historial_prestamo (
	id_prestamo serial4 NOT NULL,
	monto_aprobado numeric(10, 2) NOT NULL,
	fecha_aprobacion date NOT NULL,
	cantidad_meses_plazo int4 NOT NULL,
	saldo_pendiente numeric(10, 2) NOT NULL,
	id_cliente int4 NOT NULL,
	usuario_adiciono varchar(20) NULL,
	fecha_adiciono timestamp NULL,
	usuario_modifico varchar(20) NULL,
	fecha_modifico timestamp NULL,
	no_solicitud int4 NOT NULL,
	estado int4 NOT NULL,
	fecha_transaccion timestamp NULL,
	CONSTRAINT historial_prestamo_pkey PRIMARY KEY (id_prestamo)
);

-- Permissions

ALTER TABLE banco.historial_prestamo OWNER TO azure_pg_admin;
GRANT ALL ON TABLE banco.historial_prestamo TO azure_pg_admin;


-- banco.datos_catalogos definition

-- Drop table

-- DROP TABLE banco.datos_catalogos;

CREATE TABLE banco.datos_catalogos (
	codigo_dato_catalogo int4 NOT NULL,
	codigo_catalogo int4 NOT NULL,
	nombre varchar(250) NOT NULL,
	descripcion varchar(250) NOT NULL,
	fecha_creacion timestamp NOT NULL,
	usuario_creacion varchar(50) NOT NULL,
	ip_usuario_creacion varchar(20) NOT NULL,
	fecha_modificacion timestamp NULL,
	usuario_modificacion varchar(50) NULL,
	ip_usuario_modificacion varchar(20) NULL,
	CONSTRAINT datos_catalogos_pkey PRIMARY KEY (codigo_dato_catalogo),
	CONSTRAINT banco_codigo_catalogo_pk FOREIGN KEY (codigo_catalogo) REFERENCES banco.catalogos(codigo_catalogo)
);

-- Permissions

ALTER TABLE banco.datos_catalogos OWNER TO azure_pg_admin;
GRANT ALL ON TABLE banco.datos_catalogos TO azure_pg_admin;


-- banco.solicitud definition

-- Drop table

-- DROP TABLE banco.solicitud;

CREATE TABLE banco.solicitud (
	no_solicitud serial4 NOT NULL,
	monto_prestamo numeric(10, 2) NOT NULL,
	cantidad_meses int4 NOT NULL,
	tasa_interes varchar(25) NULL,
	usuario_adiciono varchar(20) NULL,
	fecha_adiciono timestamp NULL,
	usuario_modifico varchar(20) NULL,
	fecha_modifico timestamp NULL,
	estado int4 NOT NULL,
	id_cliente int4 NOT NULL,
	CONSTRAINT solicitud_pkey PRIMARY KEY (no_solicitud),
	CONSTRAINT solicitud_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES banco.cliente(id_cliente)
);

-- Permissions

ALTER TABLE banco.solicitud OWNER TO azure_pg_admin;
GRANT ALL ON TABLE banco.solicitud TO azure_pg_admin;


-- banco.prestamo definition

-- Drop table

-- DROP TABLE banco.prestamo;

CREATE TABLE banco.prestamo (
	id_prestamo serial4 NOT NULL,
	monto_aprobado numeric(10, 2) NOT NULL,
	fecha_aprobacion date NOT NULL,
	cantidad_meses_plazo int4 NOT NULL,
	saldo_pendiente numeric(10, 2) NOT NULL,
	id_cliente int4 NOT NULL,
	usuario_adiciono varchar(20) NULL,
	fecha_adiciono timestamp NULL,
	usuario_modifico varchar(20) NULL,
	fecha_modifico timestamp NULL,
	no_solicitud int4 NOT NULL,
	estado int4 NOT NULL,
	CONSTRAINT prestamo_pkey PRIMARY KEY (id_prestamo),
	CONSTRAINT prestamo_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES banco.cliente(id_cliente),
	CONSTRAINT prestamo_no_solicitud_fkey FOREIGN KEY (no_solicitud) REFERENCES banco.solicitud(no_solicitud)
);

-- Table Triggers

create trigger tr_historial_prestamo before
insert
    or
update
    on
    banco.prestamo for each row execute function banco.f_banco_historial_prestamo();

-- Permissions

ALTER TABLE banco.prestamo OWNER TO azure_pg_admin;
GRANT ALL ON TABLE banco.prestamo TO azure_pg_admin;


-- banco.pagos definition

-- Drop table

-- DROP TABLE banco.pagos;

CREATE TABLE banco.pagos (
	codigo_pago serial4 NOT NULL,
	fecha_pago timestamp NOT NULL,
	monto_pago numeric(10, 2) NOT NULL,
	id_prestamo int4 NOT NULL,
	usuario_adiciono varchar(20) NULL,
	fecha_adiciono timestamp NULL,
	usuario_modifico varchar(20) NULL,
	fecha_modifico timestamp NULL,
	CONSTRAINT pagos_pkey PRIMARY KEY (codigo_pago),
	CONSTRAINT pagos_id_prestamo_fkey FOREIGN KEY (id_prestamo) REFERENCES banco.prestamo(id_prestamo)
);

-- Table Triggers

create trigger tr_actualizar_saldo_pendiente after
insert
    on
    banco.pagos for each row execute function banco.actualizar_saldo_pendiente();

-- Permissions

ALTER TABLE banco.pagos OWNER TO azure_pg_admin;
GRANT ALL ON TABLE banco.pagos TO azure_pg_admin;



CREATE OR REPLACE FUNCTION banco.actualizar_saldo_pendiente()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
DECLARE
    saldo_actual numeric(10, 2);
BEGIN
    
    SELECT saldo_pendiente INTO saldo_actual
    FROM banco.prestamo
    WHERE id_prestamo = NEW.id_prestamo
    FOR UPDATE;

    
    IF saldo_actual <= 0 THEN
        RAISE EXCEPTION 'El préstamo ya fue cancelado';
    END IF;

    
    IF NEW.monto_pago > saldo_actual THEN
        RAISE EXCEPTION 'El monto del pago es mayor que el saldo pendiente';
    END IF;

    
    UPDATE banco.prestamo
    SET saldo_pendiente = saldo_pendiente - NEW.monto_pago,
        usuario_modifico = 'SISTEMA_BANCARIO',
        fecha_modifico = now(),
        estado = CASE
                    WHEN saldo_pendiente - NEW.monto_pago <= 0 THEN 7
                    ELSE 8 
                 END
    WHERE id_prestamo = NEW.id_prestamo;

    RETURN NEW;
END;
$function$
;

-- Permissions

ALTER FUNCTION banco.actualizar_saldo_pendiente() OWNER TO azure_pg_admin;
GRANT ALL ON FUNCTION banco.actualizar_saldo_pendiente() TO azure_pg_admin;

CREATE OR REPLACE FUNCTION banco.f_banco_historial_prestamo()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
   BEGIN
		IF (TG_OP = 'UPDATE') then
		INSERT INTO banco.historial_prestamo
		(monto_aprobado, fecha_aprobacion, cantidad_meses_plazo, saldo_pendiente, id_cliente, usuario_adiciono, fecha_adiciono, usuario_modifico, fecha_modifico, no_solicitud, estado, fecha_transaccion)
		VALUES(old.monto_aprobado, old.fecha_aprobacion, old.cantidad_meses_plazo, old.saldo_pendiente, old.id_cliente, old.usuario_adiciono, old.fecha_adiciono, old.usuario_modifico, old.fecha_modifico, old.no_solicitud, old.estado, now());
		RETURN NEW;
		--ELSIF (TG_OP = 'INSERT') THEN
			--RETURN NEW;
		END IF;
        RETURN NEW;
    END;
$function$
;

-- Permissions

ALTER FUNCTION banco.f_banco_historial_prestamo() OWNER TO azure_pg_admin;
GRANT ALL ON FUNCTION banco.f_banco_historial_prestamo() TO azure_pg_admin;


-- Permissions

GRANT ALL ON SCHEMA banco TO azure_pg_admin;

ALTER TABLE banco.cliente ADD direccion varchar(150) NULL;