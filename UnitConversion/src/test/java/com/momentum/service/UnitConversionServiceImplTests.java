package com.momentum.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static tec.units.ri.unit.Units.CELSIUS;
import static tec.units.ri.unit.Units.KELVIN;

import javax.measure.UnitConverter;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.momentum.area.util.IAreaUnitConversionMain;
import com.momentum.bean.UnitConversionBean;
import com.momentum.exception.InvalidInputException;
import com.momentum.length.util.ILengthUnitConversionMain;
import com.momentum.temperature.util.ITemperatureUnitConversionMain;
import com.momentum.volumn.util.IVolumnUnitConversionMain;
import com.momentum.volumn.util.VolumnUnitConversionMain;
import com.momentum.weight.util.IWeightUnitConversionMain;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitConversionServiceImplTests {
	
	@Mock
	ILengthUnitConversionMain lengthUnitConversionMain;
	@Mock
	IWeightUnitConversionMain weightUnitConversionMain;
	@Mock
	ITemperatureUnitConversionMain temperatureUnitConversionMain;
	@Mock
	IAreaUnitConversionMain areaUnitConversionMain;
	@Mock
	IVolumnUnitConversionMain volumnUnitConversionMain;
	@Mock
	Logger logger;
	@InjectMocks
	UnitConversionServiceImpl unitConversionServiceImpl;

	@Test
	public void volumnConvertExceptionTest() {
		InvalidInputException thrown = Assertions.assertThrows(InvalidInputException.class, () -> {
			new VolumnUnitConversionMain().performVolumnUnitConverion("LITRES", "GALLONS", 0);
		});
		Assertions.assertEquals("Invalid Input Found!!", thrown.getMessage());
	}
	
	@Test
	public void volumnConvertTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("LITRES", "GALLONS", 7);
		double convertValue = (double)unitConversionBean.getInputValue()/4.546 ; 

		when(volumnUnitConversionMain.performVolumnUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		double output = unitConversionServiceImpl.performVolumnUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue());
		logger.info("output:"+output);
		assertEquals(1.53,output,0.01);
	}
	
	@Test
	public void performLengthUnitConversionTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("MILES", "KILOMETERS", 10);
		double convertValue = (double)1.609 * unitConversionBean.getInputValue(); 
		when(lengthUnitConversionMain.performLengthUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		double output = unitConversionServiceImpl.performLengthUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue());		
		logger.info("output:"+output);
		assertEquals(16.09,output,0);
	}

	@Test
	public void performWeightUnitConverionTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("KILOGRAMS", "POUNDS", 10);
		double convertValue = (double)2.205 * unitConversionBean.getInputValue(); 

		when(weightUnitConversionMain.performWeightUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		double output = unitConversionServiceImpl.performWeightUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue());
		logger.info("output:"+output);
		assertEquals(22.05,output,0);
	}
	
	@Test
	public void performTemperatureUnitConverion() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("CELSIUS", "KELVIN", 5);
		UnitConverter celsiusToKelvin = CELSIUS.getConverterTo(KELVIN);
		double convertValue = celsiusToKelvin.convert(unitConversionBean.getInputValue()); 

		when(temperatureUnitConversionMain.performTemperatureUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		double output = unitConversionServiceImpl.performTemperatureUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue());
		
		logger.info("output:"+output);
		assertEquals(278.15,output,0);
	}
	
	@Test
	public void performAreaUnitConverion() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("ACRES", "HECTARES", 4);
		double convertValue = (double)0.405 * unitConversionBean.getInputValue(); 

		when(areaUnitConversionMain.performAreaUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		double output = unitConversionServiceImpl.performAreaUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue());
		logger.info("output:"+output);
		assertEquals(1.62,output,0.01);
	}
	
	
}
