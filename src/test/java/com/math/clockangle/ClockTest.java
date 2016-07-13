package com.math.clockangle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.math.clockangle.impl.ClockAngleImpl;
import com.math.clockangle.model.calc.ClockAngle;
import com.math.clockangle.model.clock.Angle;
import com.math.clockangle.util.JsonUtil;


public class ClockTest {	
	
	private ClockAngle clockAngle;
	
	private String runTest (String hour, String minute){
		
		String returnTest; 
		
		Angle angle = clockAngle.getClockAngle(hour, minute);
		
		if(angle == null){
			returnTest = JsonUtil.generateErrorJson("Invalid Hour or Minute.");
		}else{
			returnTest = JsonUtil.generateAngleJson(angle.getAngle());
		}
		return returnTest;
	}
	
	@Before
	public void setup(){
		clockAngle = new ClockAngleImpl();
	}
	
	@Test
	public void testCalcAngle6(){		
						
		Assert.assertEquals("{\"angle\":180.0}", runTest("6", "0"));
		
	}
	
	@Test
	public void testCalcAngle3(){		
		
		Assert.assertEquals("{\"angle\":90.0}", runTest("3", "0"));
	}
	
	@Test
	public void testCalcAngle9(){		
		
		Assert.assertEquals("{\"angle\":90.0}", runTest("9", "0"));
	}
	
	@Test
	public void testCalcAngleInvalidHour(){
		
		Assert.assertEquals("{\"error\":\"Invalid Hour or Minute.\"}", runTest("32", "10"));
	}
	
	@Test
	public void testCalcAngleInvalidMinute(){
		
		Assert.assertEquals("{\"error\":\"Invalid Hour or Minute.\"}", runTest("7", "68"));
		
	}
}
