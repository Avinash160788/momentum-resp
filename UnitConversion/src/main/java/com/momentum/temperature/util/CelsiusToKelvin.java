package com.momentum.temperature.util;

import static tec.units.ri.unit.Units.CELSIUS;
import static tec.units.ri.unit.Units.KELVIN;
import javax.measure.UnitConverter;
import org.springframework.stereotype.Component;

import com.momentum.service.util.IUnitConversion;

@Component
public class CelsiusToKelvin implements IUnitConversion{

	@Override
	public double getConvertedValue(double inputValue) {
		// TODO Auto-generated method stub
		UnitConverter celsiusToKelvin = CELSIUS.getConverterTo(KELVIN);
		return celsiusToKelvin.convert(inputValue);
	}
}