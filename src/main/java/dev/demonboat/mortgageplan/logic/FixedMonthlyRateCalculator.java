package dev.demonboat.mortgageplan.logic;

import dev.demonboat.mortgageplan.util.MathUtil;

public final class FixedMonthlyRateCalculator {

  private FixedMonthlyRateCalculator() {
  }

  public static Double calculate(final double totalLoan, final double interest, final int years) {
    double numberOfPayments = years * 12;
    double monthlyInterest = interest / 100 / 12; // Monthly Percentage
    //U[b(1 + b)^p]
    Double numerator = totalLoan
       * (monthlyInterest * MathUtil.pow(1 + monthlyInterest, numberOfPayments));
    //[(1 + b)^p - 1]
    Double denominator = MathUtil.pow(1 + monthlyInterest, numberOfPayments) - 1;
    // E = [numerator / denominator]
    return numerator / denominator;
  }
}
