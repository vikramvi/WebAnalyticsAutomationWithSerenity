######  Pre-requistic:

1. Download latest [ chromedriver ]( https://sites.google.com/a/chromium.org/chromedriver/downloads ) and put under directory */usr/local/bin* on Mac OS


###### Additional Info:

1. Project makes use of [**Serenity**]( https://github.com/serenity-bdd/serenity-core ) framework

2. Execute command **mvn clean verify** to execute script from command line

3. Consolidated report can be found under  **/target/site/serenity/index.html**

4. Test Cases are automated using **BDD** approach with help of **Cucumber** & **Selenium**

5. *PageObject* & *PageFactory* design patterns are used to keep code DRY

6. 3 Amigos; first discusses, clarify & write down user stories to be developed,tested & automated under xxx.feature files, which is located under */resources/features/*


###### How To Run:

1. mvn clean verify -Dcucumber.options="src/test/resources/features/SmavaWebAnalyticsUserStories.feature"

   This will run **single user story** which executes whole of registration route to check analytics on each of the pages 

2. mvn clean verify -Dcucumber.options="src/test/resources/features/SmavaWebAnalyticsDataTableUserStories.feature"

   This will run **individual use story** for each of the pages under registration route with data table
      
3. **Docker container** run

   mvn clean verify -Dcucumber.options="src/test/resources/features/SmavaWebAnalyticsDataTableUserStories.feature" -Dwebdriver.remote.url=http://0.0.0.0:4444/wd/hub -Dwebdriver.remote.os=LINUX 
   
4. __Block 3rd Party Cookies__

   mvn -e clean install -Dcucumber.options="src/test/resources/features/SmavaWebAnalyticsDataTableUserStories.feature" -Dchrome_preferences.profile.block_third_party_cookies="true"

5. __Block all Cookies__

   mvn -e clean install -Dcucumber.options="src/test/resources/features/SmavaWebAnalyticsDataTableUserStories.feature" -Dchrome_preferences.profile.block_third_party_cookies="true" -Dchrome_preferences.profile.default_content_setting_values.cookies=2

     