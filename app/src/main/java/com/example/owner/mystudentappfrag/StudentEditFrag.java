package com.example.owner.mystudentappfrag;

import android.app.Fragment;
import android.os.Bundle;
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

public class StudentEditFrag extends Fragment {
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

        TextView txId;
        TextView Name;
        TextView Address;
        TextView phone;
        CheckBox checked;
        ImageView stdImage;

        Bundle StudentIdBundle = getArguments();

        View view = inflater.inflate(R.layout.student_edit_frag, container, false);


        //if(StudentIdBundle != null) {
            studentToShow = Model.instance().getStudent(StudentIdBundle.getInt("studentId"));

            txId = (TextView) view.findViewById(R.id.StudentIDAdd);
            Name = (TextView) view.findViewById(R.id.StudentNameAdd);
            Address = (TextView) view.findViewById(R.id.StudentAddressAdd);
            phone = (TextView) view.findViewById(R.id.StudentPhoneAdd);
            checked = (CheckBox) view.findViewById(R.id.StudentcheckBoxAdd);
            stdImage = (ImageView) view.findViewById(R.id.StudentImageAdd);

            txId.setText(Integer.toString(studentToShow.getId()));
            Name.setText(studentToShow.getName());
            Address.setText(studentToShow.getAddress());
            checked.setChecked(studentToShow.getChecked());
            phone.setText(studentToShow.getPhone());

        //}

        return view;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.studentappmenu,menu);

        menu.findItem(R.id.AddStudentButton).setVisible(false);
        menu.findItem(R.id.EditStudentButton).setVisible(true);
        super.onCreateOptionsMenu(menu, inflater);
        // return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.EditStudentButton:
            {
                //onBackPressed();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }


}
