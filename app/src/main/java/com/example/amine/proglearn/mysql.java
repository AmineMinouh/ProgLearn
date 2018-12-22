package com.example.amine.proglearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class mysql extends AppCompatActivity {
    EditText comn1, comnt2, comnt3;
    DataBase db = new DataBase(this);
    RadioGroup radioGroup1,radioGroup2,radioGroup3;
    Button repance1,repance2,repance3;
    RadioButton choi1,choi2,choi3;
    LinearLayout linearLayout2,linearLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysql);

        comn1 = (EditText) findViewById(R.id.mysqlcomnter1);
        comnt2 = (EditText) findViewById(R.id.mysqlcomnter2);
        comnt3 = (EditText) findViewById(R.id.mysqlcomnter3);


//////////////////////////////////////////////////////////////////

        radioGroup1 = (RadioGroup)findViewById(R.id.radioGrop1);
        repance1 =(Button)findViewById(R.id.repnceQuistion1);
        linearLayout2 = (LinearLayout)findViewById(R.id.layoutChap2);
        linearLayout2.setVisibility(linearLayout2.INVISIBLE);

        linearLayout3 = (LinearLayout)findViewById(R.id.layoutChap3);
        linearLayout3.setVisibility(linearLayout3.INVISIBLE);

        repance1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selctid = radioGroup1.getCheckedRadioButtonId();
                choi1 = (RadioButton)findViewById(selctid);
                String s = choi1.getText().toString();

                if (s.equals("Sgbd")){
                    linearLayout2.setVisibility(linearLayout2.VISIBLE);
                    Toast.makeText(mysql.this, " bravo repance just", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mysql.this, " repance incorect", Toast.LENGTH_SHORT).show();
                }

            }
        });

        /////////////////////////////////////////////////////////////////


        radioGroup2 = (RadioGroup)findViewById(R.id.radioGrop2);
        repance2 =(Button)findViewById(R.id.repnceQuistion2);


        repance2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selctid = radioGroup2.getCheckedRadioButtonId();
                choi2=(RadioButton)findViewById(selctid);
                String s = choi2.getText().toString();
                if (s.equals("php")){
                    linearLayout3.setVisibility(linearLayout3.VISIBLE);
                    Toast.makeText(mysql.this, " bravo repance just", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mysql.this, " repance incorect", Toast.LENGTH_SHORT).show();
                }
            }
        });



        ////////////////////////////////////////////////////////////////////

        radioGroup3 = (RadioGroup)findViewById(R.id.radioGrop3);
        repance3 =(Button)findViewById(R.id.repnceQuistion3);

        repance3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selctid = radioGroup3.getCheckedRadioButtonId();

                choi3=(RadioButton)findViewById(selctid);
                String s = choi3.getText().toString();
                if (s.equals("phpmyadmin")){

                    Toast.makeText(mysql.this, " bravo repance just", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mysql.this, " repance incorect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void envoyerCmntr1(View view) {
        String comnt = comn1.getText().toString();
        if (comnt.equals("")) {
            Toast.makeText(mysql.this, "virifier champ comnt", Toast.LENGTH_SHORT).show();
        }else{
            boolean result = db.insertcomnt(comnt);
            if (result == true) {
                Toast.makeText(mysql.this, "insert secsus", Toast.LENGTH_SHORT).show();
                comn1.setText("");
            } else {
                Toast.makeText(mysql.this, "No insert", Toast.LENGTH_SHORT).show();
            }
        }
    }




    public void envoyerCmntr2(View view) {
        String comnt = comnt2.getText().toString();
        if (comnt.equals("")) {
            Toast.makeText(mysql.this, "virifier champ comnt", Toast.LENGTH_SHORT).show();
        }else{
            boolean result = db.insertcomnt(comnt);
            if (result == true) {
                Toast.makeText(mysql.this, "insert secsus", Toast.LENGTH_SHORT).show();
                comnt2.setText("");
            } else {
                Toast.makeText(mysql.this, "No insert", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void envoyerCmntr3(View view) {

        String comnt = comnt3.getText().toString();
        if (comnt.equals("")) {
            Toast.makeText(mysql.this, "virifier champ comnt", Toast.LENGTH_SHORT).show();
        }else{
            boolean result = db.insertcomnt(comnt);
            if (result == true) {
                Toast.makeText(mysql.this, "insert secsus", Toast.LENGTH_SHORT).show();
                comnt3.setText("");
            } else {
                Toast.makeText(mysql.this, "No insert", Toast.LENGTH_SHORT).show();
            }
        }
    }




    public void radiochap1(View view) {
    }
}
