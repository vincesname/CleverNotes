package com.apps.mangel.clevernotes.ObjetGerer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apps.mangel.clevernotes.R;

/**
 * Créé by Vincent on 24/06/2016.
 */

public class ObjetTypeFragm extends Fragment {

    private int mPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.objettypebrouillon, container, false);;

        switch (mPosition)
        {
            case 0:
                Toast.makeText(this.getContext(), "Page "+mPosition, Toast.LENGTH_SHORT).show();
                rootView = (ViewGroup) inflater.inflate(R.layout.objettypebrouillon, container, false);
                break;
            case 1:
                Toast.makeText(this.getContext(), "Page "+mPosition, Toast.LENGTH_SHORT).show();
                rootView = (ViewGroup) inflater.inflate(R.layout.objettypeliste, container, false);
                break;
            case 2:
                Toast.makeText(this.getContext(), "Page "+mPosition, Toast.LENGTH_SHORT).show();
                rootView = (ViewGroup) inflater.inflate(R.layout.objettypelisteunorder, container, false);
                break;
            case 3:
                Toast.makeText(this.getContext(), "Page "+mPosition, Toast.LENGTH_SHORT).show();
                rootView = (ViewGroup) inflater.inflate(R.layout.objettyypeetape, container, false);
                break;
            default:
                Toast.makeText(this.getContext(), "Page inconnue", Toast.LENGTH_SHORT).show();
                break;
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle lol = this.getArguments();

        int lPosition = 0;
        try {
            lPosition=  lol.getInt("position");
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "ERREUR", Toast.LENGTH_SHORT).show();
        }

        mPosition = lPosition;
    }
}