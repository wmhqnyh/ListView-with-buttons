package com.kunal.viewholderexample.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.kunal.viewholderexample.R;
import com.kunal.viewholderexample.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunal on 10/9/15.
 */
public class ShoppingCustomAdapter extends ArrayAdapter<ShoppingItem> {

    /* List of Items shown on main page */
    private List<ShoppingItem> shoppingItemList = new ArrayList<ShoppingItem>();

    public ShoppingCustomAdapter(Context context, int resource) {
        super(context, resource);
    }

    /** Adds the specified object at the end of the array.
     * @param newShoppingItem The object (new shopping item) to add at the end of the array.
     */
    @Override
    public void add(ShoppingItem newShoppingItem) {
        shoppingItemList.add(newShoppingItem);
        super.add(newShoppingItem);
    }

    /**
     * How many items are in the data set represented by this Adapter.
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return shoppingItemList.size();
    }

    /**
     * @param position Position of the item whose data we want within the adapter's data set.
     * @return The data at the specified position.
     */
    @Override
    public ShoppingItem getItem(int position) {
        return this.shoppingItemList.get(position);
    }

    /**
     * Get a View that displays the data at the specified position in the data set.
     * You can either create a View manually or inflate it from an XML layout file.
     *
     * @param position The position of the item within the adapter's data set of the item whose view we want.
     * @param convertView The old view to reuse, if possible.
     *        Note: You should check that this view is non-null and of an appropriate type before using.
     *              If it is not possible to convert this view to display the correct data, this method
     *              can create a new view. Heterogeneous lists can specify their number of view types,
     *              so that this View is always of the right type (see getViewTypeCount() and getItemViewType(int)).
     * @param parent The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleListItemView = convertView;
        final MyViewholder viewHolder;

        // A ViewHolder keeps references to children views to
        // avoid unnecessary (and expensive) calls to findViewById() on each row.
        if (singleListItemView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleListItemView = inflater.inflate(R.layout.list_item_single, parent, false);

            //instantiate ViewHolder
            viewHolder = new MyViewholder();

            //findViewById()
            viewHolder.itemTitleTextView = (TextView)singleListItemView.findViewById(R.id.textView);
            viewHolder.addItemButton = (Button)singleListItemView.findViewById(R.id.button);

            singleListItemView.setTag(viewHolder);
            viewHolder.addItemButton.setTag(position);
        }
        else
        {
            viewHolder = (MyViewholder)singleListItemView.getTag();
        }

        final ShoppingItem shoppingItem = getItem(position);


        if(shoppingItem.isItemInCart())
        {
            viewHolder.itemTitleTextView.setText("In Cart");
        }
        else
        {
            viewHolder.itemTitleTextView.setText(shoppingItem.getItemName());
        }

        viewHolder.addItemButton.setText(shoppingItem.getItemButtonText());
        viewHolder.addItemButton.setBackgroundColor(shoppingItem.getItemButtonColor());

        viewHolder.addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewHolder.itemTitleTextView.setText("CLICKED");
                shoppingItem.setItemButtonText("Added");
                shoppingItem.setItemButtonColor(Color.parseColor("#2B8250"));
                shoppingItem.setIsItemInCart(true);
                notifyDataSetChanged();
                //viewHolder.addItemButton.setBackgroundColor(Color.parseColor("#000000"));
            }
        });

        return singleListItemView;
        }



    //create a static ViewHolder class here
    static class MyViewholder
    {
        TextView itemTitleTextView;
        Button addItemButton;

    }
}
