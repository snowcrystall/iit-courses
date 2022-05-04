# Final Project

## Background

For the past few weeks, we have been learning about objects, inheritance, polymorphism, and lists and using them to model various systems. For this project, you will use these concepts to design and implement a program that models a general store and allows users to add stock to the store, search for available stock, and sell items.

**Note**: While you are welcome to discuss this project with other students, all work must be entirely your own. This is an individual project, not a group project. Your code should not match that of another student.

## The Problem

You must create a program that models a general store and allows users to interact with the data it contains. How the system is designed is entirely up to you, but it must meet the following requirements.

### User Interface Requirements

1. Your program must allow a user to create a new items and add them to the stores stock. This should include the ability to add duplicates of the same item.
2. Your program must allow a user to sell items and remove them from the store. This should allow a user to add the item to a cart first before choosing to check out.
3. Your program must allow a user to search for an item in the store with a given name supplied by the user.
4. Your program must allow a user to modify items in the store (e.g. updating the price or name). These changes need to be applied to all instance of the item.
5. Your program must be able to exit when the user requests to finish.

The user should be continually prompted to choose between the above options and can exit the menu with the appropriate choice. The verification of each operation should be visible in the console. You may of course add additional menu options beyond the 5 specified here.

### Programming Requirements

- You should have **at least** 1 inheritance relationship.
- You should have **at least** 1 association relationship where the 'outer' class definition has an instance of another user-defined class.
- You should be able to have at least 1 over-ridden method that is **NOT** a usual instance method and **is unique** to your application (i.e. not `toString` or `equals`).
- You should be able to write data to the console **and** write data to an output file when requested by the user. For example, the user may wish to 'save' the current stock available.
- You should read and store an input file of data.
- Your data should be stored in an encapsulated list.
- You should be able to add, delete, modify, and search the data.
- Your user interface should be error-proof. (Your code should never quit with an error message!)

### Design Issues

- The entire project should be one package for ease of use. Specifically, it should be in the `project` package in your repository.
- Each class should be in a separate file named with unique names.
- Each class should have all usual instance methods, i.e. mutators, accessors, constructors, `toString`, and `equals`.
- Each class should **ONLY** have the necessary data members and the methods that manipulate these data members.
- Each method should have a specific task, **NOT** multiple tasks.
- Use the object-oriented language features to make your code more efficient (inheritance, association).
- You should have **MINIMAL** code in your main method and use additional methods in the application class to make the code easier to read.
- You should **NOT** have large blocks of code. In this case, "large blocks" would be anything over 100 lines for a single method.

### Implementation Issues

- Use descriptive names for all variables and methods
- Use appropriate programming conventions, i.e. correct naming and capitalization
- Use methods to break up large pieces of code into smaller, single focused tasks
- No data handling in main method. Your file operations should be handled by other methods
- Your file I/O needs to implement try/catches

### Documentation

- Each class should have documentation at the top describing the role of that class in the project, the author's name (you), and the date.
- All identifiers should be commented.
- Each method should have a brief (1 or 2 sentence) description of its tasks.

### Data Description

An example data file has been provided with an initial stock for your store to use. You are welcome to create your own file and structure, but you must have some data file. For the file provided, rows appear as one of three varieties:

#### Produce Item

Produce Items are fresh food that will expire if not sold. Items of this type have the following format which contains the item's name, price, and expiration date:

```csv
banana,0.62,04/29/2022
```

#### Shelved Item

Shelved Items are any item that are either shelf-stable food or non-food items. Items of this type have the following format which contains the item's name and price:

```csv
pencil,1.29
```

#### Age Restricted Item

Age Restricted Items are any item that has a restriction on purchasing it based on the age of the customer. Items of this type have the following format which contains the item's name, price, and the age restriction:

```csv
wine,12.99,21
```

## Phase I: Project Design

### 04/08/2022

1. Describe the user interface. What are the menu options and how will the user use the application?
2. Describe the programmers' tasks:

    - Describe how you will read the input file.
    - Describe how you will process the data from the input file.
    - Describe how you will store the data (what objects will you store?)
    - How will you add/delete/modify data?
    - How will you search the data?
    - List the classes you will need to implement your application.

3. Draw a UML diagram that shows all classes in the program and their relationships. This can be done however you want. If you want a specific application, [StarUML](http://staruml.io/download) and [Draw.io](https://draw.io) are both good. But you are welcome to use any graphics program or just draw them by hand and scan them.
4. Think how you will determine if your code functions are expected. Develop a test plan based on the above description; how will you test that the expected outputs have been achieved for every menu option? **Be sure this test plan is complete.** Your test plan should minimally test each option in the menu-driven user interface for expected behavior as well as error-handling. Your test plan should be in a spreadsheet format (preferably Excel, CSV, or TSV).

**NOTE**: You can use any format to write your design, but it must be in your repository in the project folder by the due date to be graded. This means it can **not** be a link to a Google Doc.

## Phase II: Project Implementation and Testing

### 04/29/2022

**Step 1**: Implement all of the classes for your program as well as the application class. Be sure to document your code. Each class should have the your name, date, and a description of the class in comments at the top of the file. **NOTE**: Your final program does not need to be identical to the design you submitted. Your design should be a guide to how you implement your solution, not a strick set of requirements.

**Step 2**: Test each of the classes according to your proposed test plan. Be sure to work with small pieces of the whole before trying to put the entire project together. Nothing is more discouraging than a large project with numerous errors that compound one another to the point where it is impossible to know where to begin the debugging process.

**Step 3**: Test your application. Run through your application to see if everything works as expected.

**Step 4**: Carefully check your results with the expected results and debug the project if any errors do come up.

**Step 5**: Before submission, ask a few friends or family members to test your application to see if your user interface is user-friendly and 'unbreakable'. Correct any problems you identify.

**NOTE**: You *must* submit a project design in order for your code to be graded. Even if the design is so late that it is no longer eligible for points, it still must be submitted.
