package com.example.owner.mystudentappfrag;

/**
 * Created by owner on 11-Dec-16.
 */


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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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

        // inflate the menu
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.student_list_frag, container, false);

        studentsList = Model.instance().getAllStudents();
        _adapter = new StudentsAdapter();
        ListView list = (ListView) view.findViewById(R.id.studentlistViewview);
        list.setAdapter(_adapter);
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d("TAG", "row selected " + position);

                Fragment studentEditFrag = new StudentDetailFrag();
                FragmentTransaction ftr = getActivity().getFragmentManager().beginTransaction();
                Bundle studentInfoToshow = new Bundle();
                studentInfoToshow.putInt("studentId", ((Integer)studentsList.get(position).getId()));
                studentInfoToshow.putString("Screen", "FromDetail");

                studentEditFrag.setArguments(studentInfoToshow);
                ftr.replace(R.id.StudentActivityMainView, studentEditFrag);
                ftr.addToBackStack(null);
                ftr.show(studentEditFrag);
                ftr.commit();

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
        getActivity().setTitle("Student List");
        menu.findItem(R.id.AddStudentButton).setVisible(true);
        menu.findItem(R.id.EditStudentButton).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.AddStudentButton:
            {
                Fragment studentaddfragview = new StudentAddFrag();

                FragmentTransaction ftr = getActivity().getFragmentManager().beginTransaction();
                ftr.add(R.id.StudentActivityMainView, studentaddfragview);
                ftr.addToBackStack(null);
                ftr.show(studentaddfragview);
                ftr.hide(this);
                ftr.commit();

                // TODO : ziv read this
                // This is add and not replace fragment because in REPLACE the buttons on the screen showing annoing and in this case they are hiding while user inputs

                //onBackPressed();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

/*
   * To update the menu every time it is displayed
    */
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
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
