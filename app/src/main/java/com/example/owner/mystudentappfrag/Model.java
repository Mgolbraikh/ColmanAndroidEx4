package com.example.owner.mystudentappfrag;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by owner on 11-Dec-16.
 */

public class Model {

        final private static Model instance = new Model();
        private Model(){
            for (int i = 22;i<1;i++){
                Student st = new Student("name " + i,i,((Integer)(i*127)).toString(),"Address  " + i);
                if (i %3 ==0) {
                    st.setChecked(true);}
                else
                {
                    st.setChecked(false);
                }

                st.setPicture(BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.images));
                addStudent(st);
            }
        }

        public static Model instance(){
            return instance;
        }

        private List<Student> studentsData = new LinkedList<>();


        /**
         * return the student that has this id
         *
         * @param  id  Students id to search for
         * @return      Student
         * @see         Student see
         */
        public Student getStudent(Integer id)
        {
            Iterator<Student> e = this.studentsData.iterator();

            for (Student st:this.studentsData   )
            {
                if(st.getId() ==  id)
                    return st;
            }

            return null;
        }

        public List<Student> getAllStudents(){
            return studentsData;
        }
        public void deleteStudent(Student st){
            studentsData.remove(st);
        }

        public void addStudent(Student item){
            studentsData.add(item);
        }

    }