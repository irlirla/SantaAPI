package ro.rom.factoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FactoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryServiceApplication.class, args);
    }

}
