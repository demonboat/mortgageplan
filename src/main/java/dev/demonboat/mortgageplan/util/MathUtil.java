package dev.demonboat.mortgageplan.util;

public final class MathUtil {

  private MathUtil() {}

  public static Double pow(final Double base, final Double exponent) {
    if (base == null || exponent == null) {
      throw new IllegalArgumentException("Neither base nor exponent may be null.");
    }
    double result = 1.0;
    for (int i = 0; i < exponent.intValue(); i++) {
      result *= base;
    }
    return result;
  }
}
