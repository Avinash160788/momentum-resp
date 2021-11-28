package com.momentum.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static tec.units.ri.unit.Units.CELSIUS;
import static tec.units.ri.unit.Units.KELVIN;

import javax.measure.UnitConverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.momentum.area.util.IAreaUnitConversionMain;
import com.momentum.bean.UnitConversionBean;
import com.momentum.length.util.ILengthUnitConversionMain;
import com.momentum.service.IUnitConversionService;
import com.momentum.temperature.util.ITemperatureUnitConversionMain;
import com.momentum.volumn.util.IVolumnUnitConversionMain;
import com.momentum.weight.util.IWeightUnitConversionMain;

@WebMvcTest
@RunWith(SpringRunner.class)
public class UnitConversionControllerTests {
	@MockBean
	IUnitConversionService unitConversionService;
	@MockBean
	ILengthUnitConversionMain lengthUnitConversionMain;
	@MockBean
	IWeightUnitConversionMain weightUnitConversionMain;
	@MockBean
	ITemperatureUnitConversionMain temperatureUnitConversionMain;
	@MockBean
	IAreaUnitConversionMain areaUnitConversionMain;
	@MockBean
	IVolumnUnitConversionMain volumnUnitConversionMain;
	@Mock
	Logger logger;
	@Autowired
	private MockMvc mockMvc;
	
	
	private static ObjectMapper mapper = new ObjectMapper();
	@Test
	public void lengthConvertTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("MILES", "KILOMETERS", 10);
		String json = mapper.writeValueAsString(unitConversionBean);
		Mockito.when(logger.isInfoEnabled()).thenReturn(true);
		double convertValue = (double)1.609 * unitConversionBean.getInputValue(); 

		Mockito.when(lengthUnitConversionMain.performLengthUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		Mockito.when(unitConversionService.performLengthUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		
		MvcResult result = mockMvc.perform(post("/lengthUnitConversion").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).
				accept(MediaType.APPLICATION_JSON)).
				andDo(print()).andReturn();
		String outputValue = result.getResponse().getContentAsString();

		double output = Double.parseDouble(outputValue);
		logger.info("output:"+output);
		assertEquals(16.09,output,0);
	}
	
	@Test
	public void weightConvertTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("KILOGRAMS", "POUNDS", 10);
		String json = mapper.writeValueAsString(unitConversionBean);
		Mockito.when(logger.isInfoEnabled()).thenReturn(true);
		double convertValue = (double)2.205 * unitConversionBean.getInputValue(); 

		Mockito.when(weightUnitConversionMain.performWeightUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		Mockito.when(unitConversionService.performWeightUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		
		MvcResult result = mockMvc.perform(post("/weightUnitConversion").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).
				accept(MediaType.APPLICATION_JSON)).
				andDo(print()).andReturn();
		String outputValue = result.getResponse().getContentAsString();

		double output = Double.parseDouble(outputValue);
		logger.info("output:"+output);
		assertEquals(22.05,output,0);
	}
	
	@Test
	public void temperatureConvertTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("CELSIUS", "KELVIN", 5);
		String json = mapper.writeValueAsString(unitConversionBean);
		Mockito.when(logger.isInfoEnabled()).thenReturn(true);

		UnitConverter celsiusToKelvin = CELSIUS.getConverterTo(KELVIN);
		double convertValue = celsiusToKelvin.convert(unitConversionBean.getInputValue()); 

		Mockito.when(temperatureUnitConversionMain.performTemperatureUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		Mockito.when(unitConversionService.performTemperatureUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		
		MvcResult result = mockMvc.perform(post("/temperatureUnitConversion").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).
				accept(MediaType.APPLICATION_JSON)).
				andDo(print()).andReturn();
		String outputValue = result.getResponse().getContentAsString();

		double output = Double.parseDouble(outputValue);
		logger.info("output:"+output);
		assertEquals(278.15,output,0);
	}
	
	@Test
	public void areaConvertTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("ACRES", "HECTARES", 4);
		String json = mapper.writeValueAsString(unitConversionBean);
		Mockito.when(logger.isInfoEnabled()).thenReturn(true);

		double convertValue = (double)0.405 * unitConversionBean.getInputValue(); 

		Mockito.when(areaUnitConversionMain.performAreaUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		Mockito.when(unitConversionService.performAreaUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		
		MvcResult result = mockMvc.perform(post("/areaUnitConversion").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).
				accept(MediaType.APPLICATION_JSON)).
				andDo(print()).andReturn();
		String outputValue = result.getResponse().getContentAsString();

		double output = Double.parseDouble(outputValue);
		logger.info("output:"+output);
		assertEquals(1.62,output,0.01);
	}
	
	@Test
	public void volumnConvertTest() throws Exception {
		UnitConversionBean unitConversionBean = new UnitConversionBean("LITRES", "GALLONS", 7);
		String json = mapper.writeValueAsString(unitConversionBean);
		Mockito.when(logger.isInfoEnabled()).thenReturn(true);

		double convertValue = (double)unitConversionBean.getInputValue()/4.546 ; 

		Mockito.when(volumnUnitConversionMain.performVolumnUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		Mockito.when(unitConversionService.performVolumnUnitConverion(unitConversionBean.getFromUnit(), unitConversionBean.getToUnit(), unitConversionBean.getInputValue())).thenReturn(convertValue);
		
		MvcResult result = mockMvc.perform(post("/volumnUnitConversion").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).
				accept(MediaType.APPLICATION_JSON)).
				andDo(print()).andReturn();
		String outputValue = result.getResponse().getContentAsString();

		double output = Double.parseDouble(outputValue);
		logger.info("output:"+output);
		assertEquals(1.53,output,0.01);
	}
		
}
