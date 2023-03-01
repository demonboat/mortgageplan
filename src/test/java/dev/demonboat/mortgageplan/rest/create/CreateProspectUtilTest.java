package dev.demonboat.mortgageplan.rest.create;

import dev.demonboat.mortgageplan.model.Prospect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateProspectUtilTest {

  @Test
  public void testSuccessCreateAndUse() {
    var createProspect = new CreateProspect("Kalle", 1000.0, 5.0, 2);
    var expectedProspect = new Prospect("Kalle", 1000.0, 5.0, 2, 43.8713897340686);
    assertEquals(expectedProspect, CreateProspectUtil.prospectFromCreateProspect(createProspect));
  }
}
