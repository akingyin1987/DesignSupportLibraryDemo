package com.md.designsupportlibrarydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/9/19.
 */
public class FramentButton  extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public   View   view;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       if(null == view){
           view = inflater.inflate(R.layout.frament_btn_edit, container, false);
           view.findViewById(R.id.btn_tablayout).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent   intent  =  new Intent(getActivity(),TabLayoutActivity.class);
                   startActivity(intent);
               }
           });
       }
        return view;
    }
}
