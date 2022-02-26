package com.WhiskeyandWaveforms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@SpringBootApplication
public class WhiskeyandWaveformsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiskeyandWaveformsApplication.class, args);
	}
	@RequestMapping("/test")
	@ResponseBody
	String test() {
		return "Hello! This is a test!";
	}
}
