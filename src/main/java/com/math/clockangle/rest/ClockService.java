package com.math.clockangle.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.math.clockangle.impl.ClockAngleImpl;
import com.math.clockangle.model.calc.ClockAngle;
import com.math.clockangle.model.clock.Angle;
import com.math.clockangle.util.JsonUtil;


@Path("/clock")
public class ClockService {
	
	@GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
   	@Path("{hour:([a-zA-Z0-9]*)}{p:/?}{minute:([a-zA-Z0-9]*)}")
    public Response clock(@PathParam("hour") String hour, @PathParam("minute") String minute) {
		
		ResponseBuilder response;
		
		//When second parameter is not informed, it assumed 0 
		if(minute.equals("")){
			minute = "0";
		}
		
		//Caching response for 24h = 86400s, to not calculate again a same request
		CacheControl cc = new CacheControl();
		cc.setMaxAge(86400);
						
		//Validate the parameters and calculate the angle between hands of clock
		ClockAngle clockAngle = new ClockAngleImpl();
		Angle angle = clockAngle.getClockAngle(hour, minute);
		
		//If there is some problem with parameters, return BAD_REQUEST, if no, return the angle
		if(angle == null){
			response = Response.status(Response.Status.BAD_REQUEST).entity(JsonUtil.generateErrorJson("Invalid Hour or Minute."));
		}else{
			response = Response.ok(JsonUtil.generateAngleJson(angle.getAngle()));
		}
    	 
    	response.cacheControl(cc);
    	
    	return response.build();    	
    }	
	
}
