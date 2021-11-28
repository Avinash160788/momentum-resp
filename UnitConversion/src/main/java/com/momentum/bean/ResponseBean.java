package com.momentum.bean;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ResponseBean {
	@Setter @Getter
	private double outputValue;
}