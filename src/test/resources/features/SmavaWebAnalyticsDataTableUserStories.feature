Feature: Smava Web Analaytics User Stories
         As marketing team spends loads of money on advertisement
         They would like to track users' actions post marketing campaign
         Developer, QA and Analytics team should religiously maintain Web Analytics


Scenario: User verifies GTM objects on Smava Home Page
          Given User is on smava home page
          When  User verifies home page GTM objects key value pair with datatable
                |   affiliateChannel   | NA      |
                |   channel            | smava intern |
                |   embedded           | 0        |
                |   event              | smavaWonderland |
                |   event              | CreditComparisonRoute |
                |   flow               | Comparison            |
                |   site_title         | smava Kreditvergleich |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Kredit Page
          Given User is on Smava Registration Route Kredit Page
          When  User checks Kredit page for GTM with datatable
                |   pageId      |   CreditSelection       |
                |   event       |   registration_started  |
                |   event       |   registration_page     |
                |   flow        |       V1                |
                |   pageNo      |        1                |
                |   pageTitle   |       Kredit            |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Person Step1 Page
          Given User is on Smava Registration Route Person Step1 Page
          When  User checks Person Step1 for GTM with datatable
                |pageId               | ContactInfo      |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Person Step2 Page
          Given User is on Smava Registration Route Person Step2 Page
          When  User checks Person Step2 page for GTM with datatable
               |pageId               | Address2      |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step1 Page
          Given User is on Smava Registration Route Einkommen Step1 Page
          When  User checks Einkommen Step1 page for GTM with datatable
                |pageId               | Employment      |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step2 Page
          Given User is on Smava Registration Route Einkommen Step2 Page
          When  User checks Einkommen Step2 page for GTM with datatable
                |pageId               | IncomeExpenses      |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Angebote Vergleichen Page
          Given User is on Smava Registration Route Angebote Vergleichen Page
          When  User checks Angebote Vergleichen page for GTM with datatable
                |pageId               | RdiAccount      |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Offer Page
          Given User is on Smava Offer Page
          When  User verifies offer page GTM objects key value pair from datatable
                | pageId                         | NextSteps      |
                | requested_amount               | 500            |
                | requested_duration             | 84             |
                | requested_category             | 888            |
                | event                          | next_steps     |
                | flow                           | Fred           |
                | marketingPartnerName           | smava GmbH     |
                | firstMarketingPartnerName      | smava GmbH     |
          And   User checks offer page for non empty GTM objects from datatable
                |   placementId  |
                |   accountId    |
                |   currentLoanApplicationId    |
                |   leadCycleLoanApplicationId  |
                |   leadCycleLastTouchpoint     |
          Then  User verifies values of GTM on each of the pages

