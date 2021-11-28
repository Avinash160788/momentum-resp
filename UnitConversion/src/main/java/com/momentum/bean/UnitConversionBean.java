package com.momentum.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnitConversionBean {
	@Setter @Getter
	private String fromUnit;
	@Setter @Getter
	private String toUnit;
	@Setter @Getter
	private double inputValue;
}
