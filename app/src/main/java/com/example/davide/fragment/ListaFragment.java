package com.example.davide.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by davide on 22/02/2018.
 */

public class ListaFragment extends Fragment {
    ArrayAdapter<String> itemsAdapter;
    private Ovviamente mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        itemsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, Pizza.pizzaMenu);

    }


    public interface Ovviamente{
        public void certamente(int index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.article_view, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        ListView lvItems = (ListView) view.findViewById(R.id.listView);
        lvItems.setAdapter(itemsAdapter);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              mCallback.certamente(position);
           }
       });


    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (Ovviamente) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
