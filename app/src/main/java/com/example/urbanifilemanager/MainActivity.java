package com.example.urbanifilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gestore g = new Gestore();

        String testo = g.leggiFile("prova.txt", getApplicationContext());
        Toast.makeText(getApplicationContext(), testo , Toast.LENGTH_SHORT).show();

        testo = g.leggiFileRaw(getApplicationContext());
        Toast.makeText(getApplicationContext(), testo , Toast.LENGTH_SHORT).show();

        testo = g.leggiFileAsset("provaasset.txt",getApplicationContext());
        Toast.makeText(getApplicationContext(), testo , Toast.LENGTH_SHORT).show();

    }
}