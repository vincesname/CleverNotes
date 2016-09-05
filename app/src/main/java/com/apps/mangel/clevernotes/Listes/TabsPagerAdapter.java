package com.apps.mangel.clevernotes.Listes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Vincent on 20/06/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    /**
     * Constructeur
     * @param pFm manager
     */
    public TabsPagerAdapter(FragmentManager pFm) {
        //VM - Call du super
        super(pFm);
    }

    /**
     * Charge l'item correspondant à l'index
     * @param pIndex index de l'item
     * @return l'item (fragment activity)
     */
    @Override
    public Fragment getItem(int pIndex) {
        switch (pIndex) {
            case 0:
                //VM - Activite Fragment Listes persos
                return new MesListesPerso();
            case 1:
                //VM - Activite Fragment Listes privées
                return new MesListesPrive();
            case 2:
                //VM - Activite Fragment Listes publiques
                return new MesListesPublic();
        }

        return null;
    }

    /**
     * Return le nombre d'items
     * @return le nombre items
     */
    @Override
    public int getCount() {
        //VM - On a trois items
        return 3;
    }


}