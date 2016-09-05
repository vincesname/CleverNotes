package com.apps.mangel.clevernotes.Customs;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.mangel.clevernotes.R;

/**
 * Créé by Vincent on 31/08/2016.
 */
public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    public ArrayList myItems = new ArrayList();
    public Context mContext;

    public ListViewAdapter(Context lContext) {

        mContext = lContext;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < 1; i++) {
            ListItem listItem = new ListItem();
            listItem.caption = "Caption";
            myItems.add(listItem);
        }
    }

    public int getCount() {
        return myItems.size();
    }

    public Object getItem(int position) {

        return position;
    }

    public long getItemId(int position) {

        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderText holder;
        if (convertView == null) {
            holder = new ViewHolderText();
            convertView = mInflater.inflate(R.layout.objetediterlisteitem, null);
            holder.caption = (EditText) convertView
                    .findViewById(R.id.ItemCaption);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolderText) convertView.getTag();
        }
        //Fill EditText with the value you have in data source
        holder.caption.setText(((ListItem)myItems.get(position)).caption);
        holder.caption.setId(position);

        //we need to update adapter once we finish with editing
        holder.caption.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    final int position = v.getId();
                    final EditText Caption = (EditText) v;
                    ((ListItem)myItems.get(position)).caption = Caption.getText().toString();
                  //  ((ObjetEditer)mContext).myList.smoothScrollToPositionFromTop(position,0,0);

                }
                else
                {
                    try {
                        final int position = v.getId();

                       // ((ObjetEditer)mContext).myList.smoothScrollToPositionFromTop(position,0,0);


                    }
                    catch (Exception e){
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        return convertView;
    }
}

