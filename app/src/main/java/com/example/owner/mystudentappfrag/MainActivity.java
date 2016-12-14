package com.example.owner.mystudentappfrag;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Create the frag view
        final StudentListFrag studentlistFragment = new StudentListFrag();

        FragmentTransaction ftr = getFragmentManager().beginTransaction();
        ftr.replace(R.id.StudentListFragmentview,studentlistFragment);
        ftr.show(studentlistFragment);
        ftr.commit();
        //ftr.show(studentlistFragment);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:{
                onBackPressed();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

}


