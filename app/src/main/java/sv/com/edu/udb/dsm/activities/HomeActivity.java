package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sv.com.udb.dsm.R;

public class HomeActivity extends AppCompatActivity {

    public static final String SALUDO = "Bienvenido";
    public static final String USER = "user";
    public static final String NO_HAY_USUARIO = "No hay usuario";
    public static final String CREDENCIALES = "credenciales";
    private TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        getUser();
    }

    private void getUser(){
        SharedPreferences preferences = getSharedPreferences(CREDENCIALES, Context.MODE_PRIVATE);
        String user = preferences.getString(USER, NO_HAY_USUARIO);
        txtWelcome.setText(SALUDO + " " + user);
    }


    public void onClick(View view){
        switch(view.getId()){
            case R.id.ejercicio1:
                viewExercise1();
                break;
            case R.id.ejercicio2:
                viewExercise2();
                break;
            case R.id.logOut:
                logOut();
        }
    }

    private void viewExercise1(){
        Intent i = new Intent(this, EcuacionActivity.class); //Matthew's activity
        startActivity(i);
    }

    private void viewExercise2(){
        Intent i = new Intent(this, EcuacionActivity.class);
        startActivity(i);
    }

    private void logOut(){
        SharedPreferences preferences = getSharedPreferences(CREDENCIALES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(CREDENCIALES);
        editor.commit();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}