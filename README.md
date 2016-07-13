#ClockAngle

A Rest application to calculate the minimum angle between hour hand and minute hand of an clock.

To build the project, you can run 
<code>mvn clean install</code>

To test the Clock Angle calculator, you can consume the Rest service by GET and pass the hour and minute parameters in URL:

Request Example: 
<code>
curl --request GET http://localhost:8080/rest/clock/6/0
</code>

Response: 
<code>
{"angle":180.0}
</code>