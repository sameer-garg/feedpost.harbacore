# Feedpost.harbacore
A completely **DYNAMIC FEED** page that lists the latest posts added. 
<br>
Backed by the latest **NO-SQL Google Cloud FIRESTORE** Database, all compiled within a decent **Spring MVC Gradle Java** Project Structure.
<br>
PS: I used **Java-8**. You can choose Java-11 or Java-14, either one would work just fine.
<br>
The Frontend is completely **RESPONSIVE** with the help of **BOOTSTRAP-4 HTMLand CSS**,  with the templates handled by **THYMELEAF**.
<br>
I prefer **Intellij Idea** as the IDE.


## Url's and ports
- To view the **FEED** page just direct to [localhost:8080/listfeed](http://localhost:8080/listfeed) .
- If you wanna **ADD** a new post yourself just visit [localhost:8080/addpost](http://localhost:8080/addpost) .


## Project Structure
![Image of Project Structure](https://github.com/sameer-garg/feedpost.harbacore/blob/master/src/main/resources/static/images/Screenshot%20(190).png)


## Setup
This was the most crucial and hectic part for me.

`Spring Dependencies`
<br>
**HEADS UP!! DO NOT MESS THIS** This is [my Gradle build-script](https://github.com/sameer-garg/feedpost.harbacore/blob/master/build.gradle) for reference.

`Firestore Integration`
<br>
Integrating Firestore is quite easy if you are using the service account of **FIREBASE**.
[This](https://firebase.google.com/docs/firestore/quickstart) is the documentation I followed.
- PS: I used the GOOGLE_APLICATION_CREDENTIALS system variable method.
- As of the coding part, its all there in my [Firestore Initializer](https://github.com/sameer-garg/feedpost.harbacore/blob/master/src/main/java/com/form/form_submission/FirestoreInitializer.java) file.
- Also  do not forget to save the name of the project in your application.properties file. 

`Thymeleaf` 
<br>
Just in case you aren't familiar with the syntax and all of Thymeleaf( i wasn't too) follow [this right here](https://www.thymeleaf.org/). 

`Running the project`
<br>
Just scroll into your project root directory and type- gradlew bootrun.


# **And There You Have It**
