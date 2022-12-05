DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
  id SERIAL PRIMARY KEY NOT NULL,
  nama VARCHAR(30) NOT NULL,
  ktp CHAR(16) UNIQUE NOT NULL,
  jenis_usaha int NOT NULL FOREIGN KEY REFERENCES Jenis_Usaha(id),
  cust_status VARCHAR(1),
  hp VARCHAR(20) UNIQUE,
  jenis_kelamin CHAR(1) NOT NULL,
  max_limit_pinjaman DOUBLE(17,2) NOT NULL,
  created_date TIMESTAMP NOT NULL,
  creator_id INT4 NOT NULL,
  updated_date TIMESTAMP,
  updater_id INT4,
  deleted_date TIMESTAMP,
  deleter_id INT4,
);

SELECT * FROM customer;

DROP TABLE IF EXISTS customer;

CREATE TABLE Jenis_Usaha(
  id SERIAL PRIMARY KEY NOT NULL,
  nama VARCHAR(50) NOT NULL,
  created_date TIMESTAMP NOT NULL,
  creator_id INT4 NOT NULL,
  updated_date TIMESTAMP,
  updater_id INT4,
  deleted_date TIMESTAMP,
  deleter_id INT4,
);

SELECT * FROM customer;