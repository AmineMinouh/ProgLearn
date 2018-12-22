package com.example.amine.proglearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listeetudientForadmin extends AppCompatActivity {
    ListView list;
    DataBase db = new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeetudient_foradmin);
        list = (ListView)findViewById(R.id.listeetdient);
    }

    public void afficherLesDonner(){
        ArrayList<String> listeDesDonner = db.recupretoutlesdonne(); // charge la list from method recuper tout les donner
        ArrayAdapter arrayAdapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1,listeDesDonner);
        list.setAdapter(arrayAdapter);
    }
    public void voireLaListe(View view) {
        afficherLesDonner();
    }

    public void annulerPourAdmin(View view) {
        Intent intent = new Intent(listeetudientForadmin.this,admin.class);
        startActivity(intent);
        finish();
    }

}
