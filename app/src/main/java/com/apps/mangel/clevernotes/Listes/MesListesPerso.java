package com.apps.mangel.clevernotes.Listes;

import com.apps.mangel.clevernotes.Classes.GestionFichiers;
import com.apps.mangel.clevernotes.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vincent on 21/06/2016.
 */
public class MesListesPerso extends Fragment {

    /**
     * Event constructeur
     *
     * @param pInflater           inflater
     * @param pContainer          containeur
     * @param pSavedInstanceState bundle session
     * @return la vue
     */
    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState) {

        View lView = pInflater.inflate(R.layout.persolistes, pContainer, false);

        //VM - Return de la vue avec le bon layout
        return GestionFichiers.LoadAllFilesPerso(lView, getContext());

    }



}