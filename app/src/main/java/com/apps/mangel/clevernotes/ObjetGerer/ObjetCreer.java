package com.apps.mangel.clevernotes.ObjetGerer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.mangel.clevernotes.Classes.Enums;
import com.apps.mangel.clevernotes.Classes.Objet;
import com.apps.mangel.clevernotes.R;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

/**
 * Créé by Vincent on 23/06/2016.
 */
public class ObjetCreer extends AppCompatActivity {

    Enums.TypeObjet mTypeObjet;
    Objet mObjet;
    EditText mEditTitre;
    EditText mEditDesc;


    /**
     * Event constructor
     * @param savedInstanceState Bundle session
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //VM - call du super
        super.onCreate(savedInstanceState);
        //VM - Set du layout
        setContentView(R.layout.objetcreer);
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            mObjet = new Objet(getIntent().getStringExtra("Objet"));
            final TextView lTexteTitre = (TextView) findViewById(R.id.TextTitleObjetCreer);
            lTexteTitre.setText(Enums.GetTitreFromTypeObjet(mObjet.GetTypeObjet()));

            mEditTitre = (EditText) findViewById(R.id.SaisieTitreObjet);
            mEditTitre.setText(mObjet.GetTitre());

            mEditDesc = (EditText) findViewById(R.id.SaisieDescObjet);
            mEditDesc.setText(mObjet.GetDescription());
        }


        //Ajout de l'event clic sur le bouton "Suivant"
        final Button lButtonSuivant = (Button) findViewById(R.id.ButtonNext);
        assert lButtonSuivant != null;
        lButtonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //VM - Set du layout
                Intent i = new Intent(getApplicationContext(), ObjetEditer.class);
                mObjet.SetTitre(mEditTitre.getText().toString());
                mObjet.SetDescription(mEditDesc.getText().toString());
                i.putExtra("Objet", mObjet.toString());
                startActivity(i);
                finish();
            }
        });
    }
}
