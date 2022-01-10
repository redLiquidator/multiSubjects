package com.jan.ry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JanApplication {

	public static void main(String[] args) {
		SpringApplication.run(JanApplication.class, args);
	}

	  @RequestMapping(value = "/janApplication")
	   public String hello() {
	      return "janApplication";
	   }

}
