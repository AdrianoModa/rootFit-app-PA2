package com.rootfit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rootfit.model.Aluno;
import com.rootfit.repositories.AlunoRepository;
import com.rootfit.repositories.InstrutorRepository;

@SpringBootApplication
public class RootFitApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(RootFitApplication.class, args);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("<<<<< Projeto RootFit Running... >>>>> \nàs: " + sdf.format(calendar.getTime()));
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		
	}
}
