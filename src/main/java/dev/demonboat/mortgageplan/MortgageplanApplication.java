package dev.demonboat.mortgageplan;

import dev.demonboat.mortgageplan.logic.MortgageplanCalculator;
import dev.demonboat.mortgageplan.model.Prospect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MortgageplanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MortgageplanApplication.class, args);

        Prospect person = new Prospect("Juha", 1000.0, 0.005/12, 2);
        System.out.println("Prospect 1:" + person.customerOutput(MortgageplanCalculator.calculate(person)));
    }

}
