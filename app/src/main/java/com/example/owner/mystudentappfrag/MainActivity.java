package com.example.owner.mystudentappfrag;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
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




}


