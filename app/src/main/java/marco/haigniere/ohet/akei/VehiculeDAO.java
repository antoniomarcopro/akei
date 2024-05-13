package marco.haigniere.ohet.akei;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class VehiculeDAO {
    private static String base = "BDAkei";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public VehiculeDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }
    public long addVehicule(Vehicule vehicule){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("longueur",vehicule.getLongueur());
        value.put("largeur",vehicule.getLargeur());
        value.put("hauteur",vehicule.getHauteur());
        value.put("plaque",vehicule.getPlaque());
        value.put("carburant",vehicule.getCarburant());
        value.put("nbrKm",vehicule.getNbrKm());
        value.put("volumeCoffre",vehicule.getVolumeCoffre());
        value.put("typeVehicule",vehicule.getTypeVehicule());
        value.put("marque",vehicule.getMarque());
        value.put("modele",vehicule.getModele());
        value.put("etat",vehicule.isEtat());
        value.put("idM",vehicule.getIdM());

        ret = bd.insert("vehicule",null,value);

        return ret;
    }

    public Vehicule getVehicule(long idV){
        Vehicule vehicule = null;
        Cursor curseur = accesBD.getReadableDatabase().rawQuery("select * from vehicule where idV="+idV+";", null);
        if(curseur.getCount() > 0) {
            curseur.moveToFirst();
            vehicule = new Vehicule(idV,
                    curseur.getDouble(1),
                    curseur.getDouble(2),
                    curseur.getDouble(3),
                    curseur.getString(4),
                    curseur.getString(5),
                    curseur.getInt(6),
                    curseur.getDouble(7),
                    curseur.getString(8),
                    curseur.getString(9),
                    curseur.getString(10),
                    curseur.getInt(11) > 0,
                    curseur.getLong(12));
        }
        return vehicule;
    }

    public ArrayList<Vehicule> getVehicules(){
        Cursor curseur;
        String req = "select * from vehicule";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToVehiculeArrayList(curseur);
    }


    public ArrayList<Vehicule> getVehiculesByIdM(long idM){
        Cursor curseur;
        String req = "select * from vehicule where idM="+idM+";";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToVehiculeArrayList(curseur);
    }

    public ArrayList<Vehicule> getVehiculesByPlaqueMarqueCapacite(long idM, String text){
        Cursor curseur;
        String req = "select * from vehicule where idM="+idM+" and (plaque like '%"+text+"%' or marque like '%"+text+"%' or CAST(volumeCoffre AS VARCHAR) like '"+text+"%');";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToVehiculeArrayList(curseur);
    }

    private ArrayList<Vehicule> cursorToVehiculeArrayList(Cursor curseur){
        ArrayList<Vehicule> listeVehicule = new ArrayList<>();
        long idV;
        double longueur;
        double largeur;
        double hauteur;
        String plaque;
        String carburant;
        int nbrKm;
        double volumeCoffre;
        String typeVehicule;
        String marque;
        String modele;
        boolean etat;
        long idM;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idV             = curseur.getLong(0);
            longueur        = curseur.getDouble(1);
            largeur         = curseur.getDouble(2);
            hauteur         = curseur.getDouble(3);
            plaque          = curseur.getString(4);
            carburant       = curseur.getString(5);
            nbrKm           = curseur.getInt(6);
            volumeCoffre    = curseur.getDouble(7);
            typeVehicule    = curseur.getString(8);
            marque          = curseur.getString(9);
            modele          = curseur.getString(10);
            etat            = curseur.getInt(11) > 0;
            idM             = curseur.getLong(12);

            listeVehicule.add(new Vehicule(idV, longueur, largeur, hauteur, plaque, carburant, nbrKm, volumeCoffre, typeVehicule, marque, modele, etat, idM));
            curseur.moveToNext();
        }

        return listeVehicule;
    }
}
