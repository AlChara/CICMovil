package org.cic.cicmovil.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.cic.cicmovil.R;
import org.cic.cicmovil.fragments.InitFragment;

public class UserActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private int item_checked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        init_views();
        init_config();
        init_events();
    }

    private void init_events() {
        if(mNavigationView != null){
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    check_item(item);
                    launch_fragment(item);
                    mDrawerLayout.closeDrawer(GravityCompat.START, true);
                    return true;
                }
            });
        }
    }

    private void check_item(MenuItem item) {
        if (item_checked == 0){
            mNavigationView.getMenu().getItem(0).setChecked(false);
        }
        else{
          mNavigationView.getMenu().findItem(item_checked).setChecked(false);
        }
        item_checked = item.getItemId();
        item.setChecked(true);
    }


    private void launch_fragment(MenuItem item) {
        Fragment fragment = null;
        FragmentManager manager = getSupportFragmentManager();
        switch (item.getItemId()){

        }
        setTitle(item.getTitle());
    }

    private void init_config() {
       setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,R.string.openDrawer,R.string.closeDrawer);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void init_views() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_container);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_user_root);
        mNavigationView = (NavigationView) findViewById(R.id.nv_user_root);
        launch_init_fragment();
    }

    private void launch_init_fragment() {
        InitFragment fragment = InitFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fl_container, fragment)
                                    .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}
