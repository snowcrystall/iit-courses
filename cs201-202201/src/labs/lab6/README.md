# Lab 6 - Lists

## 03/21/2022

## Objectives

1. Learn to write and use an ArrayList declaration
2. Learn to manipulate the data in an ArrayList

## Exercise

In this assignment, you will create an application that handles a queue at a deli counter. You will allow customers to join the queue and deli workers to remove customers from the queue.

## Solution

The solution is to create a single application class that presents a repeating menu with the following 3 options:

```
1. Add customer to queue
2. Help customer
3. Exit
```

This requires you to create an ArrayList to be passed around to the various methods needed for the menu options. What those methods are and how your class is laid out, is entirely up to you, however, it should be well designed. To be well designed, the class should _not_ be one single, massive `main` method. Minimally, this means having separate methods for each menu option, but feel free to add more.

### Add Customer to Queue

This menu option should prompt the user for a name (`String`) to be added to the end of an ArrayList of customers and returns the customers position in the queue.

### Help customer

This should remove the customer from the front of the queue (position 0) and prints out that customers name.

### Exit

This exits the program.
