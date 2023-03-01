package dev.demonboat.mortgageplan.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FixedMonthlyRateCalculatorTest {

  @Test
  public void testSuccessAndUse() {
    double totalLoan = 1000.0;
    double interest = 5;
    int years = 2;
    assertEquals(43.8713897340686, FixedMonthlyRateCalculator.calculate(totalLoan, interest, years));
  }
}
