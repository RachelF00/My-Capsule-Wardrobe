# My Capsule Wardrobe - make you a cool outfitter !

## Inspiration

A **capsule wardrobe** is a collection of clothing that is composed of interchangeable items only, 
to maximise the number of outfits that can be created. The aim is to have an outfit suitable for any occasion owning
excessive items of clothing, which is a widely-accepted concept among *Minimalists*.  

As for capsule wardrobe users, it's common to forget the exact number of thier items or run out of 
outfitting inspirations. With the help of *My Capsule Wardrobe* app, clothes matching and wardrobe management
become much easier! 


## Functions
To offer a high-quality user experience, *My Capsule Wardrobe* will have the following 
functions:

- Store items a user already have into different classifications
- Store outfits matched by a user
- Provide inspirations for a user: classic matchings and trendy fashion design
- Provide a memo of clothing spendings



## User Stories
- As a user, I want to be able to create a user account.
- As a user, I want to be able to add items (a topping, a pants, a coat, etc.) to my wardrobe.
- As a user, I want to be able to remove an item from my wardrobe.
- As a user, I want to be able to create a new collection of my items.
- As a user, I want to be able to add items to my collections.
- As a user, I want to be able to make a matching of items from my wardrobe.
- As a user, I want to be able to save my items and collections to file (if I so choose).
- As a user, I want to be able to load my items and collections from file (if I so choose).


## Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by clicking the remove item button
- You can generate the second required action related to adding Xs to a Y by clicking show top button
- You can locate my visual component by successfully adding an item and see the showMessageDialog
- You can save the state of my application by clicking save data button
- You can reload the state of my application by clicking load data button


## Phase 4: Task 2
- Event log:
- Mon Apr 10 14:05:40 PDT 2023
- User Account Created!
- Mon Apr 10 14:05:46 PDT 2023
- An item added!
- Mon Apr 10 14:05:50 PDT 2023
- An item added!
- Mon Apr 10 14:05:57 PDT 2023
- An item added!
- Mon Apr 10 14:06:03 PDT 2023
- An item added!
- Mon Apr 10 14:06:05 PDT 2023
- Items displayed!
- Mon Apr 10 14:06:10 PDT 2023
- Tops displayed!
- Mon Apr 10 14:06:18 PDT 2023
- An item removed!
- Mon Apr 10 14:06:20 PDT 2023
- Items displayed!

## Phase 4: Task 3
One of my potential refactorings is to remove commented out and never used code.
With my progress in this project, some functions are different from what I originally designed
and part of the code is never used. To make my code clean and readable, that kind of 
code should be removed.

Another way of refactoring is to abstract duplicated code into methods 
(reducing coupling). For example, in Collection, UserAccount and Workroom classes, all of 
them have similar addItem methods to add a single item. Therefore, I can seperate part of the code 
and re-organize it to avoid duplication.

