Feature: login



  Scenario: Login user
    When Main page is displayed
    Then click btn SigIn
    Then sign in modal is displayed
    Then edit login "azimovqobil72@gmail.com" and password "Qa13081995@"
    When click button SigIn
    Then Personal page is displayed