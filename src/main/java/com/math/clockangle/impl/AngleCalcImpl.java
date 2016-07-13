package com.math.clockangle.impl;

import com.math.clockangle.model.clock.Clock;


import com.math.clockangle.model.calc.AngleCalc;
import com.math.clockangle.model.clock.Angle;


public class AngleCalcImpl implements AngleCalc {
	
	private Angle angle;
		
	public Angle calculateAngle(Clock clock) {
		
		angle = new Angle();
		
		//Calculing hour hand angle - moves 0.5 degrees per minute
		double hourAngle = 0.5 * (clock.getHour() * 60 + clock.getMinute());
		
		//Calculating minut hand angle - moves 6 degrees per minute
		double minAngle = 6 * clock.getMinute();
		
		//Calculating difference between angles
		double angleCalc = Math.abs(hourAngle - minAngle);
		
		//Choosing minimum angle
		angle.setAngle(Math.min(angleCalc, 360-angleCalc));
				
		return angle;
	}	
	

}
