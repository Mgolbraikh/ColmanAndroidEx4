package com.example.owner.mystudentappfrag;

/**
 * Created by owner on 11-Dec-16.
 */


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class StudentListFrag extends Fragment {

    interface Delegate{
        void onCancel();
        void onSave(Student st);
    }

    Delegate delegate;
    List<Student> studentsList;
    StudentsAdapter _adapter;
    public void setDelegate(Delegate dlg){
        this.delegate = dlg;
    }



    public StudentListFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.student_list_frag, container, false);

        studentsList = Model.instance().getAllStudents();
        _adapter = new StudentsAdapter();
        ListView list = (ListView) view.findViewById(R.id.studentlistViewview);
        list.setAdapter(_adapter);
        //TextView labelTv = (TextView) view.findViewById(R.id.firstFragmentTextView);

        Log.d("TAG", "fragment create view student list");
//        Button cancel = (Button) view.findViewById(R.id.firstFragmentCancel);
//        Button save = (Button) view.findViewById(R.id.firstFragmentSave);
//
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (delegate != null) {
//                    delegate.onCancel();
//                }
//            }
//        });
//
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (delegate != null) {
//                    delegate.onSave(student);
//                }
//            }
//        });
        return view;
    }

    class StudentsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return studentsList.size();
        }

        @Override
        public Object getItem(int i) {
            return studentsList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.studentlistrow, null);
//                view.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent openDetails = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
//                        openDetails.putExtra("id",((Student)getItem((int)view.getTag())).getId());
//                        startActivityForResult(openDetails,2);
//
//                    }
                //});
                // TODO add checkbox change
                final CheckBox cb = (CheckBox) view.findViewById(R.id.checkBoxRow);
                cb.setOnClickListener(new View.OnClickListener() {
                    //                        @Override
                    public void onClick(View view) {
                        Student currStudent = (Student)getItem((int)((View)view.getParent()).getTag());
                        currStudent.setChecked(!currStudent.getChecked());
                    }
                });
            }

            // Setting tag to identify current index
            view.setTag(i);
            Student currStudent = (Student)getItem(i);
            TextView nameTv = (TextView) view.findViewById(R.id.StudentName);
            TextView idTv = (TextView) view.findViewById(R.id.StudentID);
            nameTv.setText(currStudent.getName());
            CheckBox cb = (CheckBox) view.findViewById(R.id.checkBoxRow);
            cb.setChecked(currStudent.getChecked());
            idTv.setText(((Integer)currStudent.getId()).toString());
            return view;
        }
    }
}
