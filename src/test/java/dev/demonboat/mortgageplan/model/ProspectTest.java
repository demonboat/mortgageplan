package dev.demonboat.mortgageplan.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class ProspectTest {

  @Test
  public void testSuccessAndUse() {
    Prospect prospect = new Prospect("K", 10.0, 3.0, 2);
    assertEquals("K", prospect.customerName());
    assertEquals(10.0, prospect.totalLoan());
    assertEquals(3.0, prospect.interest());
    assertEquals(2, prospect.years());

    // Normally, there's a StringUtils for repeat values in strings.
    String bigString = "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK";
    prospect = new Prospect(bigString, 30000.0, 30000.0, 100);
    assertEquals("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK", prospect.customerName());
    assertEquals(30000.0, prospect.totalLoan());
    assertEquals(30000.0, prospect.interest());
    assertEquals(100, prospect.years());
  }

  @Test
  public void testFailsWithInvalidCustomerName() {
    // 51 characters.
    String bigString = "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK";
    assertThrows(IllegalArgumentException.class, () -> new Prospect(null, 1.0, 1.0, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("", 1.0, 1.0, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect(bigString, 1.0, 1.0, 3));
  }

  @Test
  public void testFailsWithInvalidTotalLoan() {
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", null, 1.0, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", -1.0, 1.0, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", 3001.0, 1.0, 3));
  }

  @Test
  public void testFailsWithInvalidInterest() {
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", 1.0, null, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", 1.0, -1.0, 3));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", 1.0, 3001.0, 3));
  }

  @Test
  public void testFailsWithInvalidYears() {
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", 1.0, 1.0, null));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", 1.0, 1.0, -1));
    assertThrows(IllegalArgumentException.class, () -> new Prospect("K", 1.0, 1.0, 101));
  }
}
