package dev.demonboat.mortgageplan.rest.create;

import javax.validation.constraints.*;

public final class CreateProspect {

  @NotBlank
  @Size(max = 150)
  private final String customerName;
  @NotNull
  @DecimalMin("0.0")
  @DecimalMax("30000.0")
  private final Double totalLoan;
  @NotNull
  @DecimalMin("0.0")
  @DecimalMax("30000.0")
  private final Double interest;
  @NotNull
  @DecimalMin("0.0")
  @DecimalMax("30000.0")
  private final Integer years;

  public CreateProspect(final String customerName, final Double totalLoan, final Double interest, final Integer years) {
    this.customerName = customerName;
    this.totalLoan = totalLoan;
    this.interest = interest;
    this.years = years;
  }

  public String getCustomerName() {
    return customerName;
  }

  public Double getTotalLoan() {
    return totalLoan;
  }

  public Double getInterest() {
    return interest;
  }

  public Integer getYears() {
    return years;
  }
}
