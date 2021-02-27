package proj1;

/**
 * This class is an array-based container class, 'ShoppingBag', and used to hold
 * a list of GroceryItem.
 * 
 * @author Nicholas McConnell, Joel Wallace ncm78 jtw91
 */

public class ShoppingBag {
   private GroceryItem[] bag;
   private int size;

   /**
    * A constructor, for the class, takes no parameters. It initializes the bag
    * with a capacity of 5 and a size of 0.
    */
   public ShoppingBag() {
      final int CAPACITY_INCREASER = 5;
      size = 0;
      bag = new GroceryItem[CAPACITY_INCREASER];
   }

   /**
    * A helper method for getting the size of the ShoppingBag, so we can know the
    * total number items in it or if it is empty.
    * 
    * @return int, amount of items in bag.
    */
   public int getSize() {
      return this.size;
   }

   /**
    * Helper method to find an item. Returns the index where the item is located,
    * or it returns -1 if the item is not in the bag.
    * 
    * @param item to be found in the bag
    * @return index of the item in the param, -1 if not in bag
    */
   public int find(GroceryItem item) {
      for (int index = 0; index < size; ++index) {
         if (bag[index].equals(item)) {
            return index;
         }
      }
      return -1;
   }

   /**
    * Helper method to add an item to the grocery bag, and increase the capacity by
    * 5 if the capacity gets reached.
    * 
    * @param item to be added to bag
    */
   public void add(GroceryItem item) {
      final int CAPACITY_INCREASER = 5;
      bag[size] = item;
      size++;
      if (size == bag.length) {
         GroceryItem[] largerBag = new GroceryItem[bag.length + CAPACITY_INCREASER];
         for (int index = 0; index < size; ++index) {
            largerBag[index] = bag[index];
         }
         bag = largerBag;
      }
   }

   /**
    * Removes an item from the shopping bag, by copying the last item of the array
    * to the index of the item to be removed, and then replacing the last item with
    * a null reference. Returns true or false depending on whether the item was
    * found.
    * 
    * @param item, to be removed from bag
    * @return true if item is removed, or false if item isn't in bag.
    */
   public boolean remove(GroceryItem item) {
      int itemIndex = find(item);
      if (itemIndex < 0) {
         return false;
      }
      size--;
      bag[itemIndex] = bag[size];
      bag[size] = null;
      return true;
   }

   /**
    * A getter method which returns the sales price.
    * 
    * @return the saless price
    */
   public double salesPrice() {
      double totalPrice = 0.0;
      for (int index = 0; index < size; ++index) {
         totalPrice += bag[index].getPrice();
      }
      return totalPrice;
   }

   /**
    * A getter method which returns the sales tax.
    * 
    * @return the sales tax
    */
   public double salesTax() {
      final double TAX = 0.06625;
      double totalTax = 0.0;
      for (int index = 0; index < size; ++index) {
         if (bag[index].isTaxable()) {
            totalTax += bag[index].getPrice() * TAX;
         }
      }
      return totalTax;
   }

   /**
    * Empties the bag, get rid of the all items, and sets size to null Capacity
    * stays the same.
    */
   public void emptyBag() {
      for (int i = 0; i < size; i++) {
         bag[i] = null;
      }
      size = 0;
   }

   /**
    * Prints the items in order, with bullet points at the front.
    */
   public void print() {
      for (int index = 0; index < size; ++index) {
         System.out.print("·");
         System.out.println(bag[index].toString());
      }
   }

   /**
    * Testbed main, which adds a few grocery items to the bag and then prints it.
    *
    * @param args
    */
   public static void main(String[] args) {
      ShoppingBag testBag = new ShoppingBag();
      testBag.add(new GroceryItem("toast", 3.99, false));
      testBag.add(new GroceryItem("falafel", 5.99, false));
      testBag.add(new GroceryItem("v8", 2.49, true));
      testBag.add(new GroceryItem("milk", 3.49, false));
      testBag.add(new GroceryItem("butter", 1.99, true));
      testBag.add(new GroceryItem("celery", 3.49, false));
      System.out.println("# items in bag: " + testBag.getSize());
      System.out.println("Bag capacity: " + testBag.bag.length); // should be 10
      System.out.println("Sales price: " + testBag.salesPrice());
      // will give something like ##.#####, it gets reduce to ##.## in the
      // Shopping.class
      System.out.println("Sales tax: " + testBag.salesTax());
      testBag.print();
      testBag.remove(new GroceryItem("toast", 3.99, false));
      testBag.print();
      System.out.println("# items in bag: " + testBag.getSize());
      System.out.println("Bag capacity: " + testBag.bag.length); // should be 10
      System.out.println("Sales price: " + testBag.salesPrice());
      System.out.println("Sales tax: " + testBag.salesTax());
      testBag.emptyBag();
      System.out.println("# items in bag: " + testBag.getSize());
      System.out.println("Bag capacity: " + testBag.bag.length); // should be 10
      System.out.println("Sales price: " + testBag.salesPrice());
      System.out.println("Sales tax: " + testBag.salesTax());

   }
}