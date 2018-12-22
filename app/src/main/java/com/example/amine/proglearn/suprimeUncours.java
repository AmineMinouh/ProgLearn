package com.example.amine.proglearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class suprimeUncours extends AppCompatActivity {

    EditText titre;
    DataBase db = new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suprime_uncours);
        titre=(EditText)findViewById(R.id.titred);;
    }

    public void supprimeUnCours(View view) {
        String titre1=titre.getText().toString();
        db.suprimeunCours(titre1);

    }

    public void annuler(View view) {
        Intent intent = new Intent(suprimeUncours.this,enseignant.class);
        startActivity(intent);
        finish();
    }
}
