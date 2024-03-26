--
-- PostgreSQL database dump
--

-- Dumped from database version 14.11 (Homebrew)
-- Dumped by pg_dump version 16.0

-- Started on 2024-03-25 23:33:51 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: jaimelopez
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO jaimelopez;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 16404)
-- Name: users; Type: TABLE; Schema: public; Owner: jaimelopez
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    email character varying(200) NOT NULL,
    password character varying(100) NOT NULL,
    roles character varying(50) NOT NULL
);


ALTER TABLE public.users OWNER TO jaimelopez;

--
-- TOC entry 211 (class 1259 OID 16403)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: jaimelopez
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO jaimelopez;

--
-- TOC entry 3658 (class 0 OID 0)
-- Dependencies: 211
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jaimelopez
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 210 (class 1259 OID 16386)
-- Name: workers; Type: TABLE; Schema: public; Owner: jaimelopez
--

CREATE TABLE public.workers (
    id bigint NOT NULL,
    nombre character varying(50) NOT NULL,
    rut character varying(20) NOT NULL,
    activo boolean,
    fecha_ingreso timestamp(6) without time zone
);


ALTER TABLE public.workers OWNER TO jaimelopez;

--
-- TOC entry 209 (class 1259 OID 16385)
-- Name: workers_id_seq; Type: SEQUENCE; Schema: public; Owner: jaimelopez
--

CREATE SEQUENCE public.workers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.workers_id_seq OWNER TO jaimelopez;

--
-- TOC entry 3659 (class 0 OID 0)
-- Dependencies: 209
-- Name: workers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jaimelopez
--

ALTER SEQUENCE public.workers_id_seq OWNED BY public.workers.id;


--
-- TOC entry 3504 (class 2604 OID 16410)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: jaimelopez
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3503 (class 2604 OID 16392)
-- Name: workers id; Type: DEFAULT; Schema: public; Owner: jaimelopez
--

ALTER TABLE ONLY public.workers ALTER COLUMN id SET DEFAULT nextval('public.workers_id_seq'::regclass);


--
-- TOC entry 3651 (class 0 OID 16404)
-- Dependencies: 212
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: jaimelopez
--

COPY public.users (id, name, email, password, roles) FROM stdin;
3	jlopez	moreno.jlopez@gmail.com	$2a$10$fm.z8t0AI4qLs3nUL11LLO8I5z6ykH93nrEie/H.wZe.dw3v.zzZy	ROLE_USER
\.


--
-- TOC entry 3649 (class 0 OID 16386)
-- Dependencies: 210
-- Data for Name: workers; Type: TABLE DATA; Schema: public; Owner: jaimelopez
--

COPY public.workers (id, nombre, rut, activo, fecha_ingreso) FROM stdin;
1	Sergey Brin	1111111-1	t	1999-01-01 00:00:00
2	Larry Page	2222222-2	f	1999-01-01 00:00:00
3	Urs Hölzle	3333333-3	t	1999-01-01 00:00:00
4	Salar Kamangar	44444444-4	t	1999-01-01 00:00:00
5	Joan Braddi	5555555-5	t	1999-01-01 00:00:00
6	Susan Wojcicki	6666666-6	t	1999-01-01 00:00:00
\.


--
-- TOC entry 3660 (class 0 OID 0)
-- Dependencies: 211
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: jaimelopez
--

SELECT pg_catalog.setval('public.users_id_seq', 4, true);


--
-- TOC entry 3661 (class 0 OID 0)
-- Dependencies: 209
-- Name: workers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: jaimelopez
--

SELECT pg_catalog.setval('public.workers_id_seq', 6, true);


--
-- TOC entry 3508 (class 2606 OID 16412)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: jaimelopez
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3506 (class 2606 OID 16394)
-- Name: workers workers_pkey; Type: CONSTRAINT; Schema: public; Owner: jaimelopez
--

ALTER TABLE ONLY public.workers
    ADD CONSTRAINT workers_pkey PRIMARY KEY (id);


--
-- TOC entry 3657 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: jaimelopez
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2024-03-25 23:33:51 -03

--
-- PostgreSQL database dump complete
--

