package com.example.onkarpande.kjsphmess;

import android.content.Context;

import android.content.Intent;

import android.content.SharedPreferences;

import android.preference.PreferenceManager;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

import android.widget.Toast;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {



    Calendar cal = Calendar.getInstance();



    public final int dayName = cal.get(Calendar.DAY_OF_WEEK);



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        TextView numbers = findViewById(R.id.imageButton);



        numbers.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Toast.makeText(view.getContext(),"Opening Setting", Toast.LENGTH_SHORT).show();

                Intent i=new Intent(MainActivity.this,setting.class);

                startActivity(i);

            }

        });


        String cw=getDefaults("currentWeek",getApplicationContext());

        if(cw==null)
        {
            cw="1";
        }


        String s="";



        switch (dayName)

        {

            case 1 : s="Sunday";

                break;

            case 2 : s="Monday";

                break;

            case 3 : s="Tuesday";

                break;

            case 4 : s="Wednesday";

                break;

            case 5 : s="Thursday";

                break;

            case 6 : s="Friday";

                break;

            case 7 : s="Saturday";

                break;

        }



        InputStream is;



        is = getResources().openRawResource(R.raw.text);


        switch(cw) {

            case "1":

            {

                switch (dayName)

                {

                    case 1:
                        is = getResources().openRawResource(R.raw.w1d1);

                        break;

                    case 2:
                        is = getResources().openRawResource(R.raw.w1d2);

                        break;

                    case 3:
                        is = getResources().openRawResource(R.raw.w1d3);

                        break;

                    case 4:
                        is = getResources().openRawResource(R.raw.w1d4);

                        break;

                    case 5:
                        is = getResources().openRawResource(R.raw.w1d5);

                        break;

                    case 6:
                        is = getResources().openRawResource(R.raw.w1d6);

                        break;

                    case 7:
                        is = getResources().openRawResource(R.raw.w1d7);

                        break;

                }

            }

            break;
            case "2":

            {

                switch (dayName)

                {

                    case 1:
                        is = getResources().openRawResource(R.raw.w2d1);

                        break;

                    case 2:
                        is = getResources().openRawResource(R.raw.w2d2);

                        break;

                    case 3:
                        is = getResources().openRawResource(R.raw.w2d3);

                        break;

                    case 4:
                        is = getResources().openRawResource(R.raw.w2d4);

                        break;

                    case 5:
                        is = getResources().openRawResource(R.raw.w2d5);

                        break;

                    case 6:
                        is = getResources().openRawResource(R.raw.w2d6);

                        break;

                    case 7:
                        is = getResources().openRawResource(R.raw.w2d7);

                        break;

                }

            }  break;
            case "3":
            {

                switch (dayName)

                {

                    case 1:
                        is = getResources().openRawResource(R.raw.w3d1);

                        break;

                    case 2:
                        is = getResources().openRawResource(R.raw.w3d2);

                        break;

                    case 3:
                        is = getResources().openRawResource(R.raw.w3d3);

                        break;

                    case 4:
                        is = getResources().openRawResource(R.raw.w3d4);

                        break;

                    case 5:
                        is = getResources().openRawResource(R.raw.w3d5);

                        break;

                    case 6:
                        is = getResources().openRawResource(R.raw.w3d6);

                        break;

                    case 7:
                        is = getResources().openRawResource(R.raw.w3d7);

                        break;

                }

            }  break;
            case "4":


            {

                switch (dayName)

                {

                    case 1:
                        is = getResources().openRawResource(R.raw.w4d1);

                        break;

                    case 2:
                        is = getResources().openRawResource(R.raw.w4d2);

                        break;

                    case 3:
                        is = getResources().openRawResource(R.raw.w4d3);

                        break;

                    case 4:
                        is = getResources().openRawResource(R.raw.w4d4);

                        break;

                    case 5:
                        is = getResources().openRawResource(R.raw.w4d5);

                        break;

                    case 6:
                        is = getResources().openRawResource(R.raw.w4d6);

                        break;

                    case 7:
                        is = getResources().openRawResource(R.raw.w4d7);

                        break;

                }

            }
        }



        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;

        StringBuilder entireFile = new StringBuilder();

        try {

            while((line = br.readLine()) != null)

            { // <--------- place readLine() inside loop

                entireFile.append(line).append("\n"); // <---------- add each line to entireFile

            }

        }

        catch (IOException e) {
            e.printStackTrace();

        }



        TextView m =findViewById(R.id.m);



        TextView week = findViewById(R.id.week);



        TextView day =findViewById(R.id.day);


        cw="WEEK "+cw;

        week.setText(cw);



        day.setText(s);



        m.setText(entireFile.toString()); // <------- assign entireFile to TextView



        TextView next = findViewById(R.id.nextDay);



        next.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,nextday.class);

                startActivity(i);

            }

        });







    }



    public static void setDefaults(String key, String value, Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(key, value);

        editor.apply();

    }



    public static String getDefaults(String key, Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( context);

        return preferences.getString(key, null);

    }



}