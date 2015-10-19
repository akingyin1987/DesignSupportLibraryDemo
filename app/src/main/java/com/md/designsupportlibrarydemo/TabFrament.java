package com.md.designsupportlibrarydemo;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Administrator on 2015/10/5.
 */
public class TabFrament  extends Fragment {

    public   static  final   String  ARG_PAGE="ARG_PAGE";

    public   String   text;

    public    static    TabFrament  newInstance(String  text){
        Bundle   bundle  = new Bundle();
        bundle.putString(ARG_PAGE, text);
        TabFrament  tabFrament  = new TabFrament();
        tabFrament.setArguments(bundle);
        return   tabFrament;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            text = getArguments().getString(ARG_PAGE);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view  =  inflater.inflate(R.layout.tablayout_frament,container,false);
        TextView  textView  = (TextView)view.findViewById(R.id.tabframent_tv);
        textView.setText(text);
         System.out.println("text=="+text);
        return view;
    }
}
