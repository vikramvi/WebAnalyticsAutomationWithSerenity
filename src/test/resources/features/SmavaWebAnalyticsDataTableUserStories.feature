Feature: Smava Web Analaytics User Stories
         As marketing team spends loads of money on advertisement
         They would like to track users' actions post marketing campaign
         Developer, QA and Analytics team should religiously maintain Web Analytics


Scenario: User verifies GTM objects on Smava Home Page
          Given User is on smava home page
          When  User checks SmavaHomePage for GTM objects key value pair with datatable
                |   affiliateChannel   |      NA               |
                |   channel            |    smava intern       |
                |   embedded           |          0            |
                |   event              | smavaWonderland       |
                |   event              | CreditComparisonRoute |
                |   flow               | Comparison            |
                |   site_title         | smava Kreditvergleich |
          And User checks CreditComparisonRoute event on SmavaHomePage for non empty GTM objects from datatable
                |  channel             |
                |  embedded            |
                |  flow                |
                |  gtm.uniqueEventId   |
                |  marketingPartnerName|
                |  requested_amount    |
                |  site_title          |
                |  timestamp           |
                |  userRole            |
          And User checks ordering of events getting fired
                | smavaWonderland | gtm.js |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Kredit Page
          Given User is on Smava Registration Route Kredit Page
          When  User checks SmavaKreditPage for GTM objects key value pair with datatable
                |   pageId            |   CreditSelection       |
                |   event             |   registration_started  |
                |   event             |   registration_page     |
                |   flow              |         V1              |
                |   pageNo            |          1              |
                |   pageTitle         |       Kredit            |
                | requested_amount    |         500             |
                | requested_category  |         888             |
                | requested_duration  |         84              |
          And User checks registration_started event on SmavaKreditPage for non empty GTM objects from datatable
                |   event             |
                |   flow              |
                |   gtm.uniqueEventId |
          And User checks registration_page event on SmavaKreditPage for non empty GTM objects from datatable
                |  affiliateId            |
                |  channel                |
                |  event                  |
                |  flow                   |
                |  gtm.uniqueEventId      |
                |  marketingPartnerName   |
                |  pageId                 |
                |  pageNo                 |
                |  pageTitle              |
                |  placementId            |
                |  requested_amount       |
                |  requested_category     |
                |  requested_duration     |
                |  subAffiliateId         |
                |  timestamp              |
                |  userRole               |
          And User checks ordering of events getting fired
                | smavaWonderland | gtm.js |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Person Step1 Page
          Given User is on Smava Registration Route Person Step1 Page
          When  User checks SmavaPersonStep1Page for GTM objects key value pair with datatable
                |   pageId            |     ContactInfo       |
                |   event             |   registration_page   |
                |   flow              |       V1              |
                |   pageNo            |        2              |
                |   pageTitle         |      Person           |
                | requested_amount    |      500              |
                | requested_duration  |      84               |
                | requested_category  |      888              |
          And   User checks registration_page event on SmavaPersonStep1Page for non empty GTM objects from datatable
                |   affiliateId            |
                |   channel                |
                |   flow                   |
                |   gtm.uniqueEventId      |
                |   marketingPartnerName   |
                |   pageId                 |
                |   pageNo                 |
                |   pageTitle              |
                |   subAffiliateId         |
                |   placementId            |
                |   userRole               |
                |   timestamp              |
                |   requested_amount       |
                |   requested_category     |
                |   requested_duration     |
                |   flow                   |
          Then User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Person Step2 Page
          Given User is on Smava Registration Route Person Step2 Page
          When  User checks SmavaPersonStep2Page for GTM objects key value pair with datatable
                |   event             |     account_created     |
                |   event             |     Lead                |
                |   event             |   registration_page     |
                |   flow              |       V1                |
                |   pageId            |     Address2            |
                |   pageNo            |        3                |
                |   pageTitle         |      Person             |
                | requested_amount    |      500                |
                | requested_duration  |      84                 |
                | requested_category  |      888                |
                | leadCycleState      | APPLICATION_INCOMPLETE  |
          And   User checks registration_page event on SmavaPersonStep2Page for non empty GTM objects from datatable
                |   affiliateId              |
                |   channel                  |
                |   event                    |
                |   flow                     |
                |   gtm.uniqueEventId        |
                |   marketingPartnerName     |
                |   pageId                   |
                |   pageNo                   |
                |   pageTitle                |
                |   placementId              |
                |   requested_amount         |
                |   requested_category       |
                |   requested_duration       |
                |   subAffiliateId           |
                |   userRole                 |
                |   timestamp                |
          And User checks account_created event on SmavaPersonStep2Page for non empty GTM objects from datatable
                |   accountId                   |
                |   affiliateId                 |
                |   channel                     |
                |   currentLoanApplicationId    |
                |   event                       |
                |   flow                        |
                |   gtm.uniqueEventId           |
                |   leadCycleLastTouchpoint     |
                |   leadCycleLoanApplicationId  |
                |   leadCycleState              |
                |   marketingPartnerName        |
                |   pageNo                      |
                |   pageTitle                   |
                |   placementId                 |
                |   requested_amount            |
                |   requested_category          |
                |   requested_duration          |
                |   subaffiliateId              |
                |   timestamp                   |
                |   userRole                    |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step1 Page
          Given User is on Smava Registration Route Einkommen Step1 Page
          When  User checks SmavaEinkommenStep1Page for GTM objects key value pair with datatable
                |   event             |   registration_page   |
                |   flow              |       V1              |
                |   pageId            |     Employment        |
                |   pageNo            |        4              |
                |   pageTitle         |      Einkommen        |
                | requested_amount    |      500              |
                | requested_duration  |      84               |
                | requested_category  |      888              |
          And   User checks registration_page event on SmavaEinkommenStep1Page for non empty GTM objects from datatable
                |   affiliateId            |
                |   channel                |
                |   event                  |
                |   flow                   |
                |   gtm.uniqueEventId      |
                |   marketingPartnerName   |
                |   pageId                 |
                |   pageNo                 |
                |   pageTitle              |
                |   placementId            |
                |   requested_amount       |
                |   requested_category     |
                |   requested_duration     |
                |   subAffiliateId         |
                |   placementId            |
                |   timestamp              |
                |   userRole               |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Einkommen Step2 Page
          Given User is on Smava Registration Route Einkommen Step2 Page
          When  User checks SmavaEinkommenStep2Page for GTM objects key value pair with datatable
                |   event             |   registration_page   |
                |   flow              |       V1              |
                |   pageId            |   IncomeExpenses      |
                |   pageNo            |        5              |
                |   pageTitle         |      Einkommen        |
                | requested_amount    |      500              |
                | requested_duration  |      84               |
                | requested_category  |      888              |
          And   User checks registration_page event on SmavaEinkommenStep2Page for non empty GTM objects from datatable
                |   affiliateId            |
                |   channel                |
                |   event                  |
                |   flow                   |
                |   gtm.uniqueEventId      |
                |   marketingPartnerName   |
                |   pageId                 |
                |   pageNo                 |
                |   pageTitle              |
                |   placementId            |
                |   requested_amount       |
                |   requested_category     |
                |   requested_duration     |
                |   subAffiliateId         |
                |   placementId            |
                |   timestamp              |
                |   userRole               |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Registration Route Angebote Vergleichen Page
          Given User is on Smava Registration Route Angebote Vergleichen Page
          When  User checks SmavaAngeboteVergleichenPage for GTM objects key value pair with datatable
                |   event             |   registration_page     |
                |   flow              |       V1                |
                |   pageId            |   RdiAccount            |
                |   pageNo            |        6                |
                |   pageTitle         |   Angebote vergleichen  |
                | requested_amount    |      500                |
                | requested_duration  |      84                 |
                | requested_category  |      888                |
          And   User checks registration_page event on SmavaAngeboteVergleichenPage for non empty GTM objects from datatable
                |   affiliateId            |
                |   channel                |
                |   event                  |
                |   flow                   |
                |   gtm.uniqueEventId      |
                |   marketingPartnerName   |
                |   pageId                 |
                |   pageNo                 |
                |   pageTitle              |
                |   placementId            |
                |   requested_amount       |
                |   requested_category     |
                |   requested_duration     |
                |   subAffiliateId         |
                |   placementId            |
                |   timestamp              |
                |   userRole               |
          Then  User verifies values of GTM on each of the pages


Scenario: User verifies GTM objects on Smava Offer Page
          Given User is on Smava Offer Page
          When  User checks SmavaOfferPage for GTM objects key value pair with datatable
                |   pageId                      |  NextSteps                 |
                |   requested_amount            |  500                       |
                |   requested_duration          |  84                        |
                |   requested_category          |  888                       |
                |   event                       |  next_steps                |
                |   event                       |  lead_tracked              |
                |   event                       |  Final_Lead                |
                |   flow                        |  Fred                      |
                |   marketingPartnerName        |  smava GmbH                |
                |   firstMarketingPartnerName   |  smava GmbH                |
                |   isLeadExpired               |  false                     |
                |   pageId                      |  NextSteps                 |
                |   pageNo                      |      7                     |
                |   pageTitle                   | smava - Ihr Kreditangebot  |
          And   User checks registration_page event on SmavaOfferPage for non empty GTM objects from datatable
                |   affiliateId                 |
                |   channel                     |
                |   event                       |
                |   flow                        |
                |   gtm.uniqueEventId           |
                |   marketingPartnerName        |
                |   pageId                      |
                |   pageNo                      |
                |   pageTitle                   |
                |   placementId                 |
                |   requested_amount            |
                |   requested_category          |
                |   requested_duration          |
                |   subAffiliateId              |
                |   timestamp                   |
                |   userRole                    |
          And   User checks next_steps event on SmavaOfferPage for non empty GTM objects from datatable
                |   accountId                   |
                |   accountIdLong               |
                |   affiliateId                 |
                |   currentLoanApplicationId    |
                |   event                       |
                |   firstAffiliateId            |
                |   firstMarketingPartnerName   |
                |   firstPlacementId            |
                |   firstSubAffiliateId         |
                |   flow                        |
                |   gtm.uniqueEventId           |
                |   leadCycleLastTouchpoint     |
                |   leadCycleLoanApplicationId  |
                |   marketingPartnerName        |
                |   placementId                 |
                |   subAffiliateId              |
                |   timestamp                   |
                |   timestamp_readable          |
          And   User checks lead_tracked event on SmavaOfferPage for non empty GTM objects from datatable
                |   accountId                   |
                |   affiliateId                 |
                |   currentLoanApplicationId    |
                |   event                       |
                |   firstAffiliateId            |
                |   firstMarketingPartnerName   |
                |   firstPlacementId            |
                |   firstSubAffiliateId         |
                |   flow                        |
                |   gtm.uniqueEventId           |
                |   isLeadExpired               |
                |   leadCycleLastTouchpoint     |
                |   leadCycleLoanApplicationId  |
                |   marketingPartnerName        |
                |   placementId                 |
                |   subAffiliateId              |
                |   timestamp_readable          |
          And User checks ordering of events getting fired
                | smavaWonderland | gtm.js |
          Then  User verifies values of GTM on each of the pages

Scenario: User checks flow key value on smava registration flow pages
          Given User is on smava home page
          When  User verifies GTM Objects key value pair on each of the registration route pages
                |   flow              |         V1              |
          Then  User verifies values of GTM on each of the pages

Scenario: User verifies GTM objects on Smava Registration Route Person Step2 Page For Already Recognized User
          Given User goes to Smava Registration Route Person Step2 Page Using Existing EmailId
          When  User checks SmavaPersonStep2Page for GTM objects key value pair with datatable
                |   event             |     account_created     |
                |   event             |     Lead                |
                |   event             |   registration_page     |
                |   flow              |       V1                |
                |   pageId            |     Address2            |
                |   pageNo            |        3                |
                |   pageTitle         |      Person             |
                | requested_amount    |      500                |
                | requested_duration  |      84                 |
                | requested_category  |      888                |
                | leadCycleState      | APPLICATION_INCOMPLETE  |
          And User closes browser
          And User goes to Smava Registration Route Person Step2 Page Using Existing EmailId
          And User checks user_recognized event on SmavaPersonStep2Page for non empty GTM objects from datatable
                |  accountId                   |
                |  affiliateId                 |
                |  channel                     |
                |  currentLoanApplicationId    |
                |  event                       |
                |  flow                        |
                |  gtm.uniqueEventId           |
                |  leadCycleLastTouchpoint     |
                |  leadCycleLoanApplicationId  |
                |  leadCycleState              |
                |  marketingPartnerName        |
                |  pageNo                      |
                |  pageTitle                   |
                |  placementId                 |
                |  requested_amount            |
                |  requested_category          |
                |  requested_duration          |
                |  subaffiliateId              |
                |  timestamp                   |
                |  userRole                    |
          And User checks SmavaPersonStep2Page for GTM objects key value pair with datatable
                |  event            |  user_recognized        |
                |  event            |  no_new_lead            |
                |  event            |  registration_page      |
                |  leadCycleState   |  APPLICATION_INCOMPLETE |
          And User checks SmavaPersonStep2Page for GTM objects does not have key entry
                |  event            |  account_created        |
          Then User verifies values of GTM on each of the pages