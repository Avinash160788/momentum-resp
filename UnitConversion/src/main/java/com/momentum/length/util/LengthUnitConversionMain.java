package com.momentum.length.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.momentum.exception.InvalidInputException;
import com.momentum.service.util.UnitConversionConstant;
import com.momentum.service.util.UnitConversionMain;

@Component
public class LengthUnitConversionMain implements ILengthUnitConversionMain{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UnitConversionMain unitConversionMain;
	@Autowired
	MilesToKilometers milesToKilometers;
	@Autowired
	KilometersToMiles kilometersToMiles;
	@Override
	public double performLengthUnitConverion(String fromUnit, String toUnit, double inputValue) {
		logger.info("Entering performLengthUnitConverion method");
		double outputValue=0;
		System.out.println("Entring performLengthUnitConverion method:"+fromUnit+","+ toUnit+","+ inputValue);
		if(fromUnit!=null && toUnit!=null && inputValue!=(double)0) {
			if(fromUnit.equalsIgnoreCase(UnitConversionConstant.MILES) && toUnit.equalsIgnoreCase(UnitConversionConstant.KILOMETERS))
				outputValue= unitConversionMain.obtainConvertedValue(milesToKilometers,inputValue);
			else if(fromUnit.equalsIgnoreCase(UnitConversionConstant.KILOMETERS) && toUnit.equalsIgnoreCase(UnitConversionConstant.MILES)) 
				outputValue = unitConversionMain.obtainConvertedValue(kilometersToMiles,inputValue);
			else 
				throw new InvalidInputException("Invalid Input Found!!");
		}else
			throw new InvalidInputException("Invalid Input Found!!");
		System.out.println("Exiting performLengthUnitConverion method:"+outputValue);
		logger.info("Exiting performLengthUnitConverion method");
		return outputValue;
	}
}
