package com.realdolmen.services.impl;

import org.springframework.stereotype.Component;

import com.realdolmen.services.CalculatorService;

@Component
public class CalculatorServiceImpl implements CalculatorService{

	@Override
	public int add(int x, int y) {
		return x + y;
	}

}
