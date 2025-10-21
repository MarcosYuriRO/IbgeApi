package com.marcos.IbgeApi;

import com.marcos.IbgeApi.main.MainMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IbgeApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IbgeApiApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        MainMenu main = new MainMenu();
        main.displayHomeMenu();
    }
}
