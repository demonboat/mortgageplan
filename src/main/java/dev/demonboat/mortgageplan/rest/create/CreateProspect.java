package dev.demonboat.mortgageplan.rest.create;

import javax.validation.constraints.*;

public record CreateProspect(@NotBlank @Size(max = 150) String customerName,
                             @NotNull @DecimalMin("0.0") @DecimalMax("5000.0") Double totalLoan,
                             @NotNull @DecimalMin("0.0") @DecimalMax("5000.0") Double interest,
                             @NotNull @DecimalMin("0.0") @DecimalMax("5000.0") Integer years) {

  public CreateProspect(final String customerName, final Double totalLoan, final Double interest, final Integer years) {
    this.customerName = customerName;
    this.totalLoan = totalLoan;
    this.interest = interest;
    this.years = years;
  }
}
