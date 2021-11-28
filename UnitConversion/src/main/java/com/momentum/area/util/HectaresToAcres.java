package com.momentum.area.util;

import org.springframework.stereotype.Component;

import com.momentum.service.util.IUnitConversion;
import com.momentum.service.util.UnitConversionConstant;

@Component
public class HectaresToAcres implements IUnitConversion{

	@Override
	public double getConvertedValue(double inputValue) {
		// TODO Auto-generated method stub
		return inputValue / UnitConversionConstant.ACRES_HECTARES_CONVERSION_VALUE;
	}
}