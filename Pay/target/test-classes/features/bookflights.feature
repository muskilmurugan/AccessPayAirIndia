@MyFlightsbooking
Feature: Open AirIndia website in Chrome browser and validate fields

@UserStory-1
Scenario: As a Customer, I would able to open AriIndia online porta to book my flights
Given Open browser and initialze the browser with driver
Given Navigate to "https://www.airindia.in" home page
Then Validate whether airindia home page landed sucessfully
Given Validate the default selected option is Round trip
When Customer selects round trip validate the selections
When Customer enters "London" and "Chennai"
When Customer enters "30/07/2021" and "25/08/2021"
Then Click on submit & close the browser