package com.rootfit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RootFitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RootFitApplication.class, args);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("<<<<< Projeto RootFit Running... >>>>> \nàs: " + sdf.format(calendar.getTime()));
	}
}
