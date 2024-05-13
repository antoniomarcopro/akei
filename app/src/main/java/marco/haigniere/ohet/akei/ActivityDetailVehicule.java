package marco.haigniere.ohet.akei;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ActivityDetailVehicule extends AppCompatActivity {
    private VehiculeDAO vehiculeDAO;
    private Vehicule vehicule;
    private ListView detailsVehicule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);

        Bundle bundle = this.getIntent().getExtras();
        vehiculeDAO = new VehiculeDAO(getApplicationContext());
        detailsVehicule = findViewById(R.id.lv_detail_vehicule);

        vehicule = vehiculeDAO.getVehicule(bundle.getLong("idV"));

        detailsVehicule.setAdapter(afficherDetailVehicule());
    }

    public ArrayAdapter<String> afficherDetailVehicule(){
        ArrayList<String> detailsVehicule = new ArrayList<>();
        detailsVehicule.add("Plaque : " + vehicule.getPlaque());
        detailsVehicule.add("Marque : " + vehicule.getMarque());
        detailsVehicule.add("Modele : " + vehicule.getModele());
        detailsVehicule.add("Type de véhicule : " + vehicule.getTypeVehicule());
        detailsVehicule.add("Carburant : " + vehicule.getCarburant());
        detailsVehicule.add("Nombre de km : " + vehicule.getNbrKm());
        detailsVehicule.add("Longueur : " + vehicule.getLongueur());
        detailsVehicule.add("Largeur : " + vehicule.getLargeur());
        detailsVehicule.add("Hauteur : " + vehicule.getHauteur());
        detailsVehicule.add("Volume du coffre : " + vehicule.getVolumeCoffre());
        detailsVehicule.add("Bloqué ? " + ((vehicule.isEtat()) ? "Oui" : "Non"));
        return new ArrayAdapter<>(this, R.layout.listview_element, detailsVehicule);
    }
}