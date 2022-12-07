package io.rooftophero.mybatiscase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "io.rooftophero.mybatiscase.mapper")
public class MybatiscaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatiscaseApplication.class, args);
	}

}
