package org.edu.eci.arem;
import java.util.*;
import java.io.*;


public class Calculate {
	public ArrayList<Double> Data;
	public String[] data_base;
	
	public Calculate(String[] data) {
		// TODO Auto-generated constructor stub
		Data = new ArrayList<Double>();
		this.data_base=data;
		changeValue();
	}
	public void changeValue() {
		for (int i = 0; i < data_base.length; i++) {
			Data.add(Double.parseDouble(data_base[i])); 
			
		}
	}
	public double calculate_max() {
		double MAX = Double.MIN_VALUE;
		for(double num:Data) MAX= MAX>num?MAX:num;
		return MAX;
		
		
	}
	public double calculate_min() {
		double MIN = Double.MAX_VALUE;
		for(double num:Data) MIN= MIN<num?MIN:num;
		return MIN;
		
		
	}
	public double calculate_sum() {
		double sum = 0;
		for(double num:Data)sum+=num;;
		return sum;
	
	}
	public double calculate_mult() {
		double mult = 1;
		for(double num:Data)mult*=num;;
		return mult;
	
	}
	
	
	
	
	
	
}
