CREATE TABLE public.student
(
  code integer NOT NULL,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  gender character varying(1) NOT NULL,
  email character varying(150) NOT NULL,
  contact_phone character varying(50) NOT NULL,
  guardian character varying(50) NOT NULL,
  birthday timestamp NOT NULL,
  CONSTRAINT pk_student PRIMARY KEY (code)
);

