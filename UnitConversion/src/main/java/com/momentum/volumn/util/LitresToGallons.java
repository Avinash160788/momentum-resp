package com.momentum.volumn.util;

import org.springframework.stereotype.Component;

import com.momentum.service.util.IUnitConversion;
import com.momentum.service.util.UnitConversionConstant;

@Component
public class LitresToGallons  implements IUnitConversion{

	@Override
	public double getConvertedValue(double inputValue) {
		// TODO Auto-generated method stub
		return inputValue / UnitConversionConstant.GALLONS_LITRES_CONVERSION_VALUE;
	}

}