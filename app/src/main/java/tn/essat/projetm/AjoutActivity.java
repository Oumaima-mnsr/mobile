package tn.essat.projetm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutActivity extends AppCompatActivity {

    private Mabase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        dbHelper = new Mabase(this);

        final EditText titreEditText = findViewById(R.id.titreEditText);
        final EditText niveauEditText = findViewById(R.id.niveauEditText);
        Button ajouterButton = findViewById(R.id.ajouterButton);

        ajouterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titre = titreEditText.getText().toString();
                String niveau = niveauEditText.getText().toString();
                if (!titre.isEmpty() && !niveau.isEmpty()) {
                    dbHelper.insertMatiere(titre, niveau);
                    Intent intent = new Intent(AjoutActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}


