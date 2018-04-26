package com.rootfit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rootfit.model.Instrutor;
import com.rootfit.model.Usuario;
import com.rootfit.repositories.InstrutorRepository;

@SpringBootApplication
public class RootFitApplication implements CommandLineRunner {
	
	@Autowired
	InstrutorRepository instrutorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RootFitApplication.class, args);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("<<<<< Projeto RootFit Running... >>>>> \nàs: " + sdf.format(calendar.getTime()));
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Instrutor i1 = new Instrutor(null, "123.456.789-00", "i1@gmail.com", "homemcis", "i1", 
											"132465", "nome", "senha", "rg", "telefone", null);
		instrutorRepository.save(i1);
		
		
		
	}
}
