package marco.haigniere.ohet.akei;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class ProduitDAO {

    private static String base ="BDAkei";

    private static int version =1;

    private BdSQLiteOpenHelper accesBD;

    public ProduitDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addProduit(Produit unProduit){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("nomP", unProduit.getNomP());
        value.put("descTechnique", unProduit.getDescTechnique());
        value.put("prix",unProduit.getPrix());
        value.put("largeur",unProduit.getLargeur());
        value.put("longueur",unProduit.getLongueur());
        value.put("hauteur",unProduit.getHauteur());
        value.put("poids",unProduit.getPoids());
        value.put("idPi",unProduit.getIdPi());
        ret = bd.insert("produit", null, value);

        return ret;
    }

    public Produit getProduit(long idPr){
        Produit leProduit = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from produit where idPr="+idPr+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leProduit = new Produit(idPr,
                    curseur.getString(1),
                    curseur.getString(2),
                    curseur.getDouble(3),
                    curseur.getInt(4),
                    curseur.getInt(5),
                    curseur.getInt(6),
                    curseur.getInt(7),
                    curseur.getLong(8)
            );
        }
        return leProduit;
    }

    public ArrayList<Produit> getListeProduitsDuMagasin(long idPi){
        Cursor curseur;
        String req = "select * from Produit WHERE idPi="+idPi+";";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToProduitArrayList(curseur);
    }

    public ArrayList<Produit> getListeProduitsByMot(long idPi, String mot){
        Cursor curseur;
        String req = "select * from Produit WHERE idPi="+idPi+" AND (nomP LIKE \"%"+mot+"%\" OR descTechnique LIKE \"%"+mot+"%\");";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToProduitArrayList(curseur);
    }


    private ArrayList<Produit> cursorToProduitArrayList(Cursor curseur){
        ArrayList<Produit> listeProduit= new ArrayList<Produit>();
        long idPr;
        String nomP;
        String descTechnique;
        double prix;
        int largeur;
        int longueur;
        int hauteur;
        int poids;
        long idPi;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idPr = curseur.getLong(0);
            nomP = curseur.getString(1);
            descTechnique = curseur.getString(2);
            prix = curseur.getDouble(3);
            largeur = curseur.getInt(4);
            longueur = curseur.getInt(5);
            hauteur = curseur.getInt(6);
            poids = curseur.getInt(7);
            idPi = curseur.getLong(8);
            listeProduit.add(new Produit(idPr, nomP, descTechnique,prix, largeur,longueur, hauteur, poids, idPi));
            curseur.moveToNext();
        }
        return listeProduit;
    }



}
