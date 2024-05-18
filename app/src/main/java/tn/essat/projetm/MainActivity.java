package tn.essat.projetm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView matiereListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> matieres;
    private Mabase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new Mabase(this);

        matiereListView = findViewById(R.id.matiereListView);
        matieres = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.liste_defauts, R.id.titreTextView, matieres);
        matiereListView.setAdapter(adapter);

        Button addButton = findViewById(R.id.ajouterButton);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AjoutActivity.class);
            startActivity(intent);
        });

        refreshMatiereList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshMatiereList();
    }

    private void refreshMatiereList() {
        matieres.clear();
        matieres.addAll(dbHelper.getAllMatieres());
        adapter.notifyDataSetChanged();
    }
}
