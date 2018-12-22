package com.example.amine.proglearn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class inscription extends AppCompatActivity {


    String codeImageInscroption;
    DataBase db = new DataBase(this);
    ImageView imageInscroption;
    EditText nom , prenom , email, motdepass , age ,type ;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        imageInscroption= (ImageView)findViewById(R.id.image_inscription);
        nom = (EditText)findViewById(R.id.nom);
        prenom = (EditText)findViewById(R.id.prenom);
        email = (EditText)findViewById(R.id.email);
        age = (EditText)findViewById(R.id.age);
        motdepass = (EditText)findViewById(R.id.motdepass);
        type = (EditText)findViewById(R.id.type);




    }




// open image
    public void importImageInscription(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);// import image from galery




    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==RESULT_OK){ /// test import image
            Uri uri = data.getData(); // get data
            imageInscroption.setImageURI(uri); // afficher image
        }

        //trasforme image to string
        Bitmap Bing = ((BitmapDrawable)imageInscroption.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        Bing.compress(Bitmap.CompressFormat.JPEG,100, byteArrayOutputStream);
        codeImageInscroption= Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
    }



    // method inscription
    public void Inscription(View view) {




        String nom1 = nom.getText().toString();

        String prenom1 = prenom.getText().toString();

        String email1 = email.getText().toString();

        String motdepass1 = motdepass.getText().toString();

        String age1 = age.getText().toString();

        String type1 = type.getText().toString();

        String codeImageInscroption1 = codeImageInscroption;

        if (nom1.equals("") || prenom1.equals("")|| email.equals("") || age1.equals("") || motdepass1.equals("")|| type1.equals("")) {
            Toast.makeText(inscription.this, "virifier champ", Toast.LENGTH_SHORT).show();

        }else if(nom1.length()<4){
            Toast.makeText(inscription.this, "I think it 's not a real name, try letters more than 4", Toast.LENGTH_SHORT).show();
        }else if(prenom1.length()<4){
            Toast.makeText(inscription.this, "I think it 's not a real first name, try letters more than 4", Toast.LENGTH_SHORT).show();
        }else if(email1.length()<12){
            Toast.makeText(inscription.this, "I think it 's not a real email, try letters more than 11", Toast.LENGTH_SHORT).show();
        }else if(age1.length()<1){
            Toast.makeText(inscription.this, "I think it 's not a real age, try letters more than 1", Toast.LENGTH_SHORT).show();
        }else if(motdepass1.length()<9){
            Toast.makeText(inscription.this, "erreur password, try letters more than 8", Toast.LENGTH_SHORT).show();

            // le ! ici pour la confuguration d applicatio la 1er foit
        }else if(!type1.equals("student")){
            Toast.makeText(inscription.this, "Type error", Toast.LENGTH_SHORT).show();

        }else{
            boolean result = db.insertDataInscription(nom1, prenom1, email1, motdepass1, age1, codeImageInscroption1,type1);
            if (result == true) {
                Toast.makeText(inscription.this, "insert secsus", Toast.LENGTH_SHORT).show();
                nom.setText("");
                prenom.setText("");
                email.setText("");
                motdepass.setText("");
                age.setText("");
                type.setText("");
                imageInscroption.setImageResource(R.drawable.iconfinder_male3_403019);


                Intent intent=new Intent(inscription.this,connexion.class);
                startActivity(intent);

            } else {
                Toast.makeText(inscription.this, "No insert", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
