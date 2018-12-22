package com.example.amine.proglearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class admin extends AppCompatActivity {

    Button profil;
    ImageView photo;
    String p;
    DataBase db = new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        photo=(ImageView)findViewById(R.id.photoadmin);
        profil=(Button)findViewById(R.id.butonadmin);
        profil.setText(db.getNom(connexion.getEmailCon()));

        p=db.getphoto(connexion.getEmailCon());
        deco(p);

    }

//    public void routrAconxion(){
//        Intent intent = new Intent(admin.this,connexion.class);
//        startActivity(intent);
//    }


    public void deco (String s ){

        byte[] decodeString = Base64.decode(p,Base64.DEFAULT);
        Bitmap decode = BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);
        photo.setImageBitmap(decode);
    }




    public void ajouteengnent(View view) {
        Intent intent = new Intent(admin.this,ajouteensgnent.class);
        startActivity(intent);
        finish();
    }

    public void supprimeUnenseignant(View view) {
    Intent intent = new Intent(admin.this,supprimeUnenseignant.class);
    startActivity(intent);
    finish();
    }

    public void voireLaListeDesetudient(View view) {
        Intent intent = new Intent(admin.this, listeetudientForadmin.class);
        startActivity(intent);
        finish();

    }

    public void routrAconxion(View view) {
        Intent intent = new Intent(admin.this, connexion.class);
        startActivity(intent);
        finish();
    }

    public void goToProfil(View view) {
        Intent intent = new Intent(admin.this, profil.class);
        startActivity(intent);
    }
}
