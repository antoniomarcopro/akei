package marco.haigniere.ohet.akei;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PieceDAO {

    private static String base = "BDAkei";

    private static int version = 1;

    private BdSQLiteOpenHelper accesBD;

    public PieceDAO(Context ct) {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public long addPiece(Piece unePiece) {
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("description", unePiece.getDescription());
        value.put("String", unePiece.getNom());
        ret = bd.insert("piece", null, value);

        return ret;
    }

    public Piece getPiece(long idPi) {
        Piece laPiece = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from piece where idPi=" + idPi + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            laPiece = new Piece(idPi,
                    curseur.getString(1),
                    curseur.getString(2)
            );
        }
        return laPiece;
    }

    public ArrayList<Piece> getListeRayons(){
        Cursor curseur;
        String req = "select * from Piece;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToPieceArrayList(curseur);
    }

    private ArrayList<Piece> cursorToPieceArrayList(Cursor curseur){
        ArrayList<Piece> listePiece = new ArrayList<Piece>();
        long idPi;
        String description;
        String nom;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idPi = curseur.getLong(0);
            description = curseur.getString(1);
            nom = curseur.getString(2);
            listePiece.add(new Piece(idPi,description,nom));
            curseur.moveToNext();
        }
        return listePiece;
    }
}