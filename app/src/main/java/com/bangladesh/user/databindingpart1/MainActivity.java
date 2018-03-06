package com.bangladesh.user.databindingpart1;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bangladesh.user.databindingpart1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setAStudent(new Student(null, 25));
        binding.setHandler(new EventHandler());
/*       ==================>  this code for simple text show using data binding <=====================

        binding.setTextOne("MD.");
      binding.setTextTwo("Junaet");
      binding.setTextThree("Hossain");*/

        //=========> Using List  <============== (01)

        Student junaet = new Student("MD. junaet Hossain", 25);
        List<Student> students = new ArrayList<>();
        students.add(junaet);


        //============> Using Map <===============(01)

        Map<String, Integer> nameVsAge = new HashMap<>();
        nameVsAge.put(junaet.getName(), junaet.getAge());

        //============> Using Map <===============(05)
        binding.setStudents(students);
        binding.setNameVsAge(nameVsAge);


    }


    public class EventHandler {
        public void handlerClick(String name) {
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        }
    }


    public class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
