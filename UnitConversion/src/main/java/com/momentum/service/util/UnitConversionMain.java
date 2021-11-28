package com.momentum.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UnitConversionMain {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public double obtainConvertedValue(IUnitConversion unitConversion,double inputValue) {
		logger.info("Entering obtainConvertedValue method");
		return unitConversion.getConvertedValue(inputValue);
	}
	
}
