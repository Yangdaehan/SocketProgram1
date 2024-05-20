package org.mse.socketservercn;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("Enter an arithmetic expression: ");
        String expression = scanner.nextLine();

        String result = restTemplate.postForObject("http://localhost:8080/calculate", expression, String.class);

        System.out.println("Result: " + result);
    }
}
