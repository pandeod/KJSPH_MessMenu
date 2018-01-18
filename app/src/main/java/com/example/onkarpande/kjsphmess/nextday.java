package com.example.onkarpande.kjsphmess;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;




import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.util.Calendar;



import static com.example.onkarpande.kjsphmess.MainActivity.getDefaults;



public class nextday extends AppCompatActivity {



    Calendar cal = Calendar.getInstance();



    public final int dayN = cal.get(Calendar.DAY_OF_WEEK);



    @SuppressLint("SetTextI18n")
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nextday);



        String cw=getDefaults("currentWeek",getApplicationContext());

         if(cw==null)
         {
             cw="1";
         }


        String s="";



        int NextDay=dayN+1;

        switch (NextDay)

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

                switch (NextDay)

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

                switch (NextDay)

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

                switch (NextDay)

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

                switch (NextDay)

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

            // TODO Auto-generated catch block

            e.printStackTrace();

        }



        TextView m =findViewById(R.id.m);



        TextView week = findViewById(R.id.week);



        TextView day =findViewById(R.id.day);



        week.setText("WEEK "+cw);



        day.setText(s);



        m.setText(entireFile.toString()); // <------- assign entireFile to TextView



        TextView back = findViewById(R.id.back);



        back.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent i=new Intent(nextday.this,MainActivity.class);

                startActivity(i);

            }

        });





    }





}