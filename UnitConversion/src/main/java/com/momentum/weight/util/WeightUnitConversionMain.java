package com.momentum.weight.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.momentum.exception.InvalidInputException;
import com.momentum.service.util.UnitConversionConstant;
import com.momentum.service.util.UnitConversionMain;

@Component
public class WeightUnitConversionMain implements IWeightUnitConversionMain{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UnitConversionMain unitConversionMain;
	@Autowired
	KilogramsToPound kilogramsToPound;
	@Autowired
	PoundsToKilograms poundsToKilograms;
	@Override
	public double performWeightUnitConverion(String fromUnit, String toUnit, double inputValue) {
		logger.info("Entering performWeightUnitConverion method");
		double outputValue=0;
		if(fromUnit!=null && toUnit!=null && inputValue!=(double)0) {
			if(fromUnit.equalsIgnoreCase(UnitConversionConstant.KILOGRAMS) && toUnit.equalsIgnoreCase(UnitConversionConstant.POUNDS)) 
				outputValue= unitConversionMain.obtainConvertedValue(kilogramsToPound,inputValue);
			else if(fromUnit.equalsIgnoreCase(UnitConversionConstant.POUNDS) && toUnit.equalsIgnoreCase(UnitConversionConstant.KILOGRAMS)) 
				outputValue = unitConversionMain.obtainConvertedValue(poundsToKilograms,inputValue);
			else 
				throw new InvalidInputException("Invalid Input Found!!");
		}else
			throw new InvalidInputException("Invalid Input Found!!");
		logger.info("Exiting performWeightUnitConverion method");
		return outputValue;
	}
}
