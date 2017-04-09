package org.cic.cicmovil.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import org.cic.cicmovil.R;
import org.cic.cicmovil.adapters.RecyclerAdapter;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    public static final String TAG = "MainActivity";
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;


    String TITLES[] = {"Inicio","Perfil","Eventos","Galeria","Ubicacion","Consultas y sugerencias",
                        "Calendario", "Pagos y deudas", "Configuraciones", "Contacto", "Acerca de"};
    int ICONS[] = {R.drawable.ic_home, R.drawable.ic_profile, R.drawable.ic_event, R.drawable.ic_gallery,
                    R.drawable.ic_maps, R.drawable.ic_coment, R.drawable.ic_calendar,R.drawable.ic_paid,
                    R.drawable.ic_settings, R.drawable.ic_contact,R.drawable.ic_about};
    String NAME = "Akash Bangad";
    String EMAIL = "akash.bangad@android4devs.com";
    int PROFILE = R.mipmap.ic_launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_values();
        init_views();
        init_config();
        init_events();
    }

    private void init_values() {
//
//        String token = FirebaseInstanceId.getInstance().getToken();
//        SharedValues.save_preferences(this, Constants.token, token);
    }

    private void init_events() {

    }

    private void init_config() {
        setSupportActionBar(mToolbar);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerAdapter(TITLES, ICONS, NAME, EMAIL, PROFILE);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,R.string.openDrawer,R.string.closeDrawer);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    private void init_views(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main_slide);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_root);
        mLayoutManager = new LinearLayoutManager(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
