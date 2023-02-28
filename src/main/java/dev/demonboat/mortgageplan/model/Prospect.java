package dev.demonboat.mortgageplan.model;

import dev.demonboat.mortgageplan.validation.NumberValidator;
import dev.demonboat.mortgageplan.validation.StringValidator;

import java.math.BigDecimal;

public record Prospect(String customerName, BigDecimal totalLoan, BigDecimal interest, Integer years) {

  public static final StringValidator customerValidator
    = new StringValidator("customerName", 1, 50, false);
  public static final NumberValidator<BigDecimal> totalLoanValidator
    = new NumberValidator<>("total loan", BigDecimal.ZERO, BigDecimal.valueOf(30000), false);
  public static final NumberValidator<BigDecimal> interestValidator
  = new NumberValidator<>("total loan", BigDecimal.ZERO, BigDecimal.valueOf(30000), false);
  public static final NumberValidator<Integer> yearsValidtor
  = new NumberValidator<>("total loan", 0, 100, false);

  public Prospect {
    customerValidator.validate(customerName);
    totalLoanValidator.validate(totalLoan);
    interestValidator.validate(interest);
    yearsValidtor.validate(years);
  }

}
