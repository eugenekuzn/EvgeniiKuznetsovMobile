##Create _secure.properties_ in **test\resources\properties** with your current API key.  You should call value as **api_key**

##If you going to run:
  - **Apple Native Cloud Test**, you need:
          1. Make sure you have EPAMTestApp.ipa on test device
          2. Add **deviceName\udid** of your testing device in _cloudNativeApple.xml_ or use current values
          3. Run _mvn test -P cloudNativeApple_ in terminal
  
  - **Android Native Cloud Test**, you need:
          1. Make sure you have EPAMTestApp.apk on test device
          2. Add **deviceName\udid** of your testing device in _cloudNativeAndroid.xml_ or use current values
          3. Run _mvn test -P cloudNativeAndroid_ in terminal
  
  - **Apple Web Cloud Test**, you need:
          1. Add **deviceName\udid** of your testing device in _cloudWebApple.xml_ or use current values
          2. Run _mvn test -P cloudWebApple_ in terminal
   
  - **Android Web Cloud Test**, you need:
          1. Add **deviceName\udid** of your testing device in _cloudWebAndroid.xml_ or use current values
          2. Run _mvn test -P cloudWebAndroid_ in terminal
  
