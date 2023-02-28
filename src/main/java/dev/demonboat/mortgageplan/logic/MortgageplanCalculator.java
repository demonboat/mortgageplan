package dev.demonboat.mortgageplan.logic;

import dev.demonboat.mortgageplan.model.Prospect;
import dev.demonboat.mortgageplan.util.MathUtil;

public final class MortgageplanCalculator {

  private MortgageplanCalculator() {
  }


  public static Double calculate(final Prospect prospect) {
    double numberOfPayments = prospect.years() * 12;

    //U[b(1 + b)^p]
    Double numerator = prospect.totalLoan() * prospect.interest() * MathUtil.pow(1 + prospect.interest(), numberOfPayments);

    //[(1 + b)^p - 1]
    Double denominator = MathUtil.pow(1 + prospect.interest(), numberOfPayments) - 1;

    // E = [numerator / denominator]
    return numerator / denominator;
  }
}
