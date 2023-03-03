package dev.demonboat.mortgageplan.service;

import dev.demonboat.mortgageplan.logic.FixedMonthlyRateCalculator;
import dev.demonboat.mortgageplan.model.ProspectBean;
import dev.demonboat.mortgageplan.model.Prospect;
import dev.demonboat.mortgageplan.util.ProspectFileParser;
import dev.demonboat.mortgageplan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProspectServiceImpl implements ProspectService {

  @Autowired
  private ApplicationContext context;

  @Override
  public List<Prospect> getProspects() {
    var csvValues = ProspectFileParser.getValuesFromCsv(
      Objects.requireNonNull(context.getClassLoader()).getResourceAsStream("csv/prospects.txt"));
    return csvValues.stream()
      .map(ProspectServiceImpl::toProspect)
      .toList();
  }


  public static Prospect toProspect(final ProspectBean prospectBean) {
    double monthlyFixedRate = FixedMonthlyRateCalculator.calculate(
    prospectBean.getTotalLoan(), prospectBean.getInterest(), prospectBean.getYears());

    return new Prospect(
    StringUtil.fixAndTrimDirtyString(prospectBean.getCustomer()),
    prospectBean.getTotalLoan(),
    prospectBean.getInterest(),
    prospectBean.getYears(),
    monthlyFixedRate);
  }

}
