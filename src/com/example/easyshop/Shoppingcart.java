package com.example.easyshop;

import java.util.List;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Shoppingcart extends Activity {
 
 private List<Product> mCartList;
 private ProductAdapter mProductAdapter;
 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_shoppingcart);
  
  
  mCartList = ShoppingCartHelper.getCartList();
  
  // Make sure to clear the selections
  for(int i=0; i<mCartList.size(); i++) {
   mCartList.get(i).selected = false;
  }
  
  
  Button chek = (Button) findViewById(R.id.Button02);
  chek.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		AlertDialog dg = new AlertDialog.Builder(Shoppingcart.this).setTitle("success")
				.setMessage("items will be delivered shortly. payment on delivery").setNeutralButton(R.string.Ok, new DialogInterface.OnClickListener() {
					
				

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
		
	}
});
  
  // Create the list
  final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
  mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
  listViewCatalog.setAdapter(mProductAdapter);
  
  listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position,
     long id) {
   // Intent productDetailsIntent = new Intent(getBaseContext(),Productdetails.class);
   // productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
    // startActivity(productDetailsIntent);
   }
  });
  
 }
 
 @Override
 protected void onResume() {
  super.onResume();
  
  // Refresh the data
  if(mProductAdapter != null) {
   mProductAdapter.notifyDataSetChanged();
  }
  
  double subTotal = 0;
  for(Product p : mCartList) {
   int quantity = ShoppingCartHelper.getProductQuantity(p);
   subTotal += p.price * quantity;
  }
   
  TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
  productPriceTextView.setText("Subtotal: KSH" + subTotal);
 }

}