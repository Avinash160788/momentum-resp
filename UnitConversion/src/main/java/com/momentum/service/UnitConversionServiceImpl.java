package com.momentum.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momentum.area.util.IAreaUnitConversionMain;
import com.momentum.length.util.ILengthUnitConversionMain;
import com.momentum.temperature.util.ITemperatureUnitConversionMain;
import com.momentum.volumn.util.IVolumnUnitConversionMain;
import com.momentum.weight.util.IWeightUnitConversionMain;


@Service
public class UnitConversionServiceImpl implements IUnitConversionService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ILengthUnitConversionMain lengthUnitConversionMain;
	@Autowired
	IWeightUnitConversionMain weightUnitConversionMain;
	@Autowired
	ITemperatureUnitConversionMain temperatureUnitConversionMain;
	@Autowired
	IAreaUnitConversionMain areaUnitConversionMain;
	@Autowired
	IVolumnUnitConversionMain volumnUnitConversionMain;
	
	/**
	 * Description: Perform length unit conversion from metric to imperial and vice versa. 
	 */
	@Override
	public double performLengthUnitConverion(String fromUnit, String toUnit, double inputValue) {
		return lengthUnitConversionMain.performLengthUnitConverion(fromUnit, toUnit, inputValue);
	}

	/**
	 * Description: Perform weight unit conversion from metric to imperial and vice versa.
	 */
	@Override
	public double performWeightUnitConverion(String fromUnit, String toUnit, double inputValue) {
		return weightUnitConversionMain.performWeightUnitConverion(fromUnit, toUnit, inputValue);
	}
	
	/**
	 * Description: Perform temperature unit conversion from metric to imperial and vice versa.
	 */
	@Override
	public double performTemperatureUnitConverion(String fromUnit, String toUnit, double inputValue) {
		return temperatureUnitConversionMain.performTemperatureUnitConverion(fromUnit, toUnit, inputValue);
	}

	/**
	 * Description: Perform area unit conversion from metric to imperial and vice versa.
	 */
	@Override
	public double performAreaUnitConverion(String fromUnit, String toUnit, double inputValue) {
		return areaUnitConversionMain.performAreaUnitConverion(fromUnit, toUnit, inputValue);
	}

	/**
	 * Description: Perform volumn unit conversion from metric to imperial and vice versa.
	 */
	@Override
	public double performVolumnUnitConverion(String fromUnit, String toUnit, double inputValue) {
		return volumnUnitConversionMain.performVolumnUnitConverion(fromUnit, toUnit, inputValue);
	}

}	
