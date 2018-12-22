package com.example.amine.proglearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class enseignant extends AppCompatActivity {

    Button profil;
    ImageView photo;
    String p;
    DataBase db = new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enseignant);

        photo=(ImageView)findViewById(R.id.photoens);
        profil=(Button)findViewById(R.id.butonens);
        profil.setText(db.getNom(connexion.getEmailCon()));

        p=db.getphoto(connexion.getEmailCon());
        deco(p);

    }

    public void deco (String s ){

        byte[] decodeString = Base64.decode(p,Base64.DEFAULT);
        Bitmap decode = BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);
        photo.setImageBitmap(decode);
    }



    public void voirlalist(View view) {
        Intent intent = new Intent(enseignant.this, listeEtudients.class);
        startActivity(intent);
        finish();
    }

    public void routorAConx(View view) {
        Intent intent = new Intent(enseignant.this, connexion.class);
        startActivity(intent);
        finish();
    }

    public void ajouteUnCours(View view) {
        Intent intent = new Intent(enseignant.this, ajouteUnCours.class);
        startActivity(intent);
        finish();
    }



    public void suprimeUncours(View view) {

        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Are you sure you want to delete")
                .setTitle("Delete")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(enseignant.this, suprimeUncours.class);
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

    public void voirlalistdescomnt(View view) {
        Intent intent = new Intent(enseignant.this, listComntair.class);
        startActivity(intent);
        finish();

    }

    public void Profile(View view) {
        Intent intent = new Intent(enseignant.this, profil.class);
        startActivity(intent);
    }
}
