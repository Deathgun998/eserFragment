package com.example.davide.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by davide on 23/02/2018.
 */

public class DetailFragment extends Fragment{
    ArrayAdapter<String> itemsAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        itemsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, Pizza.pizzaDetails);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_view, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        TextView lvItems = (TextView) view.findViewById(R.id.textView);
        Bundle bundle = this.getArguments();

            int myInt = bundle.getInt("posizione",0);
            lvItems.setText(Pizza.pizzaDetails[myInt]);
    }
}
