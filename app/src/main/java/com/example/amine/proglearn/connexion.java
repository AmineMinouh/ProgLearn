package com.example.amine.proglearn;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class connexion extends AppCompatActivity {
    Animation animi;
    TextView t1,t2;
    LinearLayout textsplash;
    static EditText email;
    EditText motdepass;
    EditText type;
    DataBase db = new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        t1= (TextView)findViewById(R.id.t1);
        t2= (TextView)findViewById(R.id.t2);
        textsplash= (LinearLayout) findViewById(R.id.textsplash);
        animi= AnimationUtils.loadAnimation(this,R.anim.anim);
        t1.setAnimation(animi);
        t2.setAnimation(animi);
        textsplash.setAnimation(animi);


        email = (EditText)findViewById(R.id.email);
        motdepass = (EditText)findViewById(R.id.motdepass);
        type = (EditText)findViewById(R.id.type);

    }

    public static String getEmailCon(){
        String email1 = email.getText().toString();
        return  email1;
    }

    public void conx(View view) {


        String email1 = email.getText().toString();

        String motdepass1 = motdepass.getText().toString();

        String type1 = type.getText().toString();

        if (email1.equals("") || motdepass1.equals("") || type1.equals("")) {
            Toast.makeText(connexion.this, "virifier champ", Toast.LENGTH_SHORT).show();
        } else if (type1.equals("student") || type1.equals("admin") || type1.equals("teacher")) {





        //
         if (type1.equals("student")) {
            if (db.virifieSiAdressAndMpAndTypeJust(email1, motdepass1, type1) == true) {
                Intent intent = new Intent(connexion.this, accueil.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(connexion.this, "You are not registered or you have not chosen your right type", Toast.LENGTH_SHORT).show();
            }


        } else if (type1.equals("teacher")) {
            if (db.virifieSiAdressAndMpAndTypeJust(email1, motdepass1, type1) == true) {
                Intent intent = new Intent(connexion.this, enseignant.class);
                startActivity(intent);
                finish();
            } else {

                Toast.makeText(connexion.this, "You are not registered or you have not chosen your right type", Toast.LENGTH_SHORT).show();
            }


        }else if (type1.equals("admin")) {
            if (db.virifieSiAdressAndMpAndTypeJust(email1, motdepass1, type1) == true) {
                Intent intent = new Intent(connexion.this, admin.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(connexion.this, "You are not registered or you have not chosen your right type", Toast.LENGTH_SHORT).show();
            }


        }
        } else{  Toast.makeText(connexion.this, "write student or admin or teacher", Toast.LENGTH_SHORT).show();}

        //


    }



    public void inscription(View view){
        Intent intent = new Intent(connexion.this ,inscription.class);
        startActivity(intent);
        finish();
    }


    public void forgetmp(View view) {
        Intent intent = new Intent(connexion.this ,oblierMp.class);
        startActivity(intent);
    }
}
