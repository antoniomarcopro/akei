package marco.haigniere.ohet.akei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


public class ActivityListEmploye extends AppCompatActivity {

    private ListView lv_employe;
    private EmployeDAO accesEmploye ;
    private Bundle bundleRecu;
    private long idM;
    private long idPi;
    private Button bt_rechercher;

    private SearchView sv_liste;

    private ArrayList<Employe> lstEmploye = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employe);

        accesEmploye = new EmployeDAO(getApplicationContext());
        lv_employe = findViewById(R.id.lv_employe);
        //bt_rechercher = findViewById(R.id.bt_rechercher);
        sv_liste = findViewById(R.id.sv_liste);

        bundleRecu = ActivityListEmploye.this.getIntent().getExtras();
        idM = bundleRecu.getLong("idM");
        idPi = bundleRecu.getLong("idrayon");

        EmployeDAO employeAcces = new EmployeDAO(getApplicationContext());
        lstEmploye = employeAcces.getEmployesByIdMIdPi(idM,idPi);

        ArrayAdapter<String> adapter = afficherListeEmployes();

        lv_employe.setAdapter(adapter);

        sv_liste.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                lstEmploye = employeAcces.getEmployesByNomPrenom(idM,idPi,newText);
                lv_employe.setAdapter(afficherListeEmployes());
                return false;
            }
        });

        lv_employe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), ActivityEmploye.class);
                Bundle bundleATransmettre = new Bundle();
                Employe employe = accesEmploye.getEmployesByIdMIdPi(idM,idPi).get(position);
                bundleATransmettre.putLong("idE", employe.getIdE());
                intent.putExtras(bundleATransmettre);
                startActivity(intent);
            }
        });

    }
    public ArrayAdapter<String> afficherListeEmployes() {
        //ArrayList<Employe> lstEmploye = accesEmploye.getEmployesByIdMIdPi(idM,idPi);
        ArrayList<String> lstEmployeTxt = new ArrayList<>();
        MagasinDAO accesmagasin = new MagasinDAO(getApplicationContext());
        for (Employe employe : lstEmploye) {
            lstEmployeTxt.add(employe.getNomE() + " "+ employe.getPrenomE() +"\n"+ accesmagasin.getMagasin(employe.getIdM()).getNom());
        }
        return new ArrayAdapter<>(getApplicationContext(), R.layout.listview_element, lstEmployeTxt);
    }
}