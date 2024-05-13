package marco.haigniere.ohet.akei;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityDetailMagasin extends AppCompatActivity {
    private Button vehicules;
    private Button employes;
    private MagasinDAO magasinDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_magasin);

        vehicules = findViewById(R.id.bt_vehicules);
        employes = findViewById(R.id.bt_employes);
        Bundle bundle = this.getIntent().getExtras();

        vehicules.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ActivityListeVehicules.class);
            Bundle bundle2 = new Bundle();
            bundle2.putLong("idM", bundle.getLong("idM"));
            intent.putExtras(bundle2);
            startActivity(intent);
        });

        employes.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ActivityListRayon.class);
            Bundle bundle3 = new Bundle();
            bundle3.putLong("idM",bundle.getLong("idM"));
            intent.putExtras(bundle3);
            startActivity(intent);
        });
    }
}