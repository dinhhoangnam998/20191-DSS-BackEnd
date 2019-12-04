package com.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

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

}
