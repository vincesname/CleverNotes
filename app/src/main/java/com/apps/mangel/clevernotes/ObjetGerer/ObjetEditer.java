package com.apps.mangel.clevernotes.ObjetGerer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.mangel.clevernotes.Classes.Enums;
import com.apps.mangel.clevernotes.Classes.Objet;
import com.apps.mangel.clevernotes.Classes.ObjetItem;
import com.apps.mangel.clevernotes.Customs.ListItem;
import com.apps.mangel.clevernotes.Customs.ListViewAdapter;
import com.apps.mangel.clevernotes.Customs.ListViewCheckAdapter;
import com.apps.mangel.clevernotes.R;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * Créé by Vincent on 12/07/2016.
 */
public class ObjetEditer extends AppCompatActivity {

    Objet mObjet;


    //Liste
    public ListView ListeSimple;
    public ListView ListeDesordonnee;
    private ListViewAdapter mAdapterListe;
    private ListViewCheckAdapter mAdapterListeDeso;


    /**
     * Event constructor
     * @param savedInstanceState Bundle session
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //VM - call du super
        super.onCreate(savedInstanceState);
        //VM - Récupération des extras
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            mObjet = new Objet(getIntent().getStringExtra("Objet"));
            View lFooterView = getLayoutInflater().inflate(R.layout.objetediterlistefooter, null);
            Button lButtonFooter;
            switch (mObjet.GetTypeObjet())
            {
                case Brouillon:
                    setContentView(R.layout.objetediterbrouillon);
                    break;
                case Liste:
                    setContentView(R.layout.objetediterliste);

                    ListeSimple = (ListView) findViewById(R.id.EditerListeView);
                    ListeSimple.setItemsCanFocus(true);
                    mAdapterListe = new ListViewAdapter(this);

                    lFooterView = getLayoutInflater().inflate(R.layout.objetediterlistefooter, null);
                    ListeSimple.addFooterView(lFooterView);

                    ListeSimple.setAdapter(mAdapterListe);

                    lButtonFooter = (Button) findViewById(R.id.ButtonAjouterListe);
                    assert lButtonFooter != null;
                    lButtonFooter.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        ListItem listItem = new ListItem();
                        listItem.caption = "Nouvelle ligne";
                        mAdapterListe.myItems.add(listItem);
                        ListeSimple.setAdapter(mAdapterListe);
                    }
                });
                    break;
                case ListeDesordonee:
                    setContentView(R.layout.objetediterlistedesordonnee);

                    mAdapterListeDeso = new ListViewCheckAdapter(mObjet.GetListeItem(), this);
                    ListeDesordonnee = (ListView) findViewById(R.id.EditerCheckView);
                    // Assign adapter to ListView



                    ListeDesordonnee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // When clicked, show a toast with the TextView text
                            ObjetItem lObjetItem = (ObjetItem) parent.getItemAtPosition(position);
                            Toast.makeText(getApplicationContext(),
                                    "Clicked on Row: " + lObjetItem.GetTexte(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                    lFooterView = getLayoutInflater().inflate(R.layout.objetediterlistefooter, null);
                    ListeDesordonnee.addFooterView(lFooterView);

                    ListeDesordonnee.setAdapter(mAdapterListeDeso);

                    lButtonFooter = (Button) findViewById(R.id.ButtonAjouterListe);
                    assert lButtonFooter != null;
                    lButtonFooter.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                           ObjetItem lObjetItem = new ObjetItem("", mAdapterListeDeso.getCount()+1,false);
                            mAdapterListeDeso.mListeObjetItems.add(lObjetItem);
                            ListeDesordonnee.setAdapter(mAdapterListeDeso);
                        }
                    });

                    break;
            }

            TextView lTexteTitre = (TextView) findViewById(R.id.TitreObjet);
            lTexteTitre.setText(mObjet.GetTitre());

            ImageButton lButtonSave = (ImageButton) findViewById(R.id.ButtonSauvegarder);
            assert lButtonSave != null;
            lButtonSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mObjet.SauvegarderObjet(getApplicationContext(), ObjetEditer.this);
                }
            });

            //Button Supprimer
            final ImageButton lButtonSuppr = (ImageButton) findViewById(R.id.ButtonDel);
            assert lButtonSuppr != null;
            lButtonSuppr.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //mObjet.SauvegarderObjet(getApplicationContext(), ObjetEditer.this);
                }
            });

            //Button Editer
            final ImageButton lButtonEditer = (ImageButton) findViewById(R.id.ButtonEditer);
            assert lButtonEditer != null;
            lButtonEditer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //VM - Set du layout
                    Intent i = new Intent(getApplicationContext(), ObjetCreer.class);
                    i.putExtra("Objet", mObjet.toString());
                    startActivity(i);
                    finish();
                }
            });

            lButtonEditer.setVisibility(View.INVISIBLE);
            lButtonSuppr.setVisibility(View.INVISIBLE);

            //Button Params
            ImageButton lButtonParams = (ImageButton) findViewById(R.id.ButtonParams);
            assert lButtonParams != null;
            lButtonParams.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(lButtonEditer.getVisibility() == View.VISIBLE) {
                        lButtonEditer.setVisibility(View.INVISIBLE);
                        lButtonSuppr.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        lButtonEditer.setVisibility(View.VISIBLE);
                        lButtonSuppr.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
}
