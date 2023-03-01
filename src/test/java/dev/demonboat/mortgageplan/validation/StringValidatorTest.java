package dev.demonboat.mortgageplan.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class StringValidatorTest {

  @Test
  public void testSuccessAndUse() {
    final StringValidator testValidator = new StringValidator("test field", 0, 30, true);
    testValidator.validate("TEST");
    testValidator.validate(null);
  }

  @Test
  public void testFailsWithInvalidParameters() {
    final StringValidator testValidator = new StringValidator("test field", 1, 5, false);
    assertThrows(IllegalArgumentException.class, () -> testValidator.validate(""));
    assertThrows(IllegalArgumentException.class, () -> testValidator.validate(null));
    assertThrows(IllegalArgumentException.class, () -> testValidator.validate("AAAAAA"));
  }
}
