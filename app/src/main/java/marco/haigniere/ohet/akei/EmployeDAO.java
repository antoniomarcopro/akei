package marco.haigniere.ohet.akei;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class EmployeDAO {
    private static String base = "BDAkei";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public EmployeDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addEmploye(Employe unEmploye){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nomE", unEmploye.getNomE());
        value.put("prenomE",unEmploye.getPrenomE());
        value.put("mailE",unEmploye.getMailE());
        value.put("age",unEmploye.getAge());
        ret = bd.insert("employe", null, value);

        return ret;
    }

    public Employe getEmploye(long idE){
        Employe unEmploye = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from employe where idE="+idE+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            unEmploye = new Employe(
                    curseur.getLong(0),
                    curseur.getString(1),
                    curseur.getString(2),
                    curseur.getString(3),
                    curseur.getInt(4),
                    curseur.getLong(5),
                    curseur.getLong(6));
        }
        return unEmploye;
    }

    public ArrayList<Employe> getEmployes(){
        Cursor curseur;
        String req = "select * from employe ";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEmployeArrayList(curseur);
    }

    public ArrayList<Employe> getEmployesByIdM(long idM){
        Cursor curseur;
        String req = "select * from employe where idM="+idM+";";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEmployeArrayList(curseur);
    }

    public ArrayList<Employe> getEmployesByIdMIdPi(long idM, long idPi){
        Cursor curseur;
        String req = "select * from employe where idM="+idM+" and idPi="+idPi+";";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEmployeArrayList(curseur);
    }

    public ArrayList<Employe> getEmployesByNom(String nomE){
        Cursor curseur;
        String req = "select * from employe where nomE="+nomE+";";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEmployeArrayList(curseur);
    }

    public ArrayList<Employe> getEmployesByPrenom(String prenomE){
        Cursor curseur;
        String req = "select * from employe where prenomE="+prenomE+";";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEmployeArrayList(curseur);
    }

    public ArrayList<Employe> getEmployesByMagasin(String nom){
        Cursor curseur;
        String req = "select * from employe INNER JOIN magasin ON employe.idM = magasin.idM WHERE magasin.nom ="+nom+";";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEmployeArrayList(curseur);
    }

    public ArrayList<Employe> getEmployesByNomPrenom(long idM, long idPi, String text){
        Cursor curseur;
        String req = "select * from employe WHERE idM="+idM+" AND idPi="+idPi+" AND (nomE LIKE '%"+text+"%' OR prenomE LIKE '%"+text+"%');";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEmployeArrayList(curseur);
    }

    private ArrayList<Employe> cursorToEmployeArrayList(Cursor curseur){
        ArrayList<Employe> listeEmploye = new ArrayList<Employe>();
        long idE;
        String nomE;
        String prenomE;
        String mailE;
        int age;
        long idM;
        long idP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idE = curseur.getLong(0);
            nomE = curseur.getString(1);
            prenomE = curseur.getString(2);
            mailE = curseur.getString(3);
            age = curseur.getInt(4);
            idM = curseur.getLong(5);
            idP = curseur.getLong(6);
            listeEmploye.add(new Employe(idE,nomE,prenomE, mailE, age, idM, idP));
            curseur.moveToNext();
        }
        return listeEmploye;
    }
}
