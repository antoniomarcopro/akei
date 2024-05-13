package marco.haigniere.ohet.akei;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MagasinDAO {
    private static String base = "BDAkei";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public MagasinDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }
    public long addMagasin(Magasin magasin){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nom",magasin.getNom());
        value.put("numRue",magasin.getNumRue());
        value.put("nomRue",magasin.getNomRue());
        value.put("nomVille",magasin.getNomVille());
        value.put("numTel",magasin.getNumTel());

        ret = bd.insert("magasin",null,value);

        return ret;
    }

    public Magasin getMagasin(long idM){
        Magasin magasin = null;
        Cursor curseur = accesBD.getReadableDatabase().rawQuery("select * from magasin where idM="+idM+";", null);
        if(curseur.getCount() > 0) {
            curseur.moveToFirst();
            magasin = new Magasin(idM,curseur.getString(1),
                    curseur.getInt(2),
                    curseur.getString(3),
                    curseur.getString(4),
                    curseur.getString(5));
        }
        return magasin;
    }


    public ArrayList<Magasin> getMagasins(){
        Cursor curseur;
        String req = "select * from magasin";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToMagasinArrayList(curseur);
    }

    private ArrayList<Magasin> cursorToMagasinArrayList(Cursor curseur){
        ArrayList<Magasin> listeMagasins = new ArrayList<>();
        long idM;
        String nom;
        int numRue;
        String nomRue;
        String nomVille;
        String numTel;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idM = curseur.getLong(0);
            nom = curseur.getString(1);
            numRue = curseur.getInt(2);
            nomRue = curseur.getString(3);
            nomVille = curseur.getString(4);
            numTel = curseur.getString(5);
            listeMagasins.add(new Magasin(idM, nom, numRue, nomRue, nomVille, numTel));
            curseur.moveToNext();
        }

        return listeMagasins;
    }
}
