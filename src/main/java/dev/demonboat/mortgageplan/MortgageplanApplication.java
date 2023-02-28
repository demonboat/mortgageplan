package dev.demonboat.mortgageplan;

import dev.demonboat.mortgageplan.model.Prospect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class MortgageplanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MortgageplanApplication.class, args);

        Prospect person = new Prospect("Juha", BigDecimal.valueOf(1000), BigDecimal.valueOf(5), 2);
    }

}
