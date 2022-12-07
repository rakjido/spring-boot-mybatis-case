DROP TABLE IF EXISTS member ;

CREATE TABLE IF NOT EXISTS member (
  user_id VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(45) NOT NULL,
  created_date TIMESTAMP NULL DEFAULT now(),
  updated_date TIMESTAMP NULL DEFAULT now(),
  PRIMARY KEY (user_id))
    default character set utf8 collate utf8_general_ci;

DROP TABLE IF EXISTS board ;

CREATE TABLE IF NOT EXISTS board (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  content TEXT NULL,
  board_type VARCHAR(45) NOT NULL,
  created_date TIMESTAMP NULL DEFAULT now(),
  updated_date TIMESTAMP NULL DEFAULT now(),
  user_id VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
	default character set utf8 collate utf8_general_ci;
