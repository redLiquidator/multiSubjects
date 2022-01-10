package com.jan.ry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class IndexController {
	@GetMapping("/")   //accessible to everyone
public String index(Model model) {
		System.out.println("+++++++welcome to index page+++++++++");
		System.out.println("EnumConstant value is : "+EnumConstants.ERR1);
		return "index";
	}

	@GetMapping("/user") //accesssible to user
	public String user() {
		return ("<h1>welcome user<h2>");
	}

	@GetMapping("/admin") //accesssible to admin
	public String admin() {
		return ("<h1>welcome admin<h2>");
	}

	private static Map<String,Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);

	}

	@RequestMapping(value="/products")
	public ResponseEntity<Object> getProduct(){
		return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);

	}

	@GetMapping("/customError")
	public String customError() throws ErrorPageException {
		throw new ErrorPageException("custom error1: ", "ERERER");
	}


}
