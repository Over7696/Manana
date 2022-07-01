package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class signLnScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_ln_screen);
    }


    public void toMenu(View view) {
        String login = ((TextView)findViewById(R.id.editTextTextEmailAddress2)).getText().toString().trim();
        String password = ((TextView)findViewById(R.id.editTextTextPassword)).getText().toString().trim();

        JSONObject json = new JSONObject();
        try {
            json.put("email", login);
            json.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = "http://cinema.areas.su/auth/login";

        RequestQueue requestQueue = Volley.newRequestQueue(signLnScreen.this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, json,
                response -> startActivity(new Intent(signLnScreen.this, LaunchScreen.class)),
                error -> Toast.makeText(this, "Неверные данные авторизации", Toast.LENGTH_LONG).show());
        requestQueue.add(request);
    }

    public void toRegAct(View view) {
        Intent intent = new Intent(signLnScreen.this,signUpScreen.class);
        startActivity(intent);
    }
}

