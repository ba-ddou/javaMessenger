# Java messenger

# Requirements

-   JDK
-   maven

# Running the app

## clone the repository

Clone the code repository on you machine using GIT CLI or just download it.

```
> git clone https://github.com/ba-ddou/javaMessenger
```

## install dependencies

If maven is installed on your machine you should have access to the mvn command.\
running this command installs all the dependencies defined in the ./pom.xml file

```
> cd javaMessenger
> mvn install
```

## Run the app

The application's entry file is `./src/main/java/dp/App.java`

running the app is as easy as running this file using the command line or your favorite IDE.

# Using the app

## login credential

There's no signup workflow in the app.\
To use the app you need to login using one of these 3 predefined user accounts:

```
[
	{
		"username": "badou",
		"password": "root"
	},
	{
		"username": "lamyaa",
		"password": "root"
	},
	{
		"username": "mohammed",
		"password": "root"
	}
]
```

# Rest API

All messages sent using this app are ephemeral, and are routed through a primitive Rest api written using node.js ( only used for testing purposes ).\
Authentication is also handled by this api.\
This api is already deployed on Heroku, and the App is already integrated with it, so it should work online by default.\

The code source for this API can be found here: https://github.com/ba-ddou/javaMessengerJsonApi
