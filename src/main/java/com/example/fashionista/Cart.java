package com.example.fashionista;



import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cart extends ListActivity {

    private ListView listView;
    private String countryNames[] = new String[10];
    private ArrayList<String> countryNames1 = new ArrayList<String>();
    private String capitalNames[] = new String[10];
    private ArrayList<String> capitalNames1 =  new ArrayList<String>();

    private Integer imageid[] = new Integer[10];
    private ArrayList<Integer>  imageid1 = new ArrayList<Integer>();
    private DatabaseReference ProductsRef;
    String p1="";
    String p2="";
    String p3="";
    String i1_1 ="P1";
    String i1_2 ="20";
    int i1_3 = R.drawable.gown;
    String i2_1 ="P2";
    String i2_2 ="30";
    int i2_3 = R.drawable.clothes;
    String i3_1 ="P3";
    String i3_2 ="40";
    int i3_3 = R.drawable.fjacket;
    int flag =0 ;
    int flag1 =0 ;
    int flag2 =0 ;
    int amount = 0;
    private Button NextProcessBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartview);
        final Cart c= this;
        NextProcessBtn = (Button) findViewById(R.id.next_btn);
        final TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List of Product in Cart : Amount : "+amount);
        final ListView listView=(ListView)findViewById(android.R.id.list);
        listView.addHeaderView(textView);
        NextProcessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                textView.setText("Total Price = RS" + String.valueOf(amount));
                Intent intent = new Intent(Cart.this, ConfirmFinalOrderActivity.class);
                // send the total price to the next  - confirm final order activity
                intent.putExtra("Total Price", String.valueOf(amount));
                startActivity(intent);
                finish();
            }
        });
        ProductsRef = FirebaseDatabase.getInstance("https://trolley-86b9a-default-rtdb.firebaseio.com/").getReference("P1");
        ProductsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                p1 = snapshot.getValue(Long.class)+"" ;
                amount =0;
                if(p3.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }
                if(p1.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }
                if(p2.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }

                Log.d("Value", "Value of p1" + p1);

                if(p1.equalsIgnoreCase("1"))
                {
                    //int length = countryNames1.length;
                    capitalNames1.add(i1_2);
                    countryNames1.add(i1_1);
                    imageid1.add(i1_3);
                   // amount = amount + Integer.parseInt(i1_2);

                }else {
                    String countryNames_new[] = new String[10];

                    countryNames1.remove(i1_1);
                    capitalNames1.remove(i1_2);
                    imageid1.remove(Integer.valueOf(i1_3));
                    flag =1;
                }
                Log.d("Value", "Value of p1" + countryNames1.size());
                Log.d("Value", "Value of p1" + countryNames1.toArray());
                String[] countryNames = new String[countryNames1.size()];
                countryNames = countryNames1.toArray(countryNames);

                String[] capitalNames = new String[capitalNames1.size()];
                capitalNames = capitalNames1.toArray(capitalNames);

                Integer[] imageid = new Integer[imageid1.size()];
                imageid = imageid1.toArray(imageid);
                CustomCountryList customCountryList = new CustomCountryList(c, countryNames,capitalNames,imageid);
                listView.setAdapter(customCountryList);
                textView.setText("List of Product in Cart : Amount : "+amount);
               // listView.refreshDrawableState();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ProductsRef = FirebaseDatabase.getInstance("https://trolley-86b9a-default-rtdb.firebaseio.com/").getReference("P2");
        ProductsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                p2 = snapshot.getValue(Long.class)+"" ;
                amount =0;
                if(p3.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }
                if(p1.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }
                if(p2.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }

                Log.d("Value", "Value of p1" + p2);

                if(p2.equalsIgnoreCase("1"))
                {
                    //int length = countryNames1.length;
                    capitalNames1.add(i2_2);
                    countryNames1.add(i2_1);
                    imageid1.add(i2_3);
                    //amount = amount + Integer.parseInt(i2_2);

                }else {
                    String countryNames_new[] = new String[10];

                    flag1=1;
                    countryNames1.remove(i2_1);
                    capitalNames1.remove(i2_2);
                    imageid1.remove(Integer.valueOf(i2_3));


                }
                Log.d("Value", "Value of p1" + countryNames1.size());
                Log.d("Value", "Value of p1" + countryNames1.toArray());
                String[] countryNames = new String[countryNames1.size()];
                countryNames = countryNames1.toArray(countryNames);

                String[] capitalNames = new String[capitalNames1.size()];
                capitalNames = capitalNames1.toArray(capitalNames);

                Integer[] imageid = new Integer[imageid1.size()];
                imageid = imageid1.toArray(imageid);
                CustomCountryList customCountryList = new CustomCountryList(c, countryNames,capitalNames,imageid);
                listView.setAdapter(customCountryList);
                // listView.refreshDrawableState();
                textView.setText("List of Product in Cart : Amount : "+amount);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ProductsRef = FirebaseDatabase.getInstance("https://trolley-86b9a-default-rtdb.firebaseio.com/").getReference("P3");
        ProductsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                p3 = snapshot.getValue(Long.class)+"" ;
                amount =0;
                if(p3.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }
                if(p1.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }
                if(p2.equalsIgnoreCase("1")){
                    amount = amount + Integer.parseInt(i3_2);;
                }
                Log.d("Value", "Value of p1" + p3);

                if(p3.equalsIgnoreCase("1"))
                {
                    //int length = countryNames1.length;
                    capitalNames1.add(i3_2);
                    countryNames1.add(i3_1);
                    imageid1.add(i3_3);
                   // amount = amount + Integer.parseInt(i3_2);

                }else {
                    String countryNames_new[] = new String[10];
                    if(flag2 ==1)
                    //amount = amount - Integer.parseInt(i3_2);
                    flag2=1;
                    countryNames1.remove(i3_1);
                    capitalNames1.remove(i3_2);
                    imageid1.remove(Integer.valueOf(i3_3));


                }
                Log.d("Value", "Value of p1" + countryNames1.size());
                Log.d("Value", "Value of p1" + countryNames1.toArray());
                String[] countryNames = new String[countryNames1.size()];
                countryNames = countryNames1.toArray(countryNames);

                String[] capitalNames = new String[capitalNames1.size()];
                capitalNames = capitalNames1.toArray(capitalNames);

                Integer[] imageid = new Integer[imageid1.size()];
                imageid = imageid1.toArray(imageid);
                CustomCountryList customCountryList = new CustomCountryList(c, countryNames,capitalNames,imageid);
                listView.setAdapter(customCountryList);
                // listView.refreshDrawableState();
                textView.setText("List of Product in Cart : Amount : "+amount);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
            // Setting header



        // For populating list data


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"You Selected "+countryNames[position-1]+ " as Country",Toast.LENGTH_SHORT).show();        }
        });
    }
}
