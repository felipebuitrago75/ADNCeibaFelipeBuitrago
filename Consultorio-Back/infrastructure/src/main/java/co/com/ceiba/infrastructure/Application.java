package co.com.ceiba.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages={
		"co.com.ceiba.application", "co.com.ceiba.domain",
		"co.com.ceiba.infrastructure"})

public class Application {
	public static void main(String[] args) {
		if(args.length>0) {
		    SpringApplication.run(Application.class, args);
		}
	}
}
