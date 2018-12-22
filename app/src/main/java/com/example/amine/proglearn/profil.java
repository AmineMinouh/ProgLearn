package com.example.amine.proglearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class profil extends AppCompatActivity {
TextView nom , prenom;
    ImageView photo, pp;
String p;
    DataBase db = new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);


        nom= (TextView)findViewById(R.id.nom);
        prenom= (TextView)findViewById(R.id.prenom);
        photo=(ImageView)findViewById(R.id.photo);

        nom.setText(db.getNom(connexion.getEmailCon()));
        prenom.setText(db.getPreNom(connexion.getEmailCon()));


       p=db.getphoto(connexion.getEmailCon());
        deco(p);
      // photo
//        photo=(ImageView)p;
    }

    public void deco (String s ){

        byte[] decodeString = Base64.decode(p,Base64.DEFAULT);
        Bitmap decode = BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);
        photo.setImageBitmap(decode);
    }


    public void deconxion(View view) {


        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Are you sure you want to Sign Out")
                .setTitle("Sign Out")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(profil.this,connexion.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();








    }
}
