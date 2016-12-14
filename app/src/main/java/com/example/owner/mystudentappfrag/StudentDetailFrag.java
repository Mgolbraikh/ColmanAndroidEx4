package com.example.owner.mystudentappfrag;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by owner on 14-Dec-16.
 */

public class StudentDetailFrag extends Fragment {
    interface Delegate{
        void onCancel();
        void onSave(Student st);
    }
    private TextView txId;
    private TextView Name;
    private TextView Address;
    private TextView phone;
    private CheckBox checked;
    private ImageView stdImage;
    private Student studentToShow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Bundle StudentIdBundle = getArguments();
        View view = inflater.inflate(R.layout.student_details_frag, container, false);

        // inflate the menu
        setHasOptionsMenu(true);

        if(StudentIdBundle != null)
        {
                studentToShow = Model.instance().getStudent(StudentIdBundle.getInt("studentId"));

                if(studentToShow == null)
                {
                    getActivity().getFragmentManager().popBackStack();
                    return view;
                }

                txId = (TextView) view.findViewById(R.id.StudentIdView);
                Name = (TextView) view.findViewById(R.id.StudentNameView);
                Address = (TextView) view.findViewById(R.id.StudentAddressView);
                phone = (TextView) view.findViewById(R.id.StudentPhoneView);
                checked = (CheckBox) view.findViewById(R.id.StudentcheckBoxView);
                stdImage = (ImageView) view.findViewById(R.id.StudentImageView);

                txId.setText(Integer.toString(studentToShow.getId()));
                Name.setText(studentToShow.getName());
                Address.setText(studentToShow.getAddress());
                checked.setChecked(studentToShow.getChecked());
                phone.setText(studentToShow.getPhone());
                stdImage.setImageResource(R.drawable.images);
            }
            else {
                // Someone came from delete = popback
                getActivity().getFragmentManager().popBackStack();
            }


        return view;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.studentappmenu,menu);
        getActivity().setTitle("Students Details");

        menu.findItem(R.id.AddStudentButton).setVisible(false);
        menu.findItem(R.id.EditStudentButton).setVisible(true);
        super.onCreateOptionsMenu(menu, inflater);
        // return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case    R.id.EditStudentButton:{
                Fragment studentEditFrag = new StudentEditFrag();
                FragmentTransaction ftr = getActivity().getFragmentManager().beginTransaction();
                // Clear last bundle then add new
                Bundle studentInfoToshow = new Bundle();
                studentInfoToshow.putInt("studentId", ((Integer)studentToShow.getId()));
                studentEditFrag.setArguments(studentInfoToshow);
                ftr.replace(R.id.StudentActivityMainView, studentEditFrag);
                ftr.addToBackStack(null);
                ftr.show(studentEditFrag);
                ftr.commit();

                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
