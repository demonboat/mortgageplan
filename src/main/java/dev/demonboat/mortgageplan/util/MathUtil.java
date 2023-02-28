package dev.demonboat.mortgageplan.util;

import java.math.BigDecimal;

public final class MathUtil {

  private MathUtil() {}

  public static BigDecimal pow(final BigDecimal base, final BigDecimal exponent) {
    if (base == null || exponent == null) {
      throw new IllegalArgumentException("Neither base nor exponent may be null.");
    }
    BigDecimal result = BigDecimal.ONE;
    for (int i = 0; i < exponent.intValue(); i++) {
      result = result.multiply(base);
    }
    return result;
  }
}
