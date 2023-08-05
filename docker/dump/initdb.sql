CREATE TABLE IF NOT EXISTS Pagina (
  id integer(11) PRIMARY KEY AUTO_INCREMENT,
  url varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Tag (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  pagina_id int(11) NOT NULL,
  nome varchar(50) NOT NULL,
  quantidade varchar(50) NOT NULL,
  FOREIGN KEY (pagina_id) REFERENCES Pagina(id)
);

