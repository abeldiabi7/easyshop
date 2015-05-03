package com.example.easyshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {
 
 public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
 
 private static List<Product> catalog;
 private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();
 
 public static List<Product> getCatalog(Resources res){
  if(catalog == null) {
   catalog = new Vector<Product>();
   catalog.add(new Product("MILK", res
     .getDrawable(R.drawable.milk),
     "fresh maziwa", 50.99));
   catalog.add(new Product("Bread", res
     .getDrawable(R.drawable.bread),
     "kenyan bread", 50.99));
   catalog.add(new Product("sugar", res
     .getDrawable(R.drawable.sugar),
     "kabras sugar", 140.99));
  
   catalog.add(new Product("unga maize", res
		     .getDrawable(R.drawable.flour),
		     "maize flour", 149.99));  
  }
  
  return catalog;
 }
 
 public static void setQuantity(Product product, int quantity) {
  // Get the current cart entry
  ShoppingCartEntry curEntry = cartMap.get(product);
  
  // If the quantity is zero or less, remove the products
  if(quantity <= 0) {
   if(curEntry != null)
    removeProduct(product);
   return;
  }
  
  // If a current cart entry doesn't exist, create one
  if(curEntry == null) {
   curEntry = new ShoppingCartEntry(product, quantity);
   cartMap.put(product, curEntry);
   return;
  }
  
  // Update the quantity
  curEntry.setQuantity(quantity);
 }
 
 public static int getProductQuantity(Product product) {
  // Get the current cart entry
  ShoppingCartEntry curEntry = cartMap.get(product);
  
  if(curEntry != null)
   return curEntry.getQuantity();
  
  return 0;
 }
 
 public static void removeProduct(Product product) {
  cartMap.remove(product);
 }
 
 public static List<Product> getCartList() {
  List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
  for(Product p : cartMap.keySet()) {
   cartList.add(p);
  }
  
  return cartList;
 }
 

}

