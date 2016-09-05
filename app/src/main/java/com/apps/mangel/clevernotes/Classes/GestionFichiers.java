package com.apps.mangel.clevernotes.Classes;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.mangel.clevernotes.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Créé by Vincent on 04/09/2016.
 */
public class GestionFichiers {

    public static View LoadAllFilesPerso(View pView, Context pContext) {

        final Context lContext = pContext;
        File[] files = lContext.getFilesDir().listFiles();

        if(files == null)
        {
            return pView;
        }


        ArrayList<String> lListeItems = new ArrayList<>();
        ArrayAdapter<String> adapter;
        lListeItems.clear();
        for (File lFile : files) {
            //Read text from file
            StringBuilder lText = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(lFile));
                String line;

                while ((line = br.readLine()) != null) {
                    lText.append(line);
                }
                br.close();

                String[] lSplitted = lText.toString().split("µµ");
                for (String lString : lSplitted) {
                    if (lString.startsWith("TITRE=")) {
                        lListeItems.add(lString.replace("TITRE=", ""));
                    }
                }

                ArrayAdapter<String> ladapter = new ArrayAdapter<String>(lContext,
                        android.R.layout.simple_list_item_1, lListeItems);

                ((ListView) ((RelativeLayout) pView).getChildAt(0)).setAdapter(ladapter);


                ((ListView)((RelativeLayout) pView).getChildAt(0)).setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                // selected item
                                String selected = ((TextView) view).getText().toString();

                                Toast toast = Toast.makeText(lContext, selected, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });

            } catch (IOException e) {
                //You'll need to add proper error handling here
            }
        }
        return pView;
    }

    public static String GetDefaultName(Enums.TypeObjet pType, Context pContext)
    {
        final Context lContext = pContext;
        File[] lFiles = lContext.getFilesDir().listFiles();

        ArrayList<String> lListeItems = new ArrayList<>();
        lListeItems.clear();

        String lTitre;

        switch (pType)
        {
            case Brouillon:
                lTitre  = pContext.getResources().getString(R.string.DefaultNameBrouillon);
                break;
            case Liste:
                lTitre  = pContext.getResources().getString(R.string.DefaultNameListe);

                break;
            case ListeDesordonee:
                lTitre  = pContext.getResources().getString(R.string.DefaultNameListeDeso);

                break;
            case ListeEtapes:
                lTitre  = pContext.getResources().getString(R.string.DefaultNameListeEtapes);
                break;
            default:
                lTitre  = pContext.getResources().getString(R.string.DefaultNameBrouillon);
                break;
        }

        if(lFiles == null)
        {
            return lTitre + " 1";
        }
        else {
            return lTitre + " " + GetNumberOfOccurences(lTitre, lFiles);
        }
    }

    private static int GetNumberOfOccurences(String pTitreDef, File[] pFiles)
    {
        int NbOccurences =0;

        for (File lFile : pFiles) {
            //Read text from file
            StringBuilder lText = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(lFile));
                String line;

                while ((line = br.readLine()) != null) {
                    lText.append(line);
                }
                br.close();

                String[] lSplitted = lText.toString().split("µµ");
                for (String lString : lSplitted) {
                    if (lString.startsWith("TITRE=") && lString.replace("TITRE=", "").startsWith(pTitreDef)) {
                        NbOccurences++;
                    }
                }
            } catch (IOException e) {
                //You'll need to add proper error handling here
            }
        }
        return NbOccurences+1;
    }

}
