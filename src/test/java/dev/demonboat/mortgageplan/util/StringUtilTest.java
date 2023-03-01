package dev.demonboat.mortgageplan.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class StringUtilTest {

  @Test
  public void testSuccessAndUse() {
    var testString = "  Test,Testing  ";
    assertEquals("Test Testing", StringUtil.fixAndTrimDirtyString(testString));
    testString = "Test,Testing    ";
    assertEquals("Test Testing", StringUtil.fixAndTrimDirtyString(testString));
    testString = "    Test,Testing";
    assertEquals("Test Testing", StringUtil.fixAndTrimDirtyString(testString));
  }

  @Test
  public void testFailsWithNullParameter() {
    assertThrows(IllegalArgumentException.class, () -> StringUtil.fixAndTrimDirtyString(null));
  }
}
