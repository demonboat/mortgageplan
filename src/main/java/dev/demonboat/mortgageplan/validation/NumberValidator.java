package dev.demonboat.mortgageplan.validation;

public final class NumberValidator<T extends Comparable<T>> {

  private final String fieldName;
  private final T minValue;
  private final T maxValue;
  private final boolean nullValid;


  public NumberValidator(final String fieldName, final T minValue, final T maxValue, final boolean nullValid) {
    this.fieldName = fieldName;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.nullValid = nullValid;
  }


  public void validate(final T value) {
    if (isValid(value)) {
      return;
    }
    String exceptionMessage = null;
    if (value instanceof Double) {
      exceptionMessage = """
      Expected %s to have minimum value of %f, a maximum value of %f if null was valid: %s, but it was:
      null: %s, value: %f
    """.formatted(fieldName, minValue, maxValue, nullValid, value == null, value);
    } else if (value instanceof Integer) {
      exceptionMessage = """
        Expected %s to have minimum value of %d, a maximum value of %d if null was valid: %s, but it was:
        null: %s, value: %d
      """.formatted(fieldName, minValue, maxValue, nullValid, value == null, value);
    }
    throw new IllegalArgumentException(exceptionMessage);
  }

  private boolean isValid(final T value) {
    if (value == null) {
      return nullValid;
    }
    if (minValue != null) {
      int result = value.compareTo(minValue);
      if (result < 0) {
        return false;
      }
    }
    if (maxValue != null) {
      int result = value.compareTo(maxValue);
      if (result > 0) {
        return false;
      }
    }
    return true;
  }
}
