package org.cic.cicmovil.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.cic.cicmovil.R;
import org.cic.cicmovil.utils.Constants;
import org.cic.cicmovil.utils.Session;
import org.cic.cicmovil.utils.SharedValues;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new SplashInitTask().execute();

    }


    private class SplashInitTask extends AsyncTask<Void, Integer, Void> {
        private static final String TAG = "SplashInitTask";
        public SplashInitTask(){
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(Constants.TIME_SECOND_SPLASH);
            } catch (InterruptedException e) {
                Log.d(TAG, "Error : " + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = null;
            if (SharedValues.isLogin(SplashActivity.this)){
                intent = new Intent(SplashActivity.this, MainActivity.class);
                Session.state = true;
                Toast.makeText(SplashActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();
            }
            else {
                Session.state = false;
                intent = new Intent(SplashActivity.this, LoginActivity.class);
            }
            startActivity(intent);
            finish();
        }
    }
}
