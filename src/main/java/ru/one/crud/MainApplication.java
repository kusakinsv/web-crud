package ru.one.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.one.crud.service.BrowserLauncher;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MainApplication.class, args);
		BrowserLauncher launcher = context.getBean(BrowserLauncher.class);
		launcher.start();

	}



}
