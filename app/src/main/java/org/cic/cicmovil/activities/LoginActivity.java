package org.cic.cicmovil.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.cic.cicmovil.R;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    private Button btn_login;
    private EditText et_user;
    private EditText et_pwd;
    private EditText et_link;
    private TextView tv_forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init_views();
        init_events();
    }

    private void init_views(){
        btn_login = (Button) findViewById(R.id.btn_login_in);
        et_user = (EditText) findViewById(R.id.et_login_user);
        et_pwd = (EditText) findViewById(R.id.et_login_pwd);
        tv_forgot = (TextView) findViewById(R.id.tv_login_forgot);

    }

    private void init_events(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_UserActivity();
            }
        });
    }

    private void call_UserActivity() {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

}
