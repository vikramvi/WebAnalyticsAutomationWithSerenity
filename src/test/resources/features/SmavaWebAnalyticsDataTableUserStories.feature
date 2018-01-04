Feature: Smava Web Analaytics User Stories
         As marketing team spends loads of money on advertisement
         They would like to track users' actions post marketing campaign
         Developer, QA and Analytics team should religiously maintain Web Analytics


Scenario: User verifies GTM objects on Smava Home Page
          Given User is on smava home page
          When  User verifies home page GTM objects key value pair with datatable
                |   affiliateChannel   |      NA               |
                |   channel            |    smava intern       |
                |   embedded           |          0            |
                |   event              | smavaWonderland       |
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
          And   User checks Kredit page for non empty GTM objects from datatable
                | affiliateChannel       |
                | affiliateId            |
                | channel                |
                | embedded               |
                | marketingPartnerName   |
                | startSeoPlacement      |
                | subAffiliateId         |
                | placementId            |
                | tokenId                |
                | userRole               |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Person Step1 Page
          Given User is on Smava Registration Route Person Step1 Page
          When  User checks Person Step1 for GTM with datatable
                |   pageId            |     ContactInfo       |
                |   event             |   registration_page   |
                |   flow              |       V1              |
                |   pageNo            |        2          |
                |   pageTitle         |      Person       |
                | requested_amount    |      500          |
                | requested_duration  |      84           |
                | requested_category  |      888          |
          And   User checks Person Step1 page for non empty GTM objects from datatable
                | affiliateId            |
                | channel                |
                | marketingPartnerName   |
                | subAffiliateId         |
                | placementId            |
                | userRole               |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Person Step2 Page
          Given User is on Smava Registration Route Person Step2 Page
          When  User checks Person Step2 page for GTM with datatable
                |   event             |     Lead              |
                |   event             |   registration_page   |
                |   flow              |       V1              |
                |   pageId            |     Address2      |
                |   pageNo            |        3          |
                |   pageTitle         |      Person       |
          And   User checks Person Step2 page for non empty GTM objects from datatable
                | affiliateId            |
                | channel                |
                | marketingPartnerName   |
                | subAffiliateId         |
                | placementId            |
                | userRole               |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step1 Page
          Given User is on Smava Registration Route Einkommen Step1 Page
          When  User checks Einkommen Step1 page for GTM with datatable
                |   event             |   registration_page   |
                |   flow              |       V1              |
                |   pageId            |     Employment        |
                |   pageNo            |        4              |
                |   pageTitle         |      Einkommen        |
          And   User checks Einkommen Step1 page for non empty GTM objects from datatable
                | affiliateId            |
                | channel                |
                | marketingPartnerName   |
                | subAffiliateId         |
                | placementId            |
                | userRole               |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step2 Page
          Given User is on Smava Registration Route Einkommen Step2 Page
          When  User checks Einkommen Step2 page for GTM with datatable
                |   event             |   registration_page   |
                |   flow              |       V1              |
                |   pageId            |   IncomeExpenses      |
                |   pageNo            |        5              |
                |   pageTitle         |      Einkommen        |
          And   User checks Einkommen Step2 page for non empty GTM objects from datatable
                | affiliateId            |
                | channel                |
                | marketingPartnerName   |
                | subAffiliateId         |
                | placementId            |
                | userRole               |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Angebote Vergleichen Page
          Given User is on Smava Registration Route Angebote Vergleichen Page
          When  User checks Angebote Vergleichen page for GTM with datatable
                |   event             |   registration_page     |
                |   flow              |       V1                |
                |   pageId            |   RdiAccount            |
                |   pageNo            |        6                |
                |   pageTitle         |   Angebote vergleichen  |
          And   User checks Angebote Vergleichen page for non empty GTM objects from datatable
                | affiliateId            |
                | channel                |
                | marketingPartnerName   |
                | subAffiliateId         |
                | placementId            |
                | userRole               |
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

