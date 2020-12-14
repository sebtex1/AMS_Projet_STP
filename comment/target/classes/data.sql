DROP TABLE IF EXISTS comment;
 
CREATE TABLE comment (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  idauthor INT NOT NULL,
  date DATE NOT NULL,
  text VARCHAR(250) NOT NULL
);
 
INSERT INTO comment (idauthor, date, text) VALUES
  ('1', '1300-11-17', 'Oeuvre Originale'),
  ('2', '1800-02-25', 'Cest Miserable'),
  ('3', '2001-06-16', 'RIP La Fourmie');