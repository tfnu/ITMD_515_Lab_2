Triptu FNU Lab 2 Created the readme.md file

The Database
I chose a sample database "sakila" which is provided by MySQL as a sample database. I will be doing the Junit Testing with the "Film" table of this
"sakila" schema. Even though I am using the sample schema provided by the MySQL. I am using it with the user that I created and by giving the user all the
privileges on the "sakila" schema.
![image](https://user-images.githubusercontent.com/97912482/215567042-1b238c3a-0599-4a8a-987f-5e993631b165.png)

Scope of the Junit Test cases
I have kept the scope of the junit dependency to "test" as shown in the image pasted below, because if we don't do so, the default scope of
the dependency is "compile" which means this dependency will be package into the jar for the run time execution. This dependency is only required for
the testing purpose. Therefore it's scope "test" will indicate maven that this dependency wouldn't be required during the runtime of the application.
![image](https://user-images.githubusercontent.com/97912482/215560511-39a2c0a7-0744-4553-b611-1058d08374a9.png)

Unit Test Case #1

Not Allowing to instatiate an Object with a Future Date in the lastUpdate column of the Film. As the last update can't be a future date. It can be
either current or past date.
This test case is a negative scenario and it attached underneath is the proof that it failed for a future date.

![image](https://user-images.githubusercontent.com/97912482/215562406-01453be5-075d-442c-904a-8b69b0d7195f.png)

Image showing that an error message has been shown in the logs which was triggered by the annotation "@PastOrPresent";
![image](https://user-images.githubusercontent.com/97912482/215562912-c6095d45-c0bc-4195-b963-01100d06d4b0.png)

Unit Test Case #2

Testing for providing null values in the not null fields. In this scenario an object is being instantiated with null value for "filmId" field which has
a "@NotNull" annotation on it. So this instantiation will create a violation which is the criteria for our assertion of the test.

![image](https://user-images.githubusercontent.com/97912482/215565587-ae12219c-4b63-4df3-999e-15faf6c6a86e.png)

Unit Test Case #3, #4, #5, #6 i.e. All the CRUD Operations.
Screenshot showing that all the six test have passed with no Errors.

![image](https://user-images.githubusercontent.com/97912482/215568073-bfd5a247-fed8-4ad1-8182-ba25c92aa25c.png)

Screenshot of the Apache NetBeans running all the unit tests successfully.

![image](https://user-images.githubusercontent.com/97912482/215572273-7fdc2c37-d242-4133-8a00-527d088ec613.png)

Screenshot of running the project on the command line with maven installed on the windows.
![image](https://user-images.githubusercontent.com/97912482/215570727-b7ca3e05-6607-4b45-a789-1c1906e3e8b9.png)

Screenshot of running the tests using the command line with maven.
![image](https://user-images.githubusercontent.com/97912482/215570977-93c13076-ef1e-4444-9850-8d8f747cb58c.png)



