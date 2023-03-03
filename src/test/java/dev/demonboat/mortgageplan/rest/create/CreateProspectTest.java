package dev.demonboat.mortgageplan.rest.create;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class CreateProspectTest {

  @Test
  public void testSuccessCreateAndUse() {
    CreateProspect prospect = new CreateProspect("K", 10.0, 3.0, 2);
    assertEquals("K", prospect.customerName());
    assertEquals(10.0, prospect.totalLoan());
    assertEquals(3.0, prospect.interest());
    assertEquals(2, prospect.years());

    // Normally, there's a StringUtils for repeat values in strings.
    String bigString = "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK";
    prospect = new CreateProspect(bigString, 5000.0, 5000.0, 100);
    assertEquals("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK", prospect.customerName());
    assertEquals(5000.0, prospect.totalLoan());
    assertEquals(5000.0, prospect.interest());
    assertEquals(100, prospect.years());
  }
}
