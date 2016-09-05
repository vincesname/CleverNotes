package com.apps.mangel.clevernotes.Classes;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.mangel.clevernotes.Customs.ListItem;
import com.apps.mangel.clevernotes.Customs.ListViewAdapter;
import com.apps.mangel.clevernotes.R;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Créé by Vincent on 23/06/2016.
 */
public class Objet {

    //region Déclaration des variables
    private static String mTitre;
    private static Enums.TypeObjet mTypeObjet;
    private static ArrayList<ObjetItem> mListeItem = new ArrayList<ObjetItem>();
    private static String mDescription;
    //UTILISATEUR
    private static Date mDateCreation;
    //endregion Déclaration des variables

    //region Get/Set des variables
    //VM - Titre
    public static String GetTitre() {
        return mTitre;
    }

    public static void SetTitre(String pString) {
        mTitre = pString;
    }

    //VM - Description
    public static String GetDescription() {
        return mDescription;
    }

    public static void SetDescription(String pString) {
        mDescription = pString;
    }

    //VM - Date création
    public static Date GetDate() {
        return mDateCreation;
    }

    public static void SetDate(Date pDate) {
        mDateCreation = pDate;
    }

    //VM - Liste Item
    public static ArrayList<ObjetItem> GetListeItem() {
        return mListeItem;
    }

    public static void SetListeItem(ArrayList<ObjetItem> pList) {
        mListeItem = pList;
    }

    //VM - TypeObjet
    public static Enums.TypeObjet GetTypeObjet() {
        return mTypeObjet;
    }

    public static void SetTypeObjet(Enums.TypeObjet pTypeObjet) {
        mTypeObjet = pTypeObjet;
    }
    //endregion Get/Set des variables


    /**
     * Constructeur
     *
     * @param pTitre        Titre
     * @param pDescription  Description
     * @param pDateCreation Date de création
     */
    public Objet(String pTitre, String pDescription, Date pDateCreation, Enums.TypeObjet pTypeObjet) {
        this.mTitre = pTitre;
        this.mDescription = pDescription;
        this.mDateCreation = pDateCreation;
        this.mTypeObjet = pTypeObjet;
    }

    /**
     * Constructeur
     *
     * @param pString Valeurs
     */
    public Objet(String pString) {
        String[] lTabSplitted = pString.split("µµ");
        for (String lChamp : lTabSplitted) {
            if (lChamp.startsWith("TITRE=")) {
                this.mTitre = lChamp.replace("TITRE=", "");
            } else if (lChamp.startsWith("TYPEOBJET=")) {
                this.mTypeObjet = Enums.FromString(lChamp.replace("TYPEOBJET=", ""));
            } else if (lChamp.startsWith("DESCRIPTION=")) {
                this.mDescription = lChamp.replace("DESCRIPTION=", "");
            } else if (lChamp.startsWith("DATE=")) {
                this.mDateCreation = new Date(lChamp.replace("DATE=", ""));
            }
        }
    }

    public static void SauvegarderObjet(Context pContext, Activity pActivity) {
        String filename = GetTitre();
        //String lTexteSaisi = ((TextView) findViewById(R.id.SaisieBrouillon)).getText().toString();
        //String lTexteSaisi = "";

        switch (mTypeObjet) {
            case Brouillon:
                String lTexteSaisi = ((TextView) pActivity.findViewById(R.id.SaisieBrouillon)).getText().toString();
                ObjetItem lTexteBrouillon = new ObjetItem(lTexteSaisi, 0, true);
                mListeItem.add(lTexteBrouillon);
                break;

            case Liste:

                try {
                    ListView lListe = (ListView) pActivity.findViewById(R.id.EditerListeView);
                    HeaderViewListAdapter lAd  = (HeaderViewListAdapter) lListe.getAdapter();
                    ListViewAdapter lAdapter = (ListViewAdapter) lAd.getWrappedAdapter();
                    ArrayList<ListItem> lListeItems = lAdapter.myItems;
                    for (int i = 0; i < lListeItems.size(); i++) {
                        ListItem lItem = lListeItems.get(i);
                        ObjetItem lItemListe = new ObjetItem(lItem.caption, i, true);
                        mListeItem.add(lItemListe);
                    }
                }
                catch (Exception ex)
                {
                    Toast.makeText(pContext, ex.getMessage(), Toast.LENGTH_LONG).show();
                }
                break;

            case ListeDesordonee:
                break;
            case ListeEtapes:
                break;

        }

        FileOutputStream outputStream;

        try {
            String lUniqueId = Settings.Secure.getString(pContext.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            int lDate = Calendar.getInstance().get(Calendar.SECOND);
            outputStream = pContext.openFileOutput(lUniqueId + "_" + lDate, Context.MODE_PRIVATE);
            outputStream.write(GetCorpsObjet().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pActivity.finish();
    }

    public static String GetCorpsObjet() {
        String lRes;
        String lTitre = "TITRE=" + mTitre;
        String lType = "TYPEOBJET=" + Enums.ToString(mTypeObjet);
        String lDescription = "DESCRIPTION=" + mDescription;
        String lCorps = "TEXTE=" + GetItemsToString();
        lRes = lTitre + "µµ" + lType + "µµ" + lDescription + "µµ" + lCorps + "µµ";
        return lRes;
    }

    @Override
    public String toString() {
        String lRes = "";
        lRes += "TITRE=" + this.mTitre + "µµ";
        lRes += "TYPEOBJET=" + Enums.ToString(this.mTypeObjet) + "µµ";
        lRes += "DESCRIPTION=" + this.mDescription + "µµ";
        lRes += "DATE=" + this.mDateCreation.toString() + "µµ";
        return lRes;
    }

    public static String GetItemsToString() {
        String lRes = "";
        for (ObjetItem lItem : mListeItem) {
            lRes += lItem.toString() + "µ$µ";
        }
        return lRes;
    }


}


