package com.apps.mangel.clevernotes.Listes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.apps.mangel.clevernotes.ObjetGerer.ObjetTypePager;
import com.apps.mangel.clevernotes.R;

public class MesListes extends AppCompatActivity implements ActionBar.TabListener {

    //VM - Variables
    private ViewPager mviewPager;
    private ActionBar mActionBar;
    private TabsPagerAdapter mAdapter;
    //VM - Tableau des onglets
    private String[] mTabs = {"", "", ""};

    /**
     * Event Constructor
     * @param pSavedInstanceState Bundle de la session
     */
    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        //VM - call du super
        super.onCreate(pSavedInstanceState);
        //VM - Set du layout
        setContentView(R.layout.meslistes);

        //VM - Initilisations
        LoadObjets();

    }

    @Override
    public void onResume() {
        super.onResume();
        LoadObjets();
    }

    /**
     * Event lors de l'instanciation de l'action bar
     * @param pMenu l'action bar
     * @return isHandled
     */
    @Override
    public boolean onCreateOptionsMenu(Menu pMenu) {
        //VM - Inflater pour ajouter le menu
        MenuInflater inflater = getMenuInflater();
        //VM - Ajout du menu
        inflater.inflate(R.menu.ajouter, pMenu);
        return true;
    }

    /**
     * Event lors d'un clic sur un onglet
     * @param pTab l'onglet
     * @param pFt le contenu de l'onglet
     */
    @Override
    public void onTabSelected(ActionBar.Tab pTab, FragmentTransaction pFt) {
        //VM - Set la page à afficher selon l'onglet cliqué
        mviewPager.setCurrentItem(pTab.getPosition());
    }

    /**
     * Event clic sur un button dans l'action bar
     * @param pItem Menu
     * @return isHandled
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem pItem) {
        //VM - Button retour
        if (pItem.getItemId() == android.R.id.home) {
            //VM -Fermeture de l'activity
            this.finish();
        }
        //VM - Button Ajouter
        else
        {
            //VM - Goto activity creer objet
            startActivity(new Intent(this, ObjetTypePager.class));
        }
        return true;
    }

    public void LoadObjets(){
        //VM  - Récupération du pager (gestionnaire onglets)
        mviewPager = (ViewPager) findViewById(R.id.pager);
        //VM - Récupération de l'action bar
        mActionBar = getSupportActionBar();
        //VM - Adapter pour le pager
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        //VM - Sets
        mviewPager.setAdapter(mAdapter);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        if(mTabs[0] == "") {
            //VM - Récupération et set des titres d'onglets
            String StringTemp = getResources().getString(R.string.PersoListes);
            mTabs[0] = StringTemp;
            StringTemp = getResources().getString(R.string.PriveListes);
            mTabs[1] = StringTemp;
            StringTemp = getResources().getString(R.string.PublicListes);
            mTabs[2] = StringTemp;


            //VM - Set des onglets pour chaque titre
            for (String tab_name : mTabs) {
                mActionBar.addTab(mActionBar.newTab().setText(tab_name)
                        .setTabListener(this));
            }
        }

        //VM - Events pour le swipe event afin de changer l'onglet en même temps
        mviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * Event pour changer d'onglet en même temps que de page lors d'un swipe
             * @param pPosition position de l'onglet selectionné
             */
            @Override
            public void onPageSelected(int pPosition) {
                //VM - Set la position
                mActionBar.setSelectedNavigationItem(pPosition);
            }



            //region EVENTS UNUSED
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageScrollStateChanged(int arg0) {}
            //endregion EVENTS UNUSED
        });
    }

    //region UNUSED EVENTS
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    //endregion UNUSED EVENTS
}