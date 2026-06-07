@Login
Feature: Login Functionality

  Scenario: Check login is un-successful with invalid credentials. Its is username not registered
    Given User has opened the browser
    And User has navigated on the login page Education Fund Payment Management System for Zaidan Educare School app
    When User enters username "indra" & password "admin123"
    And User clicks on login button
    Then User should be able to see "un-successful login" notification message "Username atau password salah" is displayed on screen
