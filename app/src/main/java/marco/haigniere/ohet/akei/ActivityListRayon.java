package marco.haigniere.ohet.akei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
public class ActivityListRayon extends AppCompatActivity {
    private ListView lv_listeR;

    private PieceDAO accesPiece;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rayon);
        accesPiece = new PieceDAO(getApplicationContext());
        lv_listeR = findViewById(R.id.ls_lstrayon);

        // recuperation de l'objet Bundle utilise pour transmettre des donnees
        Bundle bundleRecu = this.getIntent().getExtras();
        // recuperation des valeurs stockees dans des variables
        long idM = bundleRecu.getLong("idM");

        lv_listeR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), ActivityListEmploye.class);
                Bundle bundleATransmettre = new Bundle();
                bundleATransmettre.putLong("idrayon",accesPiece.getListeRayons().get(position).getIdPi());
                bundleATransmettre.putLong("idM",idM);
                intent.putExtras(bundleATransmettre);
                startActivity(intent);
            }
        });
        lv_listeR.setAdapter(afficherListeRayons());
    }


    public ArrayAdapter<String> afficherListeRayons() {
        ArrayList<Piece> lstRayon = accesPiece.getListeRayons();
        ArrayList<String> lstRayonTxt = new ArrayList<>();
        for (Piece rayon : lstRayon) { // lstRayon = liste parcourue
            lstRayonTxt.add(rayon.getNom()+"\n"+rayon.getDescription());
        }
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, R.layout.listview_element, lstRayonTxt);
        return itemsAdapter;
    }
}