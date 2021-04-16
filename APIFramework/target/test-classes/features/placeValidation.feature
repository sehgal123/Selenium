@placeValidation
Feature: Validating Place APIs

@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given AddPlace API Payload with "<name>" "<language>" and "<address>"
	When User calls "addPlaceAPI" with "Post" HTTP request
	Then API call is success with Status code 200
	And "status" in response is "OK"
	And "scope" in response is "APP"
	And Verify place_id created is maps to "<name>" using "getPlaceAPI" 
	
Examples:
	|name		|language	|address|
	|MyHouse	|English	|India	|
#	|YourHouse	|Hindi		|France	|

@DeletePlace
Scenario: Verify Deleta place functionality is working
	Given DeletePlace API payload
	When User calls "deletePlaceAPI" with "Post" HTTP request
	Then API call is success with Status code 200
	And "status" in response is "OK" 

@TestTag
Scenario: Test tag for Hooks
	Given Test API Give
	When Test API Wen
	Then Test API Ten
	