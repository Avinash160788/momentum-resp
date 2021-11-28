package com.momentum.length.util;

import org.springframework.stereotype.Component;

import com.momentum.service.util.IUnitConversion;
import com.momentum.service.util.UnitConversionConstant;

@Component
public class MilesToKilometers implements IUnitConversion {

	@Override
	public double getConvertedValue(double inputValue) {
		// TODO Auto-generated method stub
		return inputValue * UnitConversionConstant.MILES_KILOMETER_CONVERSION_VALUE;
	}

}