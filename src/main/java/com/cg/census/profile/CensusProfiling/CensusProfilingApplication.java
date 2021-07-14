package com.cg.census.profile.CensusProfiling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CensusProfilingApplication {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(CensusProfilingApplication.class, args);
		System.out.println("end");
	}

}
