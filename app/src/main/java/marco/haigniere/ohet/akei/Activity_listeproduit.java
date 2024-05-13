package marco.haigniere.ohet.akei;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Activity_listeproduit extends AppCompatActivity {

    private ImageView imageView2;
    private TextView tv_lesproduits;
    private ListView lv_listeP;

    private ArrayList<Produit> lstProduits = new ArrayList<>();

    private EditText et_mot;

    private Button b_rechercher;
    private ProduitDAO accesProduit ;

    private Bundle bundleRecu;
    private long idPi;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeproduit);
        accesProduit = new ProduitDAO(getApplicationContext());
        imageView2 = findViewById(R.id.imageView2);
        tv_lesproduits = findViewById(R.id.tv_lesproduits);
        lv_listeP = findViewById(R.id.lv_listeP);
        et_mot = findViewById(R.id.et_mot);
        b_rechercher = findViewById(R.id.b_rechercher);
        bundleRecu = Activity_listeproduit.this.getIntent().getExtras();
        idPi = bundleRecu.getLong("idrayon");
        lv_listeP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Activity_detailproduit.class);
                Bundle bundleATransmettre = new Bundle();
                bundleATransmettre.putLong("idproduit", accesProduit.getListeProduitsDuMagasin(idPi).get(position).getIdPr());
                intent.putExtras(bundleATransmettre );
                startActivity(intent);
            }
        });
        b_rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String mot = et_mot.getText()+"";
                lstProduits = accesProduit.getListeProduitsByMot(idPi, mot);
                lv_listeP.setAdapter(afficherListeProduits());
            }
        });
        lstProduits = accesProduit.getListeProduitsDuMagasin(idPi);
        lv_listeP.setAdapter(afficherListeProduits());
    }

    public ArrayAdapter<String>afficherListeProduits() {
        ArrayList<String> lstProduitTxt = new ArrayList<>();
        for (Produit prod8 : lstProduits) { // lstRayon = liste parcourue
            lstProduitTxt.add(prod8.getNomP() + "\n" + prod8.getDescTechnique());
        }
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, R.layout.listview_element, lstProduitTxt);
        return itemsAdapter;
    }


}
