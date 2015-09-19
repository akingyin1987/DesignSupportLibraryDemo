package com.md.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Administrator on 2015/9/19.
 */
public class MainActivity extends AppCompatActivity {

    public DrawerLayout    mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);//将actionbar 换成toolbar
            ActionBar ab = getSupportActionBar();
            System.out.println("null=="+(null == ab));
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);//更改返回图标
            ab.setDisplayHomeAsUpEnabled(true);//打开返回事件
            mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);

            NavigationView navigationView =
                    (NavigationView) findViewById(R.id.nv_main_navigation);
            setupDrawerContent(navigationView);
            Fragment   fragment  = new FramentButton();
            getSupportFragmentManager().beginTransaction().add(R.id.home_content,fragment).commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }



    }@Override
     public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


}
