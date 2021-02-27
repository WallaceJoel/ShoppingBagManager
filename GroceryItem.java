package proj1;

import java.text.DecimalFormat;

/**
 * This class is used to build the 'GroceryItem' object, an abstract item used
 * to represent items in grocery stores.
 * 
 * @author Joel Wallace, Nicholas McConnell jtw91 ncm78
 */

public class GroceryItem {
   private String name;
   private double price;
   private boolean taxable;

   /**
    * A constructor, for the class, creates the object using a String name, double
    * price, and whether or not it is taxable (true if it is, false if its not);
    * 
    * @param name    of the item
    * @param price   of the item
    * @param taxable true if item is taxable, false if not
    */
   public GroceryItem(String name, double price, boolean taxable) {
      this.name = name;
      this.price = price;
      this.taxable = taxable;
   }

   /**
    * A getter method for the item to see if it is taxable.
    * 
    * @return true if it is taxable, false otherwise
    */
   public boolean isTaxable() {
      return taxable;
   }

   /**
    * A getter method for GroceryItem.
    * 
    * @return the name of the item
    */
   public String getName() {
      return name;
   }

   /**
    * A getter method for the GroceryItem price.
    * 
    * @return the price of the item
    */
   public double getPrice() {
      return price;
   }

   /**
    * Compares an obj to the GroceryItem, makes sure they're the same item
    * 
    * @param obj
    * @return true or false, true if equal, false otherwise.
    */
   @Override
   public boolean equals(Object obj) {

      GroceryItem item = (GroceryItem) obj;

      if (!name.equals(item.name)) {
         return false;
      }
      if (price != item.price) {
         return false;
      }
      if (taxable != item.taxable) {
         return false;
      }
      return true;
   }

   /**
    * Converts the GroceryItem into a string, in the format of
    * "itemName:$itemCost.dd : (taxable or tax free)"
    * 
    * @return String
    */
   @Override
   public String toString() {
      String taxed = "tax free";
      if (taxable)
         taxed = "is taxable";

      String cost = (new DecimalFormat("#,###,##0.00")).format(price);
      return name + ": $" + cost + " : " + taxed;
   }

}
