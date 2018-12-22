package com.example.amine.proglearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ajouteUnCours extends AppCompatActivity {
    DataBase db = new DataBase(this);
    EditText tp,tc1,c1,q1,rq1,tc2,c2,q2,rq2,tc3,c3,q3,rq3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoute_un_cours);
        tp=(EditText)findViewById(R.id.editTitrePrincipal);


        tc1=(EditText)findViewById(R.id.editTitrePrincipalChapitre1 );
        c1=(EditText)findViewById(R.id.editChapitre1 );
        q1=(EditText)findViewById(R.id.editqustionChaptre1 );
        rq1=(EditText)findViewById(R.id.editreponcequstionChaptre1 );


        tc2=(EditText)findViewById(R.id.editTitrePrincipalChapitre2 );
        c2=(EditText)findViewById(R.id.editChapitre2 );
        q2=(EditText)findViewById(R.id.editqustionChaptre2 );
        rq2=(EditText)findViewById(R.id.editreponcequstionChaptre2 );


        tc3=(EditText)findViewById(R.id.editTitrePrincipalChapitre3 );
        c3=(EditText)findViewById(R.id.editChapitre3 );
        q3=(EditText)findViewById(R.id.editqustionChaptre3 );
        rq3=(EditText)findViewById(R.id.editreponcequstionChaptre3 );
    }

    public void ajoute(View view) {
        String atp = tp.getText().toString();

        String atc1 = tc1.getText().toString();
        String ac1 = c1.getText().toString();
        String aq1 = q1.getText().toString();
        String arq1 = rq1.getText().toString();

        String atc2 = tc2.getText().toString();
        String ac2 = c2.getText().toString();
        String aq2 = q2.getText().toString();
        String arq2 = rq2.getText().toString();

        String atc3 = tc3.getText().toString();
        String ac3 = c3.getText().toString();
        String aq3 = q3.getText().toString();
        String arq3 = rq3.getText().toString();

        if (atp.equals("") || atc1.equals("") || ac1.equals("") || aq1.equals("") || arq1.equals("") || atc2.equals("") || ac2.equals("")
                || aq2.equals("") || arq2.equals("") || atc3.equals("") || ac3.equals("")
                || aq3.equals("") || arq3.equals("")) {
            Toast.makeText(ajouteUnCours.this, "virifier champ", Toast.LENGTH_SHORT).show();
        } else {
          boolean result=db.insertcours(atp,atc1,ac1,aq1,arq1,atc2,ac2,aq2,arq2,atc3,ac3,aq3,arq3);

            if (result == true) {
                Toast.makeText(ajouteUnCours.this, "insert secsus", Toast.LENGTH_SHORT).show();
                tp.setText("");
                tc1.setText("");
                c1.setText("");
                q1.setText("");
                rq1.setText("");
                tc2.setText("");
                c2.setText("");
                q2.setText("");
                rq2.setText("");
                tc3.setText("");
                c3.setText("");
                q3.setText("");
                rq3.setText("");


            //    imageInscroption.setImageResource(R.drawable.iconfinder_male3_403019);

            } else {
                Toast.makeText(ajouteUnCours.this, "No insert", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void annuler(View view) {
        Intent intent = new Intent(ajouteUnCours.this, enseignant.class);
        startActivity(intent);
        finish();
    }
}
