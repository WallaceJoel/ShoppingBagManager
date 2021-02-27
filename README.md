# ShoppingBagManager
This program utilizes Java to implement an array-based container class ShoppingBag and use it to hold a list of grocery items. An instance of the ShoppingBag class is a growable bag with an initial capacity of holding 5 grocery items, and automatically grows (increases) the capacity by 5 whenever it is full.

The program shall allow the user to add, remove and display the items in the bag. In addition, the program shall
provide the functionality of checking out the grocery items in the bag. Checking out will empty the bag and display
the details of the grocery items, including the list of grocery items and the total amount paid. Each grocery item in
the list shall include the item name, unit price and taxable or nontaxable. The total amount paid is the sum of the unit
price in the list plus the sales tax, which is 6.625%. The sales tax only applies to the taxable items.

Examples of user input to run program:

r meat 2.99 false \n
a meat 2.99 false
P
R toast 2.99 false
A toast 4.95 false
A jam 3.95 false
A jam 3.95 false P
R jam 3.95 false P
Blah blah blah
a meat 2.99 false
A jam 2.59 false
A jam 2.59 false
A jam 2.59 false
A toast 4.95 false
A jam 3.99 false P
R jam 2.59 false P
R toast 4.95 false PcC
R toast 4.95 false
A toast 4.95 false C
A milk 2.5 false
A salmon 5.99 false
A toilet_papers 7.95 true
A kitchen_towels 10 true
A bagels 3.99 false
A garbage_bags 4.59 true
A laundry_detergent 12.99 true pP
A chicken 6.75 false
A pork 4.59 false
A shrimp 13 false
A masks 15.59 true
A sanitizer 2.99 true
A bleach
