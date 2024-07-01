package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication(scanBasePackages = "org.example")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}