package dev.demonboat.mortgageplan.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class ProspectTest {

  @Test
  public void testSuccessAndUse() {
    Prospect prospect = new Prospect("K", BigDecimal.TEN, new BigDecimal(3), 2);
    assertEquals("K", prospect.customerName());
    assertEquals(BigDecimal.TEN, prospect.totalLoan());
    assertEquals(new BigDecimal(3), prospect.interest());
    assertEquals(2, prospect.years());

    // Normally, there's a StringUtils for repeat values in strings.
    String bigString = "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK";
    prospect = new Prospect(bigString, new BigDecimal(30000), new BigDecimal(30000), 100);
    assertEquals("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK", prospect.customerName());
    assertEquals(new BigDecimal(30000), prospect.totalLoan());
    assertEquals(new BigDecimal(30000), prospect.interest());
    assertEquals(100, prospect.years());
  }

  @Test
  public void testFailsWithInvalidCustomerName() {
    // 51 characters.
    String bigString = "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK";
    assertThrows(IllegalArgumentException.class, () -> new Prospect(null, BigDecimal.ONE, BigDecimal.ONE, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("", BigDecimal.ONE, BigDecimal.ONE, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect(bigString, BigDecimal.ONE, BigDecimal.ONE, 3));
  }

  @Test
  public void testFailsWithInvalidTotalLoan() {
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", null, BigDecimal.ONE, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", BigDecimal.valueOf(-1), BigDecimal.ONE, 3));
  }

  @Test
  public void testFailsWithInvalidInterest() {
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", BigDecimal.ONE, null, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", BigDecimal.valueOf(-1), BigDecimal.valueOf(-1), 3));
  }

  @Test
  public void testFailsWithInvalidYears() {
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", BigDecimal.ONE, BigDecimal.ONE, null));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", BigDecimal.ONE, null, -1));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", BigDecimal.ONE, null, 101));

  }
}
