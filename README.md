# spring-boot-mybatis-case

---

## 01. Setting


| 항목 | 설정 |
| --- | --- |
| Project | Maven Project |
| Language | Java |
| Spring Boot | 2.5.8 |
| Packaging | Jar |
| Java | 8 |
| Dependencies | Web, DevTools, Lombok |


---

## 02. Mybatis Setting


### MyBatis, MySQL 의존성 추가


[https://mvnrepository.com/](https://mvnrepository.com/)
에서 spring boot mybatis, spring boot mysql로 검색하여 추가

**pom.xml**

```xml

<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.4</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

**src/main/resources/application.properties**

- MySQL 설정

```
# Mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3307/case_db?serverTimezone=UTC&useSSL=false
spring.datasource.username=case
spring.datasource.password=case1004

```

- MyBatis 설정

```
# MyBatis
# mapper.xml location
mybatis.mapper-locations: mapper/**/*.xml

# model property camel case
mybatis.configuration.map-underscore-to-camel-case=true

# 패키지명 생략 alias
mybatis.type-aliases-package=io.rooftophero.mybatiscase.domain

# mapper log level
logging.level.rooftophero.io.mybatisexample.mapper=TRACE

```



### MySQL Schema 및 User 생성

- table생성 및 데이터 insert 여부

```xml
# schema.sql, data.sql 적용 {always/never}
spring.datasource.initialization-mode=never
```

always는 테이블생성과 insert를 시작할 때마다 생성한다. never는 생성하지 않을 때 지정한다.


```sql

create user 'case'@'localhost' identified by 'case1004';

FLUSH PRIVILEGES;

CREATE DATABASE case_db;

GRANT ALL PRIVILEGES ON case_db.* TO 'case'@'localhost';

GRANT RELOAD ON *.* TO 'case'@'localhost';

GRANT FILE ON *.* TO 'case'@'localhost';

FLUSH PRIVILEGES;

# function 생성권한 부여
grant select on mysql.proc to 'case'@'localhost';

# fucntion 생성 가능
set global log_bin_trust_function_creators='ON';
```

**resources/schema.sql**

```sql 
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
```

**resources/data.sql**

```sql
INSERT BOARD (TITLE, CONTENT, BOARD_TYPE, USER_ID) VALUES ('해피 크리스마스','모두 행복한 크리스마스 되세요','자유게시판','zozo');
INSERT BOARD (TITLE, CONTENT, BOARD_TYPE, USER_ID) VALUES ('zozo님도 해피','zozo님도 해피 크리스마스와 뜻깊은 새해 맞으시길','자유게시판', 'yoyo');
```

