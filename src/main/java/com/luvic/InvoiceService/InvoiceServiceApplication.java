package com.luvic.InvoiceService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class InvoiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceServiceApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault( TimeZone.getTimeZone( "CST" ) );

		System.out.println( "Date in CST: " + new Date().toString() );
	}

}
