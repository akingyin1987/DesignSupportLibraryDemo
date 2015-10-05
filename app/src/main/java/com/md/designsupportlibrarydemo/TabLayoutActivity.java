package com.md.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/5.
 */
public class TabLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//将actionbar 换成toolbar
        ActionBar ab = getSupportActionBar();
        ab.setLogo(R.mipmap.ic_launcher);//设置LOGO
        ab.setTitle("标题");
        ab.setSubtitle("副标题");

        ab.setHomeAsUpIndicator(R.drawable.ic_menu);//更改返回图标
        ab.setDisplayHomeAsUpEnabled(true);//打开返回事件
        TabLayout   tabs = (TabLayout)findViewById(R.id.tabs);
        ViewPager   vp  =  (ViewPager)findViewById(R.id.vp);
        List<Fragment>   list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(TabFrament.newInstance("TEXT"+i));
        }
        TabFramentPagerAdapter  adapter  = new TabFramentPagerAdapter(getSupportFragmentManager(),list);
        vp.setAdapter(adapter);
        tabs.setupWithViewPager(vp);
        tabs.setTabsFromPagerAdapter(adapter);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中触发
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
              //失去选中
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
           //连续点击
            }
        });
    }
}
