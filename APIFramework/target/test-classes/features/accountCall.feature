@accountCall
Feature: Account Call Creation

Scenario Outline: Verify that Sales Rep is able to record calls
	Given User is on Login page of Salesforce application
	When User enters "<Username>" and "<Password>" and login to application
	And Search for the "<AccountName>"
	And Click on the Record a Call button
	And Enters the required fields in call record form
	And Add the "<Attendee1>" and "<Attendee2>" in Attendees section
	And Select the "<Product>" in Product Section
	Then Click on Save button and Submit the form
	And Verify that Call is created successfully 

Examples:
	|Username	|Password	|AccountName	|Attendee1		|Attendee2		|Product	|
	|TestUser	|UserPass	|TestAccount	|TestAttendee1	|TestAttendee2	|TestProduct|
	|TestUser1	|UserPass1	|TestAccount1	|TestAttendee11	|TestAttendee21	|TestProduct1|
			 