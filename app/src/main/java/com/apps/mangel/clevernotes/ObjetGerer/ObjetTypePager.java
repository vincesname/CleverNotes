package com.apps.mangel.clevernotes.ObjetGerer;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.mangel.clevernotes.Classes.Enums;
import com.apps.mangel.clevernotes.Classes.GestionFichiers;
import com.apps.mangel.clevernotes.Classes.Objet;
import com.apps.mangel.clevernotes.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Créé by Vincent on 24/06/2016.
 */
public class ObjetTypePager extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;
    private int mCurrentPosition = 0;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.objettype);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.PagerType);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);


        final Button lButton = (Button) findViewById(R.id.Buttonselectionner);
        lButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ObjetEditer.class);

                String lTitre;
                Objet lObjet;
                Calendar lCalendar = Calendar.getInstance();
                Date lDate = lCalendar.getTime();

                switch(mPager.getCurrentItem())
                {
                    case 0:
                        lTitre =  GestionFichiers.GetDefaultName(Enums.TypeObjet.Brouillon, getApplicationContext());
                        lObjet = new Objet(lTitre, "", lDate, Enums.TypeObjet.Brouillon);
                        i.putExtra("Objet", lObjet.toString());
                        break;
                    case 1:
                        lTitre =  GestionFichiers.GetDefaultName(Enums.TypeObjet.Liste, getApplicationContext());
                        lObjet = new Objet(lTitre, "", lDate, Enums.TypeObjet.Liste);
                        i.putExtra("Objet", lObjet.toString());
                        break;
                    case 2:
                        lTitre =  GestionFichiers.GetDefaultName(Enums.TypeObjet.ListeDesordonee, getApplicationContext());
                        lObjet = new Objet(lTitre, "", lDate, Enums.TypeObjet.ListeDesordonee);
                        i.putExtra("Objet", lObjet.toString());
                        break;
                    case 3:
                        lTitre =  GestionFichiers.GetDefaultName(Enums.TypeObjet.ListeEtapes, getApplicationContext());
                        lObjet = new Objet(lTitre, "", lDate, Enums.TypeObjet.ListeEtapes);
                        i.putExtra("Objet", lObjet.toString());
                        break;
                }
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pPosition) {

            Bundle lBundle = new Bundle();
            lBundle.putInt("position", pPosition);
            Fragment lFragment = new ObjetTypeFragm();
            lFragment.setArguments(lBundle);
            return lFragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}