package com.example.urbanifilemanager;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Gestore {

    public String leggiFile(String nomeFile, Context c){
        // stream orientato ai byte
        // errore file non esistente (erorre di tipo controllato)
        String esito = null;
        try
        {
            FileInputStream fis = c.openFileInput(nomeFile);
            // stream orientato ai caratteri
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            esito = br.readLine();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("TAG", "errore file non esistente");
            esito = "errore file";
        }
        // Problemi di lettura/scrittura du file aperto
        catch (IOException e) {
            e.printStackTrace();
        }
        return esito;
    }

    public String leggiFileRaw(Context c){
        // Raw più restrittivo di Asset
        String esito;
        // non passo nome file
        // oggetto, puntatore che ci consente di accedere a tutti i
        // riferimenti degli oggetti corrispondenti alle risorse
        Resources res = c.getResources(); // restituisce metodo di tipo resources.
        // istanza res per avere risorse disponibili app
        // utilizzo res per accedere a file in cartella raw

        // oggetto di tipo inputstream = stream di byte

        // 1. apertura file
        InputStream is = res.openRawResource(R.raw.provaraw);
        // 2. lettura file riga per riga
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); // Wrapping
        try
        {
            esito = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Log.e("RAG", "Errore di I/O");
            esito = "Errore lettura";
        }
        return esito;
    }

    public String leggiFileAsset(String nomeFile, Context c){

        String esito;
        esito = null;

        AssetManager am = c.getAssets();
        try {
            // 1. apertura file
            InputStream is = am.open(nomeFile);
            // 2. Buffered reader
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            esito = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "Errore nell'apertura del file");
        }
        return esito;
    }
}
