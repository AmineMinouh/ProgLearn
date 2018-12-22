package com.example.amine.proglearn;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class accueil extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    DataBase db = new DataBase(this);
    TextView tp,tc1,c1,q1,rq1,tc2,c2,q2,rq2,tc3,c3,q3,rq3;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.accBg);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView =(NavigationView)findViewById(R.id.navigView);
        navigationView.setNavigationItemSelectedListener(this);


        tp=(TextView)findViewById(R.id.editTitrePrincipal);


        tc1=(TextView)findViewById(R.id.editTitrePrincipalChapitre1 );
        c1=(TextView)findViewById(R.id.editChapitre1 );



        tc2=(TextView)findViewById(R.id.editTitrePrincipalChapitre2 );
        c2=(TextView)findViewById(R.id.editChapitre2 );



        tc3=(TextView)findViewById(R.id.editTitrePrincipalChapitre3 );
        c3=(TextView)findViewById(R.id.editChapitre3 );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public  void aa (View view){
        Intent intent = new Intent(accueil.this ,inscription .class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        // Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show();
        if (id == R.id.java) {
            Intent intent = new Intent(accueil.this ,java.class);
            startActivity(intent);
        }else if (id == R.id.php) {
            Intent intent = new Intent(accueil.this, php.class);
            startActivity(intent);
        } else if (id == R.id.mysql) {
        Intent intent = new Intent(accueil.this, mysql.class);
        startActivity(intent);
    }else if (id == R.id.html) {
            Intent intent = new Intent(accueil.this, html.class);
            startActivity(intent);
        }else if (id == R.id.about) {
            Intent intent = new Intent(accueil.this, about.class);
            startActivity(intent);
        }



        return false;
    }






    public void goToProfil(View view){
        Intent intent = new Intent(accueil.this ,profil.class);
        startActivity(intent);
    }

}
