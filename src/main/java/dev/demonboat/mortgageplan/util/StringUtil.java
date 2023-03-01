package dev.demonboat.mortgageplan.util;

import org.apache.commons.lang3.StringUtils;

public final class StringUtil {

  private StringUtil() {}

  public static String fixAndTrimDirtyString(final String value) {
    if (value == null) {
      throw new IllegalArgumentException("Value may not be null.");
    }
    return StringUtils.trimToNull(value.replace(",", " "));
  }
}
