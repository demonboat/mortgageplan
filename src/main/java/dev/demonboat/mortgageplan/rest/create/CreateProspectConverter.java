package dev.demonboat.mortgageplan.rest.create;

import dev.demonboat.mortgageplan.logic.FixedMonthlyRateCalculator;
import dev.demonboat.mortgageplan.model.Prospect;
import dev.demonboat.mortgageplan.util.StringUtil;

public final class CreateProspectConverter {

  private CreateProspectConverter() {}

  public static Prospect prospectFromCreateProspect(final CreateProspect createProspect) {
    double monthlyFixedRate = FixedMonthlyRateCalculator.calculate(
      createProspect.totalLoan(), createProspect.interest(), createProspect.years());

    return new Prospect(
    StringUtil.fixAndTrimDirtyString(createProspect.customerName()),
      createProspect.totalLoan(),
      createProspect.interest(),
      createProspect.years(),
      monthlyFixedRate);
  }
}
