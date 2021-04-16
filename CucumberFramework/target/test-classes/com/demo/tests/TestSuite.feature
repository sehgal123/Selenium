@FlightBooking
Feature: Book a flight

@BookFlight
Scenario Outline: Verify if user is able to book flight successfully
	Given User is on Blaze demo application home page
	When User Find the flight "<From>" "<To>"
	And Select the Flight
	And Enter the Details "<Name>" "<Address>" "<City>" "<State>" "<ZipCode>" "<CardType>" "<CardNum>" "<Month>" "<Year>" "<CardName>"  To Book the Flight 
	And Click on Book Flight Button
	Then Flight should book successfully and Flight Id should Generated


Examples:
	|From	|To			|Name	|Address	|City	|State	|ZipCode	|CardType	|CardNum	|Month	|Year	|CardName|
	|Boston	|London		|ABCD	|ABC Lane	|Test	|Demo	|123456		|Visa		|1234567890	|9		|2022	|ABCD	 |
#	|Boston	|London		|ABCD	|ABC Lane	|Tester	|Demoer	|123432		|Visa		|1234567432	|5		|2023	|ABCDE	 |