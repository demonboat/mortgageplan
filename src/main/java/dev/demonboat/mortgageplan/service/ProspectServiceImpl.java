package dev.demonboat.mortgageplan.service;

import dev.demonboat.mortgageplan.logic.FixedMonthlyRateCalculator;
import dev.demonboat.mortgageplan.model.NamedColumnBean;
import dev.demonboat.mortgageplan.model.Prospect;
import dev.demonboat.mortgageplan.util.CsvUtil;
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
    var csvValues = CsvUtil.getValuesFromCsv(
      Objects.requireNonNull(context.getClassLoader()).getResourceAsStream("csv/prospects.txt"));
    return csvValues.stream()
      .map(ProspectServiceImpl::toProspect)
      .toList();
  }


  public static Prospect toProspect(final NamedColumnBean namedColumnBean) {
    double monthlyFixedRate = FixedMonthlyRateCalculator.calculate(
    namedColumnBean.getTotalLoan(), namedColumnBean.getInterest(), namedColumnBean.getYears());

    return new Prospect(
    StringUtil.fixAndTrimDirtyString(namedColumnBean.getCustomer()),
    namedColumnBean.getTotalLoan(),
    namedColumnBean.getInterest(),
    namedColumnBean.getYears(),
    monthlyFixedRate);
  }

}
