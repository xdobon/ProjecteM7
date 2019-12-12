package com.dobon.projectm7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    SharedPreferences prefs = getSharedPreferences("Usuarios", Context.MODE_PRIVATE);


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        username = findViewById(R.id.txt_User);
        password = findViewById(R.id.txt_Password);

    }
    public void formulariRegistre(View view) {
        Intent intent = new Intent(this, Registre.class);

            startActivity(intent);


    }
    public void login(View view) {
        SharedPreferences.Editor editor = prefs.edit();
        String us = prefs.getString("user", String.valueOf(username));
        String ps = prefs.getString("password", String.valueOf(username));
        editor.commit();


        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Intent intent = new Intent(this, Principal.class);

            startActivity(intent);

        }else{
            Toast toast =
                    Toast.makeText(getApplicationContext(),
                            "Usuari o contrasenya incorrectes.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);
            toast.show();
        }



    }

}
