######  Pre-requistic:

1. Download latest [ chromedriver ]( https://sites.google.com/a/chromium.org/chromedriver/downloads ) and put under directory */usr/local/bin* on Mac OS


###### Additional Info:

1. Project makes use of [**Serenity**]( https://github.com/serenity-bdd/serenity-core ) framework

2. Execute command **mvn clean verify** to execute script from command line

3. Consolidated report can be found under  **/target/site/serenity/index.html**

4. Test Cases are automated using **BDD** approach with help of **Cucumber** & **Selenium**

5. *PageObject* & *PageFactory* design patterns are used to keep code DRY

6. 3 Amigos; first discusses, clarify & write down user stories to be developed,tested & automated under xxx.feature files, which is located under */resources/features/*