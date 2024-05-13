package marco.haigniere.ohet.akei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_listerayons extends AppCompatActivity {

    private ListView lv_listeR;

    private PieceDAO accesPiece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listerayons);
        accesPiece = new PieceDAO(getApplicationContext());
        lv_listeR = findViewById(R.id.lv_listeR);

        lv_listeR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Activity_listeproduit.class);
                Bundle bundleATransmettre = new Bundle();
                bundleATransmettre.putLong("idrayon",accesPiece.getListeRayons().get(position).getIdPi());// récupérer l'id d'un rayon
                intent.putExtras(bundleATransmettre );
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
            Log.d("lesRayons", rayon.getNom());
        }
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, R.layout.listview_element, lstRayonTxt);
        return itemsAdapter;
    }
}
