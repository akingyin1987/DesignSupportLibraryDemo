package com.md.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
            ab.setLogo(R.mipmap.ic_launcher);//设置LOGO
            ab.setTitle("标题");
            ab.setSubtitle("副标题");

            ab.setHomeAsUpIndicator(R.drawable.ic_menu);//更改返回图标
            ab.setDisplayHomeAsUpEnabled(true);//打开返回事件
            mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);

            NavigationView navigationView =
                    (NavigationView) findViewById(R.id.nv_main_navigation);
            toolbar.setNavigationIcon(R.drawable.ab_android);
            toolbar.setOnMenuItemClickListener(onMenuItemClick);

            setupDrawerContent(navigationView);

            ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);

                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);

                }
            };
            mDrawerToggle.syncState();
            mDrawerLayout.setDrawerListener(mDrawerToggle);//设置监听器
            Fragment   fragment  = new FramentButton();
            getSupportFragmentManager().beginTransaction().add(R.id.home_content,fragment).commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
     public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";
                    break;
            }

            if(!msg.equals("")) {

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
