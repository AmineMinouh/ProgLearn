package com.example.amine.proglearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listComntair extends AppCompatActivity {
    DataBase db = new DataBase(this);
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comntair);
        list = (ListView)findViewById(R.id.listecomntr);
    }

    public void afficherLesDonner(){
        ArrayList<String> listeDesDonner = db.recupretoutlescomnt(); // charge la list from method recuper tout les donner
        ArrayAdapter arrayAdapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1,listeDesDonner);
        list.setAdapter(arrayAdapter);
    }
    public void voireLaListedescomntr(View view) {
        afficherLesDonner();


    }

    public void annuler(View view) {
        Intent intent = new Intent(listComntair.this,enseignant.class);
        startActivity(intent);
        finish();
    }
}
