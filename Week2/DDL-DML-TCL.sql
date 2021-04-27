-- This is a single line comment
/*
 * This is a multiline comment.  
 */

--DDL
--CREATE DATABASE demos; 

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(50), 
	real_name VARCHAR(30),
	power_level INTEGER
);

ALTER TABLE avengers ADD COLUMN active BOOLEAN;

TRUNCATE TABLE avengers;

--DML
INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve Rogers', 25), 
	('Spiderman', 'Sticky Fingers', 'Peter Parker', 37);

UPDATE avengers SET active = FALSE;
UPDATE avengers SET active = TRUE WHERE superhero_name = 'Spiderman'; 

DELETE FROM avengers WHERE real_name = 'Steve Rogers';

INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level)
	VALUES ('Iron Man', 'Being a good guy that can pull of a goatee', 'Tony Stark', 85);

--DQL

SELECT real_name, power_level FROM avengers;

SELECT * FROM avengers;

SELECT * FROM avengers WHERE power_level > 50;

--Transaction

BEGIN; --starts a transaction in postgres, inherently sets a savepoint to roll back to. 

INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve Rogers', 25), 
	('Thor', 'Staring role in hair product commercials', 'Thor Odinson', 237);
SAVEPOINT my_save;
UPDATE avengers SET active = false WHERE superhero_name = 'Capt. America';
UPDATE avengers SET active = TRE WHERE superhero_name = 'Thor';

COMMIT; 

--ROLLBACK TO SAVEPOINT my_save;

