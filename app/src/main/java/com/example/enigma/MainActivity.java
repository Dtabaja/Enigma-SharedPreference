package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.enigma_sharedpreference.Enigma;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student s = new Student("daniel", 28);
        Student s1 = new Student("Avraham",28);
        Student s2 = new Student("Naor", 24);
        Student s3 = new Student("Gil", 25);

        Enigma.getInstance().removeAll();
         Enigma.getInstance().putInt("6",6);
         Enigma.getInstance().putDouble("1.4", 2.87474);
        Log.d("pttt", String.valueOf(Enigma.getInstance().getInt("6")));
        Log.d("pttt", String.valueOf(Enigma.getInstance().getDouble("1.4")));


        HashMap<String, String> capitalCities = new HashMap<String, String>();

        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        HashMap<String, Integer> numbers = new HashMap<String, Integer>();
        numbers.put("1",1);
        numbers.put("2",2);
        numbers.put("3",3);
        numbers.put("4",4);
        HashMap<String, Student> students = new HashMap<String, Student>();

        students.put("classA",s);
        students.put("ClassB", s1);
        students.put("ClassC", s2);
        students.put("ClassD", s3);


        Enigma.getInstance().putHashMap("cities", capitalCities);
        Enigma.getInstance().putHashMap("Numbers", numbers);
        Enigma.getInstance().putHashMap("Students", students);

        Log.d("pttt", String.valueOf(Enigma.getInstance().getHashMap("cities")));
        Log.d("pttt", String.valueOf(Enigma.getInstance().getHashMap("Numbers")));
        Log.d("pttt", String.valueOf(Enigma.getInstance().getHashMap("Students")));
/*

        ArrayList arr = new ArrayList();
        ArrayList<Student> arr2= new ArrayList<Student>();


        arr.add(1);
        arr.add("str");
        arr.add(s.getName());
        arr.add(s.getAge());

        arr2.add(s);

        EncryptSP.getInstance().putArrayList("Stam",arr);
        Log.d("pttt", String.valueOf(EncryptSP.getInstance().getArrayList("Stam")));

        EncryptSP.getInstance().putArrayList("Stam2",arr2);
        Log.d("pttt", String.valueOf(EncryptSP.getInstance().getArrayList("Stam2")));

        Log.d("pttt", String.valueOf(EncryptSP.getInstance().getAll()));
*/
    }
}