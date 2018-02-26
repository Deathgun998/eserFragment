package com.example.davide.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListaFragment.Ovviamente {
    TextView tvDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDetails = (TextView)findViewById(R.id.textView);
if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){


        if(savedInstanceState==null){
        ListaFragment fragment = new ListaFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();

    }
}else {

        ListaFragment fragment = new ListaFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();

        DetailFragment fragment2 = new DetailFragment();
        Bundle bundle = new Bundle();
        fragment2.setArguments(bundle);
    FragmentManager fragmentManager2 = getFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        fragmentTransaction2.replace(R.id.fragmentContainer2,fragment2);
        fragmentTransaction2.commit();

}

    }

    @Override
    public void certamente(int index) {
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT) {
            DetailFragment fragment = new DetailFragment();
           Bundle bundle = new Bundle();
           bundle.putInt("posizione",index);
           fragment.setArguments(bundle);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else{
            DetailFragment fragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("posizione",index);
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer2, fragment);
            fragmentTransaction.commit();
        }
    }
}
