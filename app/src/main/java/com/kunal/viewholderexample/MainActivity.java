package com.kunal.viewholderexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.kunal.viewholderexample.adapter.ShoppingCustomAdapter;
import com.kunal.viewholderexample.model.ShoppingItem;

public class MainActivity extends AppCompatActivity {


   //dummy model
    ShoppingItem shoppingItem;
    //ListView for Dish
    ListView shoppingListView;
    //adapter
    ShoppingCustomAdapter shoppingCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoppingListView = (ListView)findViewById(R.id.main_list);

        shoppingCustomAdapter = new ShoppingCustomAdapter(this, R.layout.list_item_single);

        for(int i=0;i<25;i++)
        {
            shoppingItem = new ShoppingItem("ItemName","100");
            shoppingCustomAdapter.add(shoppingItem);
        }

        shoppingListView.setAdapter(shoppingCustomAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
