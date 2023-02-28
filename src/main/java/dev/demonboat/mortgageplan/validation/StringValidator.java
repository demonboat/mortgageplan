package dev.demonboat.mortgageplan.validation;

public final class StringValidator {

  private final String fieldName;
  private final int minLength;
  private final Integer maxLength;
  private final boolean nullValid;


  public StringValidator(
    final String fieldName,
    final int minLength,
    final Integer maxLength,
    final boolean nullValid) {
    if (fieldName == null) {
      throw new IllegalArgumentException("Field name may not be null.");
    }
    if (maxLength < minLength) {
      throw new IllegalArgumentException("maximum length may not be shorter than minimum length.");
    }

    this.fieldName = fieldName;
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.nullValid = nullValid;
  }


  public void validate(final String value) {
    if (isValid(value)) {
      return;
    }
    String exceptionMessage = """
      Expected %s to have minimum length of %d, a maximum length of %d if null was valid: %s, but it was:
      null: %s, value: %s
    """.formatted(fieldName, minLength, maxLength, nullValid, value == null, value);
    throw new IllegalArgumentException(exceptionMessage);
  }

  private boolean isValid(final String value) {
    if (value == null) {
      return nullValid;
    }
    int length = value.length();
    if (length < minLength) {
      return false;
    }
    if (length > maxLength) {
      return false;
    }
    return true;
  }

}
