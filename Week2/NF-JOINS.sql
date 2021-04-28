
--0NF
DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(50) UNIQUE, 
	real_name VARCHAR(30) NOT NULL,
	power_level INTEGER,
	home_base VARCHAR(30),
	hb_address VARCHAR(60)
);

INSERT INTO avengers (superhero_name, superhero_power, real_name, home_base, hb_address, power_level)
	VALUES ('Capt. America', '1944 World Ultimate Frisbee Champion', 'Steve Rogers', 'Stark Tower',
			'123 Stark Ave New York NY 10709', 22),
		('Iron Man', 'Big brains and money', 'Tony Stark', 'Stark Tower', 
			'123 Stark Ave New York NY 10709', 55);

--1NF

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(50) UNIQUE, 
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	power_level INTEGER,
	home_base VARCHAR(30),
	hb_st_num VARCHAR(10),
	hb_st_name VARCHAR(30),
	hb_city VARCHAR(30),
	hb_region VARCHAR(30),
	hb_country VARCHAR(30),
	hb_zip VARCHAR(10)
);

ALTER TABLE avengers ADD PRIMARY KEY (superhero_name, superhero_power);

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, 
home_base, hb_st_num, hb_st_name, hb_city, hb_region, hb_country, hb_zip)
	VALUES ('Capt America', 'Super strong frisbee', 'Steve', 'Rogers', 22, 'Stark Tower', '132', 
		'Stark ave', 'New York', 'NY', 'USA', '10709'),
		('Capt America', 'Stunning good looks', 'Sam', 'Wilson', 18, NULL, NULL, NULL, NULL, NULL, 
		NULL, NULL);
		
--INSERT INTO avengers
--	VALUES ('Capt America', 'Super strong frisbee', 'Bucky', 'Barnes', 22, 'Stark Tower', '132', 
--		'Stark ave', 'New York', 'NY', 'USA', '10709');

--2NF
DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY,
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(50) UNIQUE, 
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	power_level INTEGER,
	home_base VARCHAR(30),
	hb_st_num VARCHAR(10),
	hb_st_name VARCHAR(30),
	hb_city VARCHAR(30),
	hb_region VARCHAR(30),
	hb_country VARCHAR(30),
	hb_zip VARCHAR(10)
);



INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, 
home_base, hb_st_num, hb_st_name, hb_city, hb_region, hb_country, hb_zip)
	VALUES ('Capt America', 'Super strong frisbee', 'Steve', 'Rogers', 22, 'Stark Tower', '132', 
		'Stark ave', 'New York', 'NY', 'USA', '10709'),
		('Capt America', 'Stunning good looks', 'Sam', 'Wilson', 18, NULL, NULL, NULL, NULL, NULL, 
		NULL, NULL);

--UPDATE avengers SET home_base = 'Nowhere' WHERE superhero_id = 2;

--3NF

DROP TABLE IF EXISTS avengers;

CREATE TABLE homes (
	home_name VARCHAR (30) PRIMARY KEY,
	hb_st_num VARCHAR(10),
	hb_st_name VARCHAR(30),
	hb_city VARCHAR(30),
	hb_region VARCHAR(30),
	hb_country VARCHAR(30),
	hb_zip VARCHAR(10)
);
	
CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY,
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(50) UNIQUE, 
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	power_level INTEGER,
	home_base VARCHAR(30) REFERENCES homes(home_name)
);

INSERT INTO homes (home_name, hb_st_num, hb_st_name, hb_city, hb_region, hb_zip, hb_country)
	VALUES('Stark Tower', '123', 'Stark ave', 'New York', 'NY', '10709', 'USA'),
	('Helicarrier', NULL, 'bottom of potemac', 'Washington', 'DC', '20111', 'USA');

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base)
	VALUES ('Capt America', 'Super strong frisbee', 'Steve', 'Rogers', 22, 'Stark Tower'),
		('Capt America', 'Stunning good looks', 'Sam', 'Wilson', 18, NULL),
		('Hawkeye', 'Amusing quips', 'Clint', 'Barton', 5600, 'Helicarrier'),
		('Iron Man', 'Starting tabloid stories', 'Tony', 'Stark', 145, 'Stark Tower');

SELECT * FROM avengers;

INSERT INTO homes (home_name, hb_st_num, hb_st_name, hb_city, hb_region, hb_zip, hb_country)
	VALUES('Sanctum Sanctorium', '111', 'Magic Street', 'New York', 'NY', '10709', 'USA')

--JOINS

SELECT * FROM avengers AS a JOIN homes AS h ON  a.home_base=h.home_name;

SELECT * FROM avengers RIGHT JOIN homes ON home_name = home_base;

SELECT * FROM avengers LEFT JOIN homes ON home_name = home_base;

SELECT * FROM avengers FULL JOIN homes ON home_name = home_base;


		