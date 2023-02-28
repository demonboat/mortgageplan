package dev.demonboat.mortgageplan.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class MathUtilTest {


  @Test
  public void testSuccessAndUse() {
    assertEquals(new BigDecimal(243), MathUtil.pow(new BigDecimal(3), new BigDecimal(5)));
    assertEquals(new BigDecimal(16), MathUtil.pow(new BigDecimal(4), new BigDecimal(2)));
    assertEquals(new BigDecimal(4096), MathUtil.pow(new BigDecimal(4), new BigDecimal(6)));
  }

  @Test
  public void testFailsWithInvalidLeftParameter() {
    assertThrows(IllegalArgumentException.class, () -> MathUtil.pow(null, new BigDecimal(3)));

  }

  @Test
  public void testFailsWithInvalidRightParameter() {
    assertThrows(IllegalArgumentException.class, () -> MathUtil.pow(new BigDecimal(5), null));
  }
}
