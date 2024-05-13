package marco.haigniere.ohet.akei;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ActivityListeMagasins extends AppCompatActivity {
    private ListView listeMagasins;
    private ArrayList<Magasin> magasins;
    private MagasinDAO magasinDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_magasins);

        magasinDAO = new MagasinDAO(getApplicationContext());
        listeMagasins = findViewById(R.id.lv_magasins);
        magasins = magasinDAO.getMagasins();

        listeMagasins.setAdapter(afficherListeMagasins());

        listeMagasins.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(),ActivityDetailMagasin.class);
            Bundle bundle = new Bundle();
            bundle.putLong("idM",magasinDAO.getMagasins().get(position).getIdM());
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    public ArrayAdapter<String> afficherListeMagasins(){
        ArrayList<String> magasinsTxt = new ArrayList<>();
        for (Magasin magasin : magasins) {
            magasinsTxt.add(magasin.getNom());
        }
        return new ArrayAdapter<>(this, R.layout.listview_element, magasinsTxt);
    }
}