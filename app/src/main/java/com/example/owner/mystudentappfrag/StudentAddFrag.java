package com.example.owner.mystudentappfrag;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by owner on 13-Dec-16.
 */

public class StudentAddFrag extends Fragment {

    interface Delegate{
        void onCancel();
        void onSave(Student st);
    }

    Student st;
    EditText StudentID;
    EditText StudentName;
    EditText StudentAddress;
    EditText StudentPhone;
    CheckBox StudentChecked;
    Student _currStudent;

    StudentAddFrag.Delegate delegate;
    public void setDelegate(StudentAddFrag.Delegate dlg){
        this.delegate = dlg;
    }



    public StudentAddFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate the menu
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_student_frag, container, false);
        // On create of new student

        StudentID = (EditText) view.findViewById(R.id.StudentIDAdd);
        StudentName = (EditText) view.findViewById(R.id.StudentNameAdd);
        StudentAddress = (EditText) view.findViewById(R.id.StudentAddressAdd);
        StudentPhone = (EditText) view.findViewById(R.id.StudentPhoneAdd);
        StudentChecked = (CheckBox) view.findViewById(R.id.StudentcheckBoxAdd);

        Button save = (Button) view.findViewById(R.id.StudentAddAddButton);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Student st = new Student(StudentName.getText().toString(),
                            Integer.parseInt(StudentID.getText().toString()),
                            StudentAddress.getText().toString(),
                            StudentPhone.getText().toString());

                    // Adding  checked and picture
                    st.setChecked(StudentChecked.isChecked());

                    Model.instance().addStudent(st);
                    Log.d("TAG", "saving student to the db");

                    getActivity().getFragmentManager().popBackStack();
                }
            });

        view.findViewById(R.id.StudentAddCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getFragmentManager().popBackStack();
            }
        });

        return view;
    }

    /*
    * This updates only when the fragment starts
    * */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.studentappmenu,menu);
        getActivity().setTitle("New Students");

        menu.findItem(R.id.AddStudentButton).setVisible(false);
        menu.findItem(R.id.EditStudentButton).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
        // return true;
    }

    /*
       * To update the menu every time it is displayed
        */
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }



}

