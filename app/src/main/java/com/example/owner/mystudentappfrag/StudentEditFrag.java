package com.example.owner.mystudentappfrag;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
    private Student studentToEdit;
    private EditDateTextView date;
    private  EditTimeTextView time;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle StudentIdBundle = getArguments();
        View view = inflater.inflate(R.layout.student_edit_frag, container, false);

        // inflate the menu
        setHasOptionsMenu(true);

        studentToEdit = Model.instance().getStudent(StudentIdBundle.getInt("studentId"));

        txId = (TextView) view.findViewById(R.id.StudentIDAdd);
        Name = (TextView) view.findViewById(R.id.StudentNameAdd);
        Address = (TextView) view.findViewById(R.id.StudentAddressAdd);
        phone = (TextView) view.findViewById(R.id.StudentPhoneAdd);
        checked = (CheckBox) view.findViewById(R.id.StudentcheckBoxAdd);
        stdImage = (ImageView) view.findViewById(R.id.StudentImageAdd);
        date = (EditDateTextView)view.findViewById(R.id.StudentEditBirthday);
        time = (EditTimeTextView)view.findViewById(R.id.StudentEditTime);

        txId.setText(Integer.toString(studentToEdit.getId()));
        Name.setText(studentToEdit.getName());
        Address.setText(studentToEdit.getAddress());
        checked.setChecked(studentToEdit.getChecked());
        phone.setText(studentToEdit.getPhone());
        date.setDate(studentToEdit.getYear(),studentToEdit.getMonth(),studentToEdit.getDay());
        time.setTime(studentToEdit.getHour(),studentToEdit.getMinute());
        Button cancelButton = (Button) view.findViewById(R.id.StudentAddCancelButton);
        Button deleteButton = (Button) view.findViewById(R.id.StudentDeleteButton);
        Button saveButton = (Button) view.findViewById(R.id.StudentAddAddButton);

        cancelButton.setVisibility(View.VISIBLE);
        deleteButton.setVisibility(View.VISIBLE);
        saveButton.setVisibility(View.VISIBLE);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model.instance().deleteStudent(studentToEdit);
                getActivity().getFragmentManager().popBackStack();

            }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getFragmentManager().popBackStack();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentToEdit.setAddress(Address.getText().toString());
                studentToEdit.setId(Integer.parseInt(txId.getText().toString()));
                studentToEdit.setName(Name.getText().toString());
                studentToEdit.setPhone(phone.getText().toString());
                studentToEdit.setChecked(checked.isChecked());
                studentToEdit.setYear(date.getYear());
                studentToEdit.setMonth(date.getMonth());
                studentToEdit.setDay(date.getDay());
                studentToEdit.setHour(time.getHour());
                studentToEdit.setMinute(time.getMinute());


                getActivity().getFragmentManager().popBackStack();
                DialogFragment dialog = new SaveAlertDialog();
                dialog.show(getFragmentManager(),"TAG");
            }
        });

        return view;
    }



    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.studentappmenu,menu);
        getActivity().setTitle("Edit Students");

        menu.findItem(R.id.AddStudentButton).setVisible(false);
        menu.findItem(R.id.EditStudentButton).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
        // return true;
    }
}
