# Overview

I created this project initially to begin the process of being able to develop Android apps, and I wanted to start by creating a relatively simple, yet useful, shopping list app.

In this app, I wrote a class, 5 unique functions, and a main function to handle all of the app functions.

## Item Class
This is a pretty simple class with some self-explanatory variables and a display method to display its name and ID in list format, with an empty square or check mark to indicate whether or not the item has been obtained.
There is also a companion object to automatically create an incrementing ID for every new instance of the Item class.

## Display, Add/Remove, Check Off Functions
There are functions to display the shopping list, add and remove items based on user input, remove ALL checked off items, and check off items based on ID
The displayShopping list function does a little more than JUST list the items, however. When using the program, you'll notice that a store can be specified as to where to shop for said item. When displaying the whole shopping list, the function will group each item based on which store they can be obtained from. This helps organize the list somewhat.

[Software Demo Video](https://youtu.be/eSMKndW8uaA)

# Development Environment

For the development of this software, I used Intellij Idea and the Java Development Kit

The language used was Kotlin

# Useful Websites

- [Programiz Kotlin Tutorial](https://www.programiz.com/kotlin-programming/class-objects)

# Future Work

- Add ability to add/delete multiple items at a time
- Add ability to check off multiple items without going back into the menu
- Add multiple shopping lists and write to / read from a text file
- Convert to an Android app
