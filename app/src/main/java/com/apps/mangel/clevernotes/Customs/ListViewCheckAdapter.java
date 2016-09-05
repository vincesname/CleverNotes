package com.apps.mangel.clevernotes.Customs;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.mangel.clevernotes.Classes.ObjetItem;
import com.apps.mangel.clevernotes.MainActivity;
import com.apps.mangel.clevernotes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Créé by Vincent on 03/09/2016.
 */


public class ListViewCheckAdapter extends ArrayAdapter<ObjetItem>{

    public List<ObjetItem> mListeObjetItems;
    private Context mContext;

    public ListViewCheckAdapter(List<ObjetItem> pListe, Context context) {
        super(context, R.layout.objetediterlistedesordonneeitem, pListe);
        if(pListe.size() ==0)
        {
            pListe.add(new ObjetItem("", 0, false));
        }
        this.mListeObjetItems = pListe;
        this.mContext = context;
    }


    @Override
    public View getView(int position, View pConvertView, ViewGroup parent) {

        View lView = pConvertView;

        ViewHolderCheckBox lHolder = new ViewHolderCheckBox();

        if(lView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            lView = inflater.inflate(R.layout.objetediterlistedesordonneeitem, null);

            lHolder.mTexte = (TextView) lView.findViewById(R.id.TextItemListeDeso);
            lHolder.mCheck = (CheckBox) lView.findViewById(R.id.CheckBoxItemListeDeso);

           // holder.mCheck.setOnCheckedChangeListener((MainActivity) context);

        } else {
            lHolder = (ViewHolderCheckBox) lView.getTag();
        }

        ObjetItem p = mListeObjetItems.get(position);
        lHolder.mTexte.setText(p.GetTexte());
        lHolder.mCheck.setChecked(p.GetStatut());
        lHolder.mCheck.setTag(p);

        return lView;
    }
}