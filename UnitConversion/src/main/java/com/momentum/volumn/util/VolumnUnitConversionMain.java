package com.momentum.volumn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.momentum.exception.InvalidInputException;
import com.momentum.service.util.UnitConversionConstant;
import com.momentum.service.util.UnitConversionMain;

@Component
public class VolumnUnitConversionMain implements IVolumnUnitConversionMain{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UnitConversionMain unitConversionMain;
	@Autowired
	LitresToGallons litresToGallons; 
	@Autowired
	GallonsToLitres gallonsToLitres; 
	@Override
	public double performVolumnUnitConverion(String fromUnit, String toUnit, double inputValue) {
		logger.info("Entering performVolumnUnitConverion method");
		double outputValue=0;
		if(fromUnit!=null && toUnit!=null && inputValue!=(double)0) {
			if(fromUnit.equalsIgnoreCase(UnitConversionConstant.LITRES) && toUnit.equalsIgnoreCase(UnitConversionConstant.GALLONS)) 
				outputValue= unitConversionMain.obtainConvertedValue(litresToGallons,inputValue);
			else if(fromUnit.equalsIgnoreCase(UnitConversionConstant.GALLONS) && toUnit.equalsIgnoreCase(UnitConversionConstant.LITRES)) 
				outputValue = unitConversionMain.obtainConvertedValue(gallonsToLitres,inputValue);
			else 
				throw new InvalidInputException("Invalid Input Found!!");
		}else
			throw new InvalidInputException("Invalid Input Found!!");
		logger.info("Exiting performVolumnUnitConverion method");
		return outputValue;
	}
}
