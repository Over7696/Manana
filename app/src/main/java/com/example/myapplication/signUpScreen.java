package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class signUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }

    public void sendRequest2(View view) throws JSONException {
        String firstname = ((TextView) findViewById(R.id.editTextTextPersonName)).getText().toString();
        String lastname = ((TextView) findViewById(R.id.editTextTextPersonName2)).getText().toString();
        String email = ((TextView) findViewById(R.id.editTextTextEmailAddress6)).getText().toString();
        String passwordFirst = ((TextView) findViewById(R.id.editTextTextPassword2)).getText().toString();
        String passwordSecond = ((TextView) findViewById(R.id.editTextTextPassword3)).getText().toString();



        String url = "http://cinema.areas.su/auth/register";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(signUpScreen.this, response.toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(signUpScreen.this, signLnScreen.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(signUpScreen.this, "Регистрация не удалась", Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", passwordFirst);
                params.put("firstName", firstname);
                params.put("lastName", lastname);

                return params;
            }
        };


        requestQueue.add(request);
    }

        public void Reg1(View view) {
        Intent intent = new Intent(signUpScreen.this, signLnScreen.class);
        startActivity(intent);
    }
}