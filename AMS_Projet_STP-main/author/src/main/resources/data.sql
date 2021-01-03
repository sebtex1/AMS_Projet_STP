DROP TABLE IF EXISTS authors;
 
CREATE TABLE authors (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
 
INSERT INTO authors (name, password, email) VALUES
  ('Thomas','password','thomas@gmail.com'),
  ('Pierre','password2','Pierre@test.fr'),
  ('Sebastien','password3','seb@test.fr');