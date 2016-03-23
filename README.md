# dropwizardtutorial
Tutorial to show the basics of 

## George

This is what you need to do George:

1.  You need to implement the verify method:
  Have a look at the RegisterMinionResource methods.  Follow the logic for registration by implementing the verification method
  and the registration method.
2. Implemement the registration method.  You can decide whether you want to use memory or any other persistance (database).
3. You need to think about how to implement the Unit tests.  Start to think about what tests not (__how__) would be needed
to validate your implementation


A valid message would be calling http://localhost:8080/register with a body of:
{ "name" : "george", "id":"123", "location" : "auckland" }


