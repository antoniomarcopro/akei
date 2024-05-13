package marco.haigniere.ohet.akei;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ActivityListeVehicules extends AppCompatActivity {
    private ListView listeVehicules;
    private ArrayList<Vehicule> vehicules;
    private VehiculeDAO vehiculeDAO;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_vehicules);

        Bundle bundleRecu = this.getIntent().getExtras();
        long idM = bundleRecu.getLong("idM");
        listeVehicules = findViewById(R.id.lv_vehicules);
        searchView = findViewById(R.id.sv_rech_vehicules);
        vehiculeDAO = new VehiculeDAO(getApplicationContext());
        vehicules = vehiculeDAO.getVehiculesByIdM(idM);

        ArrayAdapter<String> adapter = afficherListeVehicules();

        listeVehicules.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                vehicules = vehiculeDAO.getVehiculesByPlaqueMarqueCapacite(idM, newText);
                listeVehicules.setAdapter(afficherListeVehicules());
                return false;
            }
        });

        listeVehicules.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(),ActivityDetailVehicule.class);
            Bundle bundle = new Bundle();
            bundle.putLong("idV",vehiculeDAO.getVehiculesByIdM(idM).get(position).getIdV());
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
    public ArrayAdapter<String> afficherListeVehicules(){
        ArrayList<String> vehiculesTxt = new ArrayList<>();
        for (Vehicule vehicule : vehicules) {
            vehiculesTxt.add(vehicule.getPlaque() + "\n" + vehicule.getMarque() + "\n" + vehicule.getVolumeCoffre()+"m³");
        }
        return new ArrayAdapter<>(getApplicationContext(), R.layout.listview_element, vehiculesTxt);
    }
}