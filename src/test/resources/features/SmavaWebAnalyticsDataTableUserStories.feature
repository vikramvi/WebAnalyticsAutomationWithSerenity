Feature: Smava Home Page User Stories

Scenario: User verifies GTM objects on Smava Home Page
  Given User is on smava home page
  When  User checks for GMT with datatable
        |affiliateChannel     | NA      |
        |channel              | smava intern |
  Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Kredit Page
  Given User is on Smava Registration Route Kredit Page
  When  User checks Kredit page for GMT with datatable
        |pageId               | CreditSelection      |
  Then User verifies values of GTM on each of the pages

Scenario: User verifies GTM objects on Smava Registration Route Person Step1 Page
  Given User is on Smava Registration Route Person Step1 Page
  When  User checks Person Step1 for GMT with datatable
    |pageId               | ContactInfo      |
  Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Person Step2 Page
  Given User is on Smava Registration Route Person Step2 Page
  When  User checks Person Step2 page for GMT with datatable
    |pageId               | Address2      |
  Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step1 Page
  Given User is on Smava Registration Route Einkommen Step1 Page
  When  User checks Einkommen Step1 page for GMT with datatable
    |pageId               | Employment      |
  Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step2 Page
  Given User is on Smava Registration Route Einkommen Step2 Page
  When  User checks Einkommen Step2 page for GMT with datatable
    |pageId               | IncomeExpenses      |
  Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Angebote Vergleichen Page
  Given User is on Smava Registration Route Angebote Vergleichen Page
  When  User checks Angebote Vergleichen page for GMT with datatable
    |pageId               | RdiAccount      |
  Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Offer Page
  Given User is on Smava Offer Page
  When  User checks offer page for GMT with datatable
        |pageId                         | NextSteps      |
        |requested_amount               | 500      |
        |requested_duration             | 84      |
        |requested_category             | 888      |
        |event                          | next_steps      |
        |flow                           | Fred      |
        |marketingPartnerName           | smava GmbH      |
        |firstMarketingPartnerName      | smava GmbH      |
  Then  User verifies values of GTM on each of the pages

