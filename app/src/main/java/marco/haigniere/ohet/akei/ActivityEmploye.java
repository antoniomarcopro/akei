package marco.haigniere.ohet.akei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ActivityEmploye extends AppCompatActivity {
    private EmployeDAO accesEmploye;
    private Bundle bundleRecu;
    private TextView tv_detailemploye;
    private long idE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe);

        accesEmploye = new EmployeDAO(getApplicationContext());
        tv_detailemploye = findViewById(R.id.tv_detailemploye);
        bundleRecu = this.getIntent().getExtras();
        idE = bundleRecu.getLong("idE");

        Employe unEmploye = accesEmploye.getEmploye(idE);

        String txtEmploye = "\n Nom : " + unEmploye.getNomE() + "\n Prenom : " + unEmploye.getPrenomE() + " \n Mail : " + unEmploye.getMailE() + "\n Age : " + unEmploye.getAge();
        tv_detailemploye.setText(txtEmploye);

    }
}