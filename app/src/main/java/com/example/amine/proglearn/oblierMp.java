package com.example.amine.proglearn;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class oblierMp extends AppCompatActivity {
    DataBase db = new DataBase(this);
    EditText email;
    String S,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oblier_mp);
        email= (EditText)findViewById(R.id.emaild);

    }

    public void send(View view) {
        S=email.getText().toString();
       m=db.getmotpass(S);

       try {
           Intent sendamail = new Intent(Intent.ACTION_SEND);
           sendamail.setData(Uri.parse("mailto:"));
           sendamail.putExtra(Intent.EXTRA_EMAIL,S);
           sendamail.putExtra(Intent.EXTRA_SUBJECT,"Voutre motde pass");
           sendamail.putExtra(Intent.EXTRA_TEXT,m);
           startActivity(sendamail);
       }catch (Exception e){ Toast.makeText(oblierMp.this, "ne trouv pa applicatuion envoyer msg  ", Toast.LENGTH_SHORT).show();}



    }

    public void annuler(View view) {
        Intent intent = new Intent(oblierMp.this, connexion.class);
        startActivity(intent);
        finish();
    }
}
