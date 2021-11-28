package com.momentum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.momentum.bean.UnitConversionBean;
import com.momentum.service.IUnitConversionService;

@RestController
public class UnitConversionController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IUnitConversionService unitConversionService;
	
	@PostMapping("/lengthUnitConversion")
	public double lengthConvert(@RequestBody UnitConversionBean requestDao) {
		logger.info("Entring lengthConvert method");
		return unitConversionService.performLengthUnitConverion(requestDao.getFromUnit(), requestDao.getToUnit(), requestDao.getInputValue());
	}
	
	@PostMapping("/weightUnitConversion")
	public double weigthConvert(@RequestBody UnitConversionBean requestDao) {
		logger.info("Entring weigthConvert method");
		return unitConversionService.performWeightUnitConverion(requestDao.getFromUnit(), requestDao.getToUnit(), requestDao.getInputValue());
	}
	
	@PostMapping("/temperatureUnitConversion")
	public double temperatureConvert(@RequestBody UnitConversionBean requestDao) {
		logger.info("Entring temperatureConvert method");
		return unitConversionService.performTemperatureUnitConverion(requestDao.getFromUnit(), requestDao.getToUnit(), requestDao.getInputValue());
	}
	
	@PostMapping("/volumnUnitConversion")
	public double volumnConvert(@RequestBody UnitConversionBean requestDao) {
		logger.info("Entring volumnConvert method");
		return unitConversionService.performVolumnUnitConverion(requestDao.getFromUnit(), requestDao.getToUnit(), requestDao.getInputValue());
	}
	
	@PostMapping("/areaUnitConversion")
	public double convert(@RequestBody UnitConversionBean requestDao) {
		logger.info("Entring areaConvert method");
		return unitConversionService.performAreaUnitConverion(requestDao.getFromUnit(), requestDao.getToUnit(), requestDao.getInputValue());
	}
}
