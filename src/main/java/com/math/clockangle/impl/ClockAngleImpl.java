package com.math.clockangle.impl;

import com.math.clockangle.model.calc.AngleCalc;
import com.math.clockangle.model.calc.ClockAngle;
import com.math.clockangle.model.calc.ClockCheck;
import com.math.clockangle.model.clock.Angle;
import com.math.clockangle.model.clock.Clock;

public class ClockAngleImpl implements ClockAngle{
	
	private Clock clock;
	private ClockCheck clockCheck;
	private AngleCalc angleCalc;
	
	
	public Angle getClockAngle(String hour, String minute){
		
		clockCheck = new ClockCheckImpl();
			
		//Validate if parameters was correctly informed
		if(!clockCheck.isValidTimeNumber(hour, minute) || !clockCheck.isValidTimeClock(Integer.parseInt(hour), Integer.parseInt(minute))){
			
			return null;
			
		}else{
			
			angleCalc = new AngleCalcImpl();
			
			//Set Clock and calculate the angle between hands of clock 
			clock = new Clock();
			clock.setHour(Integer.parseInt(hour));
			clock.setMinute(Integer.parseInt(minute));
			
			return angleCalc.calculateAngle(clock);
			
		}		
	}	
	
}
