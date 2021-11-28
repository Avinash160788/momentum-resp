package com.momentum.temperature.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.momentum.exception.InvalidInputException;
import com.momentum.service.util.UnitConversionConstant;
import com.momentum.service.util.UnitConversionMain;

@Component
public class TemperatureUnitConversionMain implements ITemperatureUnitConversionMain{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UnitConversionMain unitConversionMain;
	@Autowired
	CelsiusToKelvin celsiusToKelvin;
	@Autowired
	KelvinToCelsius kelvinToCelsius;
	@Override
	public double performTemperatureUnitConverion(String fromUnit, String toUnit, double inputValue) {
		logger.info("Entering performTemperatureUnitConverion method");
		double outputValue=0;
		if(fromUnit!=null && toUnit!=null && inputValue!=(double)0) {
			if(fromUnit.equalsIgnoreCase(UnitConversionConstant.CELSIUS) && toUnit.equalsIgnoreCase(UnitConversionConstant.KELVIN)) 
				outputValue= unitConversionMain.obtainConvertedValue(celsiusToKelvin,inputValue);
			else if(fromUnit.equalsIgnoreCase(UnitConversionConstant.KELVIN) && toUnit.equalsIgnoreCase(UnitConversionConstant.CELSIUS)) 
				outputValue = unitConversionMain.obtainConvertedValue(kelvinToCelsius,inputValue);
			else 
				throw new InvalidInputException("Invalid Input Found!!");
		}else
			throw new InvalidInputException("Invalid Input Found!!");
		logger.info("Exiting performTemperatureUnitConverion method");
		return outputValue;
	}
	
}
