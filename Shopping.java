package proj1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This class is used to build the 'Shopping' interface, which can run based off
 * of data for a shopping bag and grocery items.
 * 
 * @author Nicholas McConnell, Joel Wallace ncm78 jtw91
 */

public class Shopping {

   private ShoppingBag shoppingBag;
   private boolean running;

   /**
    * This is a basic helper method for the efficiency of distinguishing singular
    * from plural. It returns "" if n = 1, and "s" otherwise.
    *
    * @param number
    * @return "" if the number is 1, otherwise "s"
    */
   private String plural(int number) {
      if (number == 1) {
         return "";
      } else {
         return "s";
      }
   }

   /**
    * This helper method formats a price so that it has exactly two decimal places
    * and commas every three digits.
    *
    * @param price
    * @return formatted version for price
    */
   private String format(double price) {
      DecimalFormat formattedPrice = new DecimalFormat("#,###,##0.00");
      return formattedPrice.format(price);
   }

   /**
    * This is for the A and R command, makes sure the price is actually a price,
    * and taxable is true or false
    * 
    * @param user input for price (to be a double)
    * @param user input for taxable (to be a boolean)
    * @return true if the parsing was successful, false otherwise
    */
   private boolean errorCheck(String price, String taxable) {
      try {
         Boolean.parseBoolean(taxable);
         Double.parseDouble(price);

      } catch (Exception e) {
         System.out.println("Invalid command!");
         return false;
      }
      return true;
   }

   /**
    * Executes the input string given in the argument. For example, "A milk 2.99
    * false" will add a $2.99 milk to the bag without tax.
    *
    * @param the user input as a string
    */
   private void executeInput(String input) {
      if (input.equals("")) {
         System.out.println("Invalid command!");
         return;
      }
      String[] userCommand = input.split(" "); // needed for the A and R command
      final int commandSize = 4; // the size of userCommand, if A or R command is use.
      switch (input.charAt(0)) {
      case 'A': // add
         if (userCommand.length < commandSize) {
            System.out.println("Invalid command!");
            break;
         }
         if (errorCheck(userCommand[2], userCommand[3])) {
            GroceryItem item = new GroceryItem(userCommand[1], Double.parseDouble(userCommand[2]),
                  Boolean.parseBoolean(userCommand[3]));
            shoppingBag.add(item);
            System.out.println(item.getName() + " added to the bag.");
         }
         break;
      case 'R': // remove
         if (userCommand.length < commandSize) {
            System.out.println("Invalid command!");
            break;
         }
         if (errorCheck(userCommand[2], userCommand[3])) {
            GroceryItem item = new GroceryItem(userCommand[1], Double.parseDouble(userCommand[2]),
                  Boolean.parseBoolean(userCommand[3]));
            if (shoppingBag.remove(item))
               System.out.println(item.getName() + " " + item.getPrice() + " removed.");
            else
               System.out.println("Unable to remove, this item is not in the bag.");
         }
         break;
      case 'P': // display
         if (shoppingBag.getSize() == 0) {
            System.out.println("The bag is empty!");
         } else {
            System.out.println(
                  "**You have " + shoppingBag.getSize() + " item" + plural(shoppingBag.getSize()) + " in the bag.");
            shoppingBag.print();
            System.out.println("**End of list");
         }
         break;
      case 'C': // check out
         if (shoppingBag.getSize() == 0) {
            System.out.println("Unable to check out, the bag is empty!");
         } else {
            System.out
                  .println("**Checking out " + shoppingBag.getSize() + " item" + plural(shoppingBag.getSize()) + ".");
            shoppingBag.print();
            double salesTotal = shoppingBag.salesPrice();
            double salesTax = shoppingBag.salesTax();
            System.out.println("*Sales total: $" + format(salesTotal));
            System.out.println("*Sales tax: $" + format(salesTax));
            System.out.println("*Total amount paid: $" + format(salesTotal + salesTax));
            shoppingBag.emptyBag();
         }
         break;
      case 'Q': // quit
         System.out.println("Thanks for shopping with us!");
         running = false;
         break;
      default:
         System.out.println("Invalid command!");
         break;
      }

   }

   /**
    * The method which runs the program. It gets called in the 'RunProject1' class.
    */
   public void run() {
      shoppingBag = new ShoppingBag();
      running = true;

      Scanner scanner = new Scanner(System.in);

      while (running) {
         executeInput(scanner.nextLine());
      }
      scanner.close();
   }

}