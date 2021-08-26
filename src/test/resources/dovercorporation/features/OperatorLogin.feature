Feature: OPERATOR LOGIN

  UniSecure as an Operator

  Background:
    Given QA environment of systechcloud

  @Regression
  Scenario: Valid Login for UniSecure as Operator
    When I login to UniSecure with my username "InterviewTest" and password "Systech1!" with login option as Operator
    Then I should be able to navigate to Welcome Page of Operator

  @Regression
  Scenario: InValid Login for UniSecure as Operator
    When I login to QA bible application with wrong username "xyzhh" and wrong password "sdsdhh" with login option as Operator
    Then I should be able to see the validation message for invalid login

  @Regression
  Scenario: Build number for Operator
    When I login to UniSecure with my username "InterviewTest" and password "Systech1!" with login option as Operator
    And I access About Us
    Then I should be able to view version and build number details

