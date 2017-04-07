package com.vigneshtraining.assignment63;
import com.vigneshtraining.assignment63.MyListFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.vigneshtraining.assignment63.model.ItemObject;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    private MyListFragment myListFragment;
    private Toast myToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager frgMng=getSupportFragmentManager();
        FragmentTransaction frgTxn=frgMng.beginTransaction();

        myListFragment = new MyListFragment();

        frgTxn.add(R.id.fragmentContainer, myListFragment);
        //frgTxn.addToBackStack(MyListFragment.NAME);
        frgTxn.commit();

    }

    @Override
    public void onItemClicked(ItemObject itemObject) {
        Log.d("MAIN", "---MM-------------"+itemObject.getTitle());
        if(myToast!=null){
            myToast.cancel();

        }
        myToast= Toast.makeText(MainActivity.this,itemObject.getDescription(),Toast.LENGTH_LONG);
        myToast.show();
    }
}
