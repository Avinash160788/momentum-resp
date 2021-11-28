package com.momentum.area.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.momentum.exception.InvalidInputException;
import com.momentum.service.util.UnitConversionConstant;
import com.momentum.service.util.UnitConversionMain;

@Component
public class AreaUnitConversionMain implements IAreaUnitConversionMain{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UnitConversionMain unitConversionMain;
	@Autowired
	AcresToHectares acresToHectares;
	@Autowired
	HectaresToAcres hectaresToAcres;
	@Override
	public double performAreaUnitConverion(String fromUnit, String toUnit, double inputValue) {
		logger.info("Entering performAreaUnitConverion method");
		double outputValue=0;
		if(fromUnit!=null && toUnit!=null && inputValue!=(double)0) {
			if(fromUnit.equalsIgnoreCase(UnitConversionConstant.ACRES) && toUnit.equalsIgnoreCase(UnitConversionConstant.HECTARES)) 
				outputValue= unitConversionMain.obtainConvertedValue(acresToHectares,inputValue);
			else if(fromUnit.equalsIgnoreCase(UnitConversionConstant.HECTARES) && toUnit.equalsIgnoreCase(UnitConversionConstant.ACRES)) 
				outputValue = unitConversionMain.obtainConvertedValue(hectaresToAcres,inputValue);
			else 
				throw new InvalidInputException("Invalid Input Found!!");
		}else
			throw new InvalidInputException("Invalid Input Found!!");
		logger.info("Exiting performAreaUnitConverion method");
		return outputValue;
	}
}
