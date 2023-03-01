package dev.demonboat.mortgageplan.service;

import dev.demonboat.mortgageplan.logic.FixedMonthlyRateCalculator;
import dev.demonboat.mortgageplan.model.NamedColumnBean;
import dev.demonboat.mortgageplan.model.Prospect;
import dev.demonboat.mortgageplan.util.CsvUtil;
import dev.demonboat.mortgageplan.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProspectServiceImpl implements ProspectService {
  @Override
  public List<Prospect> getProspects() {
    var csvValues = CsvUtil.getValuesFromCsv();
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
