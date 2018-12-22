package com.example.amine.proglearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class supprimeUnenseignant extends AppCompatActivity {
    EditText email;
    DataBase db = new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprime_unenseignant);
        email= (EditText)findViewById(R.id.emaild);
    }


    public void supprime(View view) {

        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Are you sure you want to delete")
                .setTitle("Delete")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String email1=email.getText().toString();
                        db.suprimeEnseignant(email1);
                        email.setText("");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();

    }

    public void annuler(View view) {
        Intent intent = new Intent(supprimeUnenseignant.this,admin.class);
        startActivity(intent);
        finish();
    }
}
