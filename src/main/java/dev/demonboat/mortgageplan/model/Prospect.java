package dev.demonboat.mortgageplan.model;

import dev.demonboat.mortgageplan.validation.NumberValidator;
import dev.demonboat.mortgageplan.validation.StringValidator;

public record Prospect(String customerName, Double totalLoan, Double interest, Integer years, Double fixedMonthlyRate) {

  public static final StringValidator customerValidator
    = new StringValidator("customerName", 1, 50, false);
  public static final NumberValidator<Double> totalLoanValidator
    = new NumberValidator<>("total loan", 0.0, 5000.0, false);
  public static final NumberValidator<Double> interestValidator
    = new NumberValidator<>("total loan", 0.0, 5000.0, false);
  public static final NumberValidator<Integer> yearsValidator
    = new NumberValidator<>("total loan", 0, 100, false);
  public static final NumberValidator<Double> calculatedFixedRateValidator
    = new NumberValidator<>("total loan", 0.0, 5000.0, false);


  public Prospect {
    customerValidator.validate(customerName);
    totalLoanValidator.validate(totalLoan);
    interestValidator.validate(interest);
    yearsValidator.validate(years);
    calculatedFixedRateValidator.validate(fixedMonthlyRate);
  }

  public String customerOutput() {
    return """
      %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month
    """
    .formatted(customerName, totalLoan, years, fixedMonthlyRate);
  }
}
