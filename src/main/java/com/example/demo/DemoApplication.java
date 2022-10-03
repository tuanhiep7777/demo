package com.example.demo;

import com.example.demo.entity.Covid;
import com.example.demo.repository.CovidRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        // Init test data
        CovidRepository repository = context.getBean(CovidRepository.class);
        repository.saveAll(
            Arrays.asList(
                new Covid(2L, "Philippines", "asia", 1, 122, 2),
                new Covid(3L, "Thailand", "europe", 12, 242, 1)
            )
        );
	}

}
