package net.cnki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("net.cnki.*.dao")
public class SecurityBootAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityBootAPIApplication.class, args);
	}

}
