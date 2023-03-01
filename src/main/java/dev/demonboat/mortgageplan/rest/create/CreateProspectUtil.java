package dev.demonboat.mortgageplan.rest.create;

import dev.demonboat.mortgageplan.logic.FixedMonthlyRateCalculator;
import dev.demonboat.mortgageplan.model.Prospect;
import dev.demonboat.mortgageplan.util.StringUtil;

public final class CreateProspectUtil {

  private CreateProspectUtil() {}

  public static Prospect prospectFromCreateProspect(final CreateProspect createProspect) {
    double monthlyFixedRate = FixedMonthlyRateCalculator.calculate(
      createProspect.getTotalLoan(), createProspect.getInterest(), createProspect.getYears());

    return new Prospect(
    StringUtil.fixAndTrimDirtyString(createProspect.getCustomerName()),
      createProspect.getTotalLoan(),
      createProspect.getInterest(),
      createProspect.getYears(),
      monthlyFixedRate);
  }
}
