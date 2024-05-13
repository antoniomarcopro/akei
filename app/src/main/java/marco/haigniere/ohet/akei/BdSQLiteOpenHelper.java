package marco.haigniere.ohet.akei;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper {
    private String requeteMagasin="create table magasin (" +
            "idM INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nom TEXT NOT NULL," +
            "numRue INTEGER NOT NULL," +
            "nomRue TEXT NOT NULL," +
            "nomVille TEXT NOT NULL," +
            "numTel TEXT NOT NULL);";

    private String requeteVehicule="create table vehicule (" +
            "idV INTEGER PRIMARY KEY AUTOINCREMENT," +
            "longueur DOUBLE NOT NULL," +
            "largeur DOUBLE NOT NULL," +
            "hauteur DOUBLE NOT NULL," +
            "plaque TEXT NOT NULL," +
            "carburant TEXT NOT NULL," +
            "nbrKm INTEGER NOT NULL," +
            "volumeCoffre DOUBLE NOT NULL," +
            "typeVehicule TEXT NOT NULL," +
            "marque TEXT NOT NULL," +
            "modele TEXT NOT NULL," +
            "etat TEXT NOT NULL," +
            "idM INTEGER NOT NULL,"+
            "FOREIGN KEY(idM) REFERENCES Magasin(idM));";

    private String requetePiece="create table piece(" +
            "idPi INTEGER PRIMARY KEY AUTOINCREMENT," +
            "description TEXT NOT NULL," +
            "nom TEXT NOT NULL);";

    private String requeteEmploye="create table employe ("
            + "idE INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nomE TEXT NOT NULL,"
            + "prenomE TEXT NOT NULL,"
            + "mailE TEXT NOT NULL,"
            + "age INTEGER NOT NULL,"
            + "idM INTEGER NOT NULL,"
            + "idPi INTEGER NOT NULL,"
            + "FOREIGN KEY(idM) REFERENCES Magasin(idM),"
            + "FOREIGN KEY(idPi) REFERENCES Piece(idPi));";

    private String requeteProduit="create table produit ("
            + "idPr INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nomP TEXT NOT NULL,"
            + "descTechnique TEXT NOT NULL,"
            + "prix DOUBLE NOT NULL,"
	        + "largeur INTEGER NOT NULL,"
            + "longueur INTEGER NOT NULL,"
            + "hauteur INTEGER NOT NULL,"
            + "poids INTEGER NOT NULL,"
            + "idPi INTEGER NOT NULL,"
            + "FOREIGN KEY(idPi) REFERENCES Piece(idPI));";

    public BdSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(requeteMagasin);
        db.execSQL(requeteVehicule);
        db.execSQL(requetePiece);
        db.execSQL(requeteProduit);
        db.execSQL(requeteEmploye);
        db.execSQL("insert into magasin (nom, numRue, nomRue, nomVille, numTel) values('Akeitzondo', '727', 'Rue de Bayonex', 'Bayonne', '0727111600')");
        db.execSQL("insert into magasin (nom, numRue, nomRue, nomVille, numTel) values('Akeipön', '99', 'Siltatie', 'Ruotsi on perseestä', '+358785201260')");
        db.execSQL("insert into vehicule (longueur, largeur, hauteur, plaque, carburant, nbrKm, volumeCoffre, typeVehicule, marque, modele, etat, idM) values(2.5, 1.8, 2.0, 'WY-727-SI', 'Diesel', 190000, 50, 'SUV', 'Aston Martin', 'DBX 2024', 1, 1)");
        db.execSQL("insert into vehicule (longueur, largeur, hauteur, plaque, carburant, nbrKm, volumeCoffre, typeVehicule, marque, modele, etat, idM) values(2.3, 1.9, 2.2, 'KN-573-MI', 'GPL', 111600, 90, 'SUV', 'Dacia', 'DusterXL', 0, 1)");
        db.execSQL("insert into vehicule (longueur, largeur, hauteur, plaque, carburant, nbrKm, volumeCoffre, typeVehicule, marque, modele, etat, idM) values(2.8, 1.7, 1.8, 'NM-765-CO', 'SP95', 72700, 110, 'Coupe', 'Honda', 'Civic LX', 0, 2)");
        db.execSQL("insert into piece (description, nom) values(\"Pour les toilettes\", 'Toilettes & Salle de bain')");
        db.execSQL("insert into piece (description, nom) values(\"Pour le salon\", 'Salon')");
        db.execSQL("insert into piece (description, nom) values(\"Pour le jardin\", 'Jardin')");
        db.execSQL("insert into employe (nomE, prenomE, mailE, age, idM, idPi) values('Théo','Vesser', 'theo.vesser@hotmail.com',12,2,1);");
        db.execSQL("insert into employe (nomE, prenomE, mailE, age, idM, idPi) values('Alain','Térieur', 'terieur64@club-internet.fr',65,1,2);");
        db.execSQL("insert into employe (nomE, prenomE, mailE, age, idM, idPi) values('Alex','Térieur', '64terieur@wanadoo.com',65,1,3);");
        db.execSQL("insert into employe (nomE, prenomE, mailE, age, idM, idPi) values('Guy','Tarenbois', 'guymusik@gmail.com',33,2,2);");
        db.execSQL("insert into produit (nomP, descTechnique, prix, largeur, longueur, hauteur, poids, idPi) values('Tournevis','Parfait pour tourner et visser !', 10,33,2,2,100,1);");
        db.execSQL("insert into produit (nomP, descTechnique, prix, largeur, longueur, hauteur, poids, idPi) values('Gnome','Pour décorer', 90,4,20,999,1000,3);");
        db.execSQL("insert into produit (nomP, descTechnique, prix, largeur, longueur, hauteur, poids, idPi) values('Canapé','Les artisans de la qualité, et voilà',1044,3323,296,28,10,2);");
        db.execSQL("insert into produit (nomP, descTechnique, prix, largeur, longueur, hauteur, poids, idPi) values('Champignon','Récolté en octobre', 230,3223,244,72,44,3);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
