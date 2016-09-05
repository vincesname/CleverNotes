package com.apps.mangel.clevernotes;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.apps.mangel.clevernotes.Listes.MesListes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    /**
     * Event constructor
     * @param savedInstanceState Bundle session
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //VM - call du super
        super.onCreate(savedInstanceState);
        //VM - Set du layout
        setContentView(R.layout.activity_main);
        try{
            File mydir = this.getDir("Brouillons", Context.MODE_PRIVATE);
            mydir = this.getDir("Listes", Context.MODE_PRIVATE);
            mydir = this.getDir("ListesOrdonnee", Context.MODE_PRIVATE);
            mydir = this.getDir("ListeEtapes", Context.MODE_PRIVATE);
        }
        catch  (Exception e) {}

        //Ajout de l'event clic sur le bouton "Mes listes"
        final Button button = (Button) findViewById(R.id.buttonMesListes);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //VM - Goto activity Mes Listes
                startActivity(new Intent(MainActivity.this, MesListes.class));
            }
        });
    }
}
