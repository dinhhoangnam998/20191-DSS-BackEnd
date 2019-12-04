package com.group;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.group.gui.MainFrame;

@SpringBootApplication
public class DssBackEndApplication {

	@Autowired
	private MainFrame mf;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DssBackEndApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			mf.injectData();
			mf.displayFrame();
		};
	}

}
