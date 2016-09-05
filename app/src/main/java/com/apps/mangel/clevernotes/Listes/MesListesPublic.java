package com.apps.mangel.clevernotes.Listes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.mangel.clevernotes.R;

public class MesListesPublic extends Fragment {

    /**
     * Event constructeur
     * @param pInflater inflater
     * @param pContainer containeur
     * @param pSavedInstanceState bundle session
     * @return la vue
     */
    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState) {
        //VM - Return de la vue avec le bon layout
        return pInflater.inflate(R.layout.publiclistes, pContainer, false);

    }
}