package marco.haigniere.ohet.akei;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Activity_detailproduit extends AppCompatActivity {
    private ProduitDAO accesProduit;
    private Bundle bundleRecu;

    private TextView tv_detailproduit;
    private long idPr;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailproduit);
        accesProduit = new ProduitDAO(getApplicationContext());
        tv_detailproduit = findViewById(R.id.tv_detailproduit);
        bundleRecu = Activity_detailproduit.this.getIntent().getExtras();
        idPr = bundleRecu.getLong("idproduit");
        Produit unProduit = accesProduit.getProduit(idPr);
        String txtProduit = "\n Nom : " + unProduit.getNomP() + "\n Description : "  +unProduit.getDescTechnique() +  "\n Prix : "  + unProduit.getPrix()+ "\n Largeur : " +unProduit.getLargeur()+"\n Longueur : "+unProduit.getLongueur()+"\n Hauteur : "+unProduit.getHauteur()+"\n Poids : "+unProduit.getPoids();
        tv_detailproduit.setText(txtProduit);

    }





}

