package com.heig.sym.sym_labo02.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.heig.sym.sym_labo02.R;
import com.heig.sym.sym_labo02.communications.CommunicationEventListener;
import com.heig.sym.sym_labo02.communications.CommunicationManager;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        CommunicationManager comM = new CommunicationManager();
        comM.setCommunicationEventListener(new CommunicationEventListener() {
            @Override
            public boolean handleServerResponse(String response) {
                Toast.makeText(Activity1.this, "Message received from echo server : " + response, Toast.LENGTH_SHORT).show();
                Log.i(Activity1.class.getName(), "Message received from echo server : " + response);
                /*if(response.compareTo("ok") == 0){
                    return true;
                }*/
                return true;
            }
        });
        try {
            comM.sendRequest("ok", "http://sym.dutoit.email/rest/txt");
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}