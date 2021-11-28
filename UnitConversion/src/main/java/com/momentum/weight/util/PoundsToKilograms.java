package com.momentum.weight.util;

import org.springframework.stereotype.Component;

import com.momentum.service.util.IUnitConversion;
import com.momentum.service.util.UnitConversionConstant;

@Component
public class PoundsToKilograms implements IUnitConversion {

	@Override
	public double getConvertedValue(double inputValue) {
		// TODO Auto-generated method stub
		return inputValue / UnitConversionConstant.KILOGRAMS_POUNDS_CONVERSION_VALUE;
	}

}