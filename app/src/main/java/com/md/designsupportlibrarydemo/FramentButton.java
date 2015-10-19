package com.md.designsupportlibrarydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import java.util.Random;

/**
 * Created by Administrator on 2015/9/19.
 */
public class FramentButton  extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public   View   view;

    public NumberPicker   npone,nptow;


    public   String[]   npstr = {"1","2","3","4","5"};
    public   String[]   emptystr = new String[]{};
    public   String[]   nptown;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       if(null == view){
           view = inflater.inflate(R.layout.frament_btn_edit, container, false);
           npone = (NumberPicker)view.findViewById(R.id.np_one);
           npone.setMinValue(0);
           npone.setMaxValue(npstr.length - 1);
           npone.setDisplayedValues(npstr);
           nptow = (NumberPicker)view.findViewById(R.id.np_tow);
           String[] strings = getValue();

           if(nptow.getMaxValue() < strings.length && nptow.getMaxValue()>0){
               //    nptow.setValue(0);
               nptow.setWrapSelectorWheel(false);
               nptow.setDisplayedValues(strings);
               nptow.setMaxValue(strings.length - 1 < 0 ? 0 : strings.length - 1);
           }else{
               //    nptow.setValue(0);
               nptow.setWrapSelectorWheel(false);
               nptow.setMaxValue(strings.length - 1 < 0 ? 0 : strings.length - 1);
               nptow.setDisplayedValues(strings);
           }
           npone.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
               @Override
               public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                   String[] strings = getValue();
                   int maxV = nptow.getMaxValue();
                   if(strings.length-1>maxV){
                     nptow.setMinValue(0);
                       nptow.setValue(0);
                       nptow.setDisplayedValues(strings);
                       nptow.setMaxValue(strings.length-1);
                   }else{
                       nptow.setMinValue(0);
                       nptow.setValue(0);

                       nptow.setMaxValue(strings.length-1);
                       nptow.setDisplayedValues(strings);
                   }
//                   if(nptow.getMaxValue() <= strings.length && nptow.getMaxValue()>0 ){
//
//                      nptow.setWrapSelectorWheel(strings.length>=2);
//                       nptow.setDisplayedValues(strings);
//                       nptow.setMaxValue(strings.length - 1 <= 0 ? 0 : strings.length - 1);
//
//                   }else{
//
//                       nptow.setWrapSelectorWheel(strings.length<2);
//                       System.out.println("value=" + nptow.getValue()+":"+strings.length);
//                      System.out.println(nptow.getDisplayedValues().length + ":" + nptow.getMaxValue());
//
//                       nptow.setMaxValue(strings.length - 1 <= 0 ? 0 : strings.length - 1);
//                       nptow.setDisplayedValues(strings);
//
//                   }

               }
                                           }

           );
           view.findViewById(R.id.btn_tablayout).

                   setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent = new Intent(getActivity(), TabLayoutActivity.class);
                                              startActivity(intent);
                                          }
                                      }

                   );
           }
           return view;
    }

    public   String[]  getValue(){
        Random  random  = new Random();
        int   length = random.nextInt(50);
        String[]   str = new String[length];
        for(int i=0;i<length;i++){
            str[i]="test"+i;
        }
        if(str.length==0){
            str = new String[]{"无"};
        }

        return  str;
    }

    private int getWrappedSelectorIndex(int selectorIndex,int mMaxValue,int mMinValue) {
        if (selectorIndex > mMaxValue) {
            return mMinValue + (selectorIndex - mMaxValue) % (mMaxValue - mMinValue) - 1;
        } else if (selectorIndex < mMinValue) {
            return mMaxValue - (mMinValue - selectorIndex) % (mMaxValue - mMinValue) + 1;
        }
        return selectorIndex;
    }
}
