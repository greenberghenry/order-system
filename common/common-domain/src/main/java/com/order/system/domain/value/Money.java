package com.order.system.domain.value;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Money(BigDecimal amount) {

  public static final Money ZERO = of(BigDecimal.ZERO);

  public boolean isGreaterThanZero() {
    return amount.compareTo(BigDecimal.ZERO) > 0;
  }

  public boolean isGreaterThan(Money money) {
    return amount.compareTo(money.amount) > 0;
  }

  public Money add(Money money) {
    return of(scale(amount.add(money.amount)));
  }

  public Money subtract(Money money) {
    return of(scale(amount.subtract(money.amount)));
  }

  public Money multiply(int multiplier) {
    return of(scale(amount.multiply(new BigDecimal(multiplier))));
  }

  private BigDecimal scale(BigDecimal amount) {
    return amount.setScale(2, RoundingMode.HALF_EVEN);
  }

  public static Money of(BigDecimal amount) {
    return new Money(amount);
  }
}
