package marco.haigniere.ohet.akei;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button magasins;
    private Button produits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        magasins = findViewById(R.id.bt_magasins);
        produits = findViewById(R.id.bt_produits);

        magasins.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ActivityListeMagasins.class);
            startActivity(intent);
        });

        produits.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Activity_listerayons.class);
            startActivity(intent);
        });
    }
}
