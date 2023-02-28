package dev.demonboat.mortgageplan.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class MathUtilTest {


  @Test
  public void testSuccessAndUse() {
    assertEquals(243.0, MathUtil.pow(3.0, 5.0));
    assertEquals(16.0, MathUtil.pow(4.0, 2.0));
    assertEquals(4096.0, MathUtil.pow(4.0,6.0));
  }

  @Test
  public void testFailsWithInvalidLeftParameter() {
    assertThrows(IllegalArgumentException.class, () -> MathUtil.pow(null,3.0));

  }

  @Test
  public void testFailsWithInvalidRightParameter() {
    assertThrows(IllegalArgumentException.class, () -> MathUtil.pow(5.0, null));
  }
}
