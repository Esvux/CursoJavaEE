CREATE TABLE public.car
(
  code integer NOT NULL,
  brand character varying(150) NOT NULL,
  model character varying(150) NOT NULL,
  color character varying(150) NOT NULL,
  year integer NOT NULL,
  CONSTRAINT pk_car PRIMARY KEY (code)
);

INSERT INTO car VALUES(1, 'Mazda', 'Mazda3', '#454545', 2008);
INSERT INTO car VALUES(2, 'Chevy', 'SparkGT', '#FF0000', 2013);
INSERT INTO car VALUES(3, 'Toyota', 'Yaris', '#000', 2008);
INSERT INTO car VALUES(4, 'Mazda', 'Protege', '#FFF', 1999);
INSERT INTO car VALUES(5, 'Porshe', 'Carrera', '#000', 2018);

SELECT * FROM car;
