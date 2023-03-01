package dev.demonboat.mortgageplan.model;

import com.opencsv.bean.CsvBindByName;

public class NamedColumnBean {

  @CsvBindByName(column = "Customer")
  private String customer;

  @CsvBindByName(column = "Total loan")
  private Double totalLoan;

  @CsvBindByName(column = "Interest")
  private Double interest;

  @CsvBindByName(column = "Years")
  private Integer years;

  public NamedColumnBean() {
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public Double getTotalLoan() {
    return totalLoan;
  }

  public void setTotalLoan(Double totalLoan) {
    this.totalLoan = totalLoan;
  }

  public Double getInterest() {
    return interest;
  }

  public void setInterest(Double interest) {
    this.interest = interest;
  }

  public Integer getYears() {
    return years;
  }

  public void setYears(Integer years) {
    this.years = years;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("NamedColumnBean{");
    sb.append("customer='").append(customer).append('\'');
    sb.append(", totalLoan=").append(totalLoan);
    sb.append(", interest=").append(interest);
    sb.append(", years=").append(years);
    sb.append('}');
    return sb.toString();
  }
}
