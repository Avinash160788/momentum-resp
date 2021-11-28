package com.momentum.service;


public interface IUnitConversionService {
	double performLengthUnitConverion(String fromUnit,String toUnit,double inputValue);
	double performWeightUnitConverion(String fromUnit,String toUnit,double inputValue);
	double performTemperatureUnitConverion(String fromUnit,String toUnit,double inputValue);
	double performAreaUnitConverion(String fromUnit,String toUnit,double inputValue);
	double performVolumnUnitConverion(String fromUnit,String toUnit,double inputValue);
}
