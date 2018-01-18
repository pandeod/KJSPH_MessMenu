package com.example.onkarpande.kjsphmess;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.Spinner;




import static com.example.onkarpande.kjsphmess.MainActivity.getDefaults;

import static com.example.onkarpande.kjsphmess.MainActivity.setDefaults;



public class setting extends AppCompatActivity {



    String compareValue;

 //   public int x;



    @Override

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);



        final Spinner spinner = findViewById(R.id.planets_spinner);



// Create an ArrayAdapter using the string array and a default spinner layout

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);



// Specify the layout to use when the list of choices appears

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



// Apply the adapter to the spinner

        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedItemText = (String) parent.getItemAtPosition(position);

                // Notify the selected item text

                //  Toast.makeText (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();

                // call method

                setValue(selectedItemText);

            }



            @Override

            public void onNothingSelected(AdapterView<?> parent) {



            }

        });





        Button one = findViewById(R.id.button);

        one.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View v) {



                String defaultValue=getValue();

                String cw =getdropDown();

                if (cw==null) {

                    int spinnerPosition = adapter.getPosition("1");

                    spinner.setSelection(spinnerPosition);

                }

                else

                {

                    int spinnerPosition = adapter.getPosition(defaultValue);

                    spinner.setSelection(spinnerPosition);

                }



                String getCurrentWeek = spinner.getSelectedItem().toString();



//                java.util.Calendar cal = java.util.Calendar.getInstance();

//

//                int r = cal.get(java.util.Calendar.WEEK_OF_YEAR);

//

//                int c=Integer.valueOf(getCurrentWeek );

//

//                x= (r%4)-c;



                setdropDown(getCurrentWeek);



                Intent i=new Intent(setting.this,MainActivity.class);

                startActivity(i);

            }

        });





        String cw =getdropDown();

        if (cw==null) {

            int spinnerPosition = adapter.getPosition("1");

            spinner.setSelection(spinnerPosition);

        }

        else

        {

            int spinnerPosition = adapter.getPosition(cw);

            spinner.setSelection(spinnerPosition);

        }





    }



    public void setValue(String s)

    {

        this.compareValue=s;

    }

    public String getValue()

    {

        return this.compareValue;

    }

    public String getdropDown()

    {

        return getDefaults("currentWeek",getApplicationContext());

    }

    public void setdropDown(String getCurrentWeek)

    {

        setDefaults("currentWeek",getCurrentWeek,getApplicationContext());

    }

}