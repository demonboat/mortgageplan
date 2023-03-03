package dev.demonboat.mortgageplan.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class NumberValidatorTest {

  @Test
  public void testSuccessCreateAndUse() {
    final NumberValidator<Double> validator = new NumberValidator<>("test", 0.0, 5.0, false);
    validator.validate(0.0);
    validator.validate(5.0);
    validator.validate(3.5);
    assertThrows(IllegalArgumentException.class, () -> validator.validate(null));
    assertThrows(IllegalArgumentException.class, () -> validator.validate(6.0));
    assertThrows(IllegalArgumentException.class, () -> validator.validate(-1.0));
  }
}
