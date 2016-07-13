package com.math.clockangle.impl;

import com.math.clockangle.model.calc.ClockCheck;

public class ClockCheckImpl implements ClockCheck{
	
	//Validate if parameters are numbers
	public boolean isValidTimeNumber(String hour, String minute){		
		try {
			Integer.parseInt(hour);
			Integer.parseInt(minute);
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
		return true;
	}
	
	//Validate if Hour and Minute are inside time (12h and 60min)
	public boolean isValidTimeClock(int hour, int minute){
		return (hour < 0 || hour > 12 || minute < 0 || minute > 60) ? false : true;	
	}
	
}
