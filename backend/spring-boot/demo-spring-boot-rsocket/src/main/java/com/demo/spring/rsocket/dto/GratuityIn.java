package com.demo.spring.rsocket.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GratuityIn {

  private BigDecimal billTotal;

  private int percent;
}
