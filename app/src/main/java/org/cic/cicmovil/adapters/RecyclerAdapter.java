package org.cic.cicmovil.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.cic.cicmovil.R;

/**
 * Created by PERSONAL on 28/03/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    // IF the view under inflation and population is header or Item
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[]; // String Array to store the passed titles Value from MainActivity.java
    private int mIcons[];       // Int Array to store the passed icons resource value from MainActivity.java

    private String name;        //String Resource for header View Name
    private int profile;        //int Resource for header view profile picture
    private String email;

    public RecyclerAdapter(String Titles[], int Icons[], String Name, String Email, int Profile){ // MyAdapter Constructor with titles and icons parameter
        // titles, icons, name, email, profile pic are passed from the main activity as we
        mNavTitles = Titles;                //have seen earlier
        mIcons = Icons;
        name = Name;
        email = Email;
        profile = Profile;                      //here we assign those passed values to the values we declared here
                                                //in adapter
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_drawer,parent,false); //Inflating the layout

            ViewHolder vhItem = new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

            return vhItem; // Returning the created object
            //inflate your layout and pass it to view holder

        }
        if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_drawer,parent,false); //Inflating the layout

            ViewHolder vhHeader = new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

            return vhHeader; //returning the object created

        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder.id == 1) {
            // as the list view is going to be called after the header view so we decrement the
            // position by 1 and pass it to the holder while setting the text and image
            holder.textView_row.setText(mNavTitles[position - 1]); // Setting the Text with the array of our Titles
            holder.imageView_row.setImageResource(mIcons[position -1]);// Settimg the image with array of our icons
        }
        else{
            holder.iv_profile.setImageResource(profile);           // Similarly we set the resources for header view
            holder.tv_name.setText(name);
            holder.tv_email.setText(email);
        }
    }

    @Override
    public int getItemCount() {
        return mNavTitles.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public  int id;
        TextView textView_row;
        ImageView imageView_row;
        ImageView iv_profile;
        TextView tv_name;
        TextView tv_email;


        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType == TYPE_ITEM){
                id = 1;
                textView_row = (TextView) itemView.findViewById(R.id.row_Text); // Creating TextView object with the id of textView from item_row.xml
                imageView_row = (ImageView) itemView.findViewById(R.id.row_Icon);// Creating ImageView object with the id of ImageView from item_row.xml
            }
            else {
                id = 0;
                iv_profile = (ImageView) itemView.findViewById(R.id.cv_profile);
                tv_name = (TextView) itemView.findViewById(R.id.tv_name);
                tv_email = (TextView) itemView.findViewById(R.id.tv_email);
            }

        }
    }
}
