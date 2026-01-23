package fr.usager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "fr.usager")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
