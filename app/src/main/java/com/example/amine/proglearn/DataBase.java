package com.example.amine.proglearn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Amine on 05/12/2018.
 */

public class DataBase extends SQLiteOpenHelper {
    public static final String DbName = "data.db";
    public DataBase(Context context) {
        super(context, DbName, null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table inscription avzc 4 champ
        db.execSQL("create table inscription ( email  PRIMARY KEY  , nom TEXT ,prenom TEXT,motdepass text,age Text , image Text , type Text ) ");
//        db.execSQL("create table comnt ( id  PRIMARY KEY AUTOINCREMENT , comnt TEXT ) ");
  //      db.execSQL("create table cours ( titrepricipal  PRIMARY KEY , titrechaptre1 TEXT ,chapitre1 TEXT,questionchaptre1 TEXT ,reponcequestionchapitre1 TEXT,titrechaptre2 TEXT ,chapitre2 TEXT,questionchaptre2 TEXT ,reponcequestionchapitre2 TEXT,titrechaptre3 TEXT ,chapitre3 TEXT,questionchaptre3 TEXT ,reponcequestionchapitre3 TEXT ) ");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //test si table existe ou non
        db.execSQL("drop table if exists inscription ");
        onCreate(db);
     //   db.execSQL("create table comnt ( id  PRIMARY KEY AUTOINCREMENT , comnt TEXT ) ");
//        db.execSQL("drop table if exists comnt ");
//        onCreate(db);
//        db.execSQL("drop table if exists cours ");
//        onCreate(db);
    }




    //////////////////////////







    //////////////
    public boolean insertDataInscription (String nom,String prenom,String email,String motdepass,String age,String image ,String type){
        SQLiteDatabase db = this.getWritableDatabase();//pour ecrire dans la table
        ContentValues contentValues= new ContentValues();//pour ajjoter les donner

        // insert les donner
        contentValues.put("email",email);
        contentValues.put("nom",nom);
        contentValues.put("prenom",prenom);
        contentValues.put("motdepass",motdepass);
        contentValues.put("age",age);
        contentValues.put("image",image);
        contentValues.put("type",type);

        // enrgstre les donne dans la table innscription
        long result = db.insert("inscription",null,contentValues);

        if (result==-1){return false;}else {return true;}
    }


    public boolean virifieSiAdressAndMpAndTypeJust( String mail , String mp , String type) {
        boolean test = false;
        int x=0;
        //pour ajjouter les donner en array list
        //ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from inscription ", null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast() == false || test==false ) { //parcor tout les element de tablaux
            String email1 = res.getString(res.getColumnIndex("email"));// ou le nom de champ
            String motdepass1 = res.getString(res.getColumnIndex("motdepass"));// ou le nom de champ
            String type1 = res.getString(res.getColumnIndex("type"));// ou le nom de champ
            if (email1.equals(mail) && motdepass1.equals(mp) && type1.equals(type)) {

               test = true;

            }

            res.moveToNext();
        }

    return test;

    }

    public void suprimeEnseignant(String mail){

        SQLiteDatabase db = this.getWritableDatabase();// lire la table
        db.delete("inscription","email = ?", new String[]{mail});

    }


    public ArrayList recupretoutlesdonne(){
        String cle;
        //pour ajjouter les donner en array list
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from inscription",null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast()==false){ //parcor tout les element de tablaux
            cle = res.getString(res.getColumnIndex("type"));
            if (cle.equals("student")){

            String nom1 = res.getString(res.getColumnIndex("nom"));// ou le nom de champ
            String prenom1 = res.getString(res.getColumnIndex("prenom"));// ou le nom de champ
            String age1 = res.getString(res.getColumnIndex("age"));// ou le nom de champ

            arrayList.add(nom1 +"   "+ prenom1 +"   "+ age1 );// ajjt dans array list

        }
            res.moveToNext();//le parcor ++
        }
        return arrayList;

    }
    ///////////////////////////////////////////////method poue les cours////////////////////////////////


    public boolean insertcours(String titreP,String titrechaptre1,String chapitre1,String question1,String repancequestion1,String titrechaptre2,String chapitre2,String question2,String repancequestion2,String titrechaptre3,String chapitre3,String question3,String repancequestion3){
        SQLiteDatabase db = this.getWritableDatabase();//pour ecrire dans la table
        ContentValues contentValues= new ContentValues();//pour ajjoter les donner




        // insert les donner
        contentValues.put("titrepricipal",titreP);

        contentValues.put("titrechaptre1",titrechaptre1);
        contentValues.put("chapitre1",chapitre1);
        contentValues.put("questionchaptre1",question1);
        contentValues.put("reponcequestionchapitre1",repancequestion1);

        contentValues.put("titrechaptre2",titrechaptre2);
        contentValues.put("chapitre2",chapitre2);
        contentValues.put("questionchaptre2",question2);
        contentValues.put("reponcequestionchapitre2",repancequestion2);

        contentValues.put("titrechaptre3",titrechaptre3);
        contentValues.put("chapitre3",chapitre3);
        contentValues.put("questionchaptre3",question3);
        contentValues.put("reponcequestionchapitre3",repancequestion3);


        // enrgstre les donne dans la table innscription
        long result = db.insert("cours",null,contentValues);

        if (result==-1){return false;}else {return true;}
    }



    public void suprimeunCours(String titre){

        SQLiteDatabase db = this.getWritableDatabase();// lire la table
        db.delete("cours","titrepricipal = ?", new String[]{titre});

    }



    ///////////////////////////////acceul///////////////////////////

    public String chaptre(String titrePrincipal1, String Colon){
        String text="";
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from cours ",null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast()==false ){ //parcor tout les element de tablaux

            String cle = res.getString(res.getColumnIndex("titrepricipal"));// ou le nom de champ
         if (cle.equals(titrePrincipal1)){
              text = res.getString(res.getColumnIndex(Colon));// ou le nom de champ

         }

            res.moveToNext();//le parcor ++
        }
        return text;

    }


///////////////////////////////// comnt//////////////////////////////////





    public ArrayList recupretoutlescomnt(){
        //pour ajjouter les donner en array list
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from comnt",null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast()==false){ //parcor tout les element de tablaux
            String id = res.getString(res.getColumnIndex("id"));// ou le nom de champ
            String comnt = res.getString(res.getColumnIndex("comnt"));// ou le nom de champ


            arrayList.add(id +"  :   "+ comnt );// ajjt dans array list
            res.moveToNext();//le parcor ++
        }
        return arrayList;

    }


    public boolean insertcomnt (String comnt){
        SQLiteDatabase dba = this.getWritableDatabase();//pour ecrire dans la table
        ContentValues contentValues= new ContentValues();//pour ajjoter les donner

        // insert les donner
        contentValues.put("comnt",comnt);


        // enrgstre les donne dans la table innscription
        long result = dba.insert("comnt",null,contentValues);

        if (result==-1){return false;}else {return true;}
    }



    ////////////////////////// profil////////////////////////
// email  PRIMARY KEY  , nom TEXT ,prenom TEXT,motdepass text,age Text , image Text , type Text

    public String getNom(String email){
        String nom="";
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from inscription ",null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast()==false ){ //parcor tout les element de tablaux

            String cle = res.getString(res.getColumnIndex("email"));// ou le nom de champ
            if (cle.equals(email)){
                nom = res.getString(res.getColumnIndex("nom"));// ou le nom de champ

            }

            res.moveToNext();//le parcor ++
        }
        return nom;

    }


    public String getPreNom(String email){
        String prenom="";
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from inscription ",null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast()==false ){ //parcor tout les element de tablaux

            String cle = res.getString(res.getColumnIndex("email"));// ou le nom de champ
            if (cle.equals(email)){
                prenom = res.getString(res.getColumnIndex("prenom"));// ou le nom de champ

            }

            res.moveToNext();//le parcor ++
        }
        return prenom;

    }
//motdepass

    public String getphoto(String email){
        String photo="";
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from inscription ",null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast()==false ){ //parcor tout les element de tablaux

            String cle = res.getString(res.getColumnIndex("email"));// ou le nom de champ
            if (cle.equals(email)){
                photo = res.getString(res.getColumnIndex("image"));// ou le nom de champ

            }

            res.moveToNext();//le parcor ++
        }
        return photo;

    }


    public String getmotpass(String email){
        String motdepass="";
        SQLiteDatabase db = this.getReadableDatabase();// lire la table
        Cursor res = db.rawQuery("select * from inscription ",null);

        res.moveToFirst();// va a la 1er ligne
        while (res.isAfterLast()==false ){ //parcor tout les element de tablaux

            String cle = res.getString(res.getColumnIndex("email"));// ou le nom de champ
            if (cle.equals(email)){
                motdepass = res.getString(res.getColumnIndex("motdepass"));// ou le nom de champ

            }

            res.moveToNext();//le parcor ++
        }
        return motdepass;

    }
}


