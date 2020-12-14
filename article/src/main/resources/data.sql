DROP TABLE IF EXISTS articles;
 
CREATE TABLE articles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  idcategory INT NOT NULL,
  idauthor INT NOT NULL,
  date DATE NOT NULL,
  content TEXT NOT NULL,
  idcomments INT NOT NULL
  
);
 
INSERT INTO articles (name, idcategory, idauthor, date, content, idcomments) VALUES
  ('Maite strik again', '1', '1', '2020-01-01', 'Coocking some good meal', '1'),
  ('Out of control players are crazy', '2', '2', '2020-02-02', 'Messy fought against Ronaldo', '2'),
  ('Vande out of context', '3', '3', '2020-03-03', 'New event in vande', '3');