package com.example.visit_my_cities_android.ConnexionServer.Utilisateur;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnexionServerInsertUser extends AsyncTask<String, Void, String> {

    private static final String URL_SERVEUR3 = "http://jdevalik.fr/api/VMC_PHP_SBG/vmc_insertuser.php";


    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultat = null;

        try {
            // Créer une URL à partir de l'URL du serveur
            URL url = new URL(URL_SERVEUR3);

            // Ouvrir la connexion avec le serveur
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Lire la réponse du serveur
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                stringBuilder.append(ligne).append("\n");
            }
            if (stringBuilder.length() == 0) {
                return null;
            }
            resultat = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultat;
    }

    @Override
    protected void onPostExecute(String resultat) {
        // Traitement du résultat obtenu depuis le serveur
        if (resultat != null) {
            // Le résultat est une chaîne de caractères JSON
            // Peut être traité comme un objet JSON

            try {
                // Convertir la chaîne JSON en objet JSON
                JSONObject json = new JSONObject(resultat);

                // Exemple de récupération des données
                boolean success = json.getBoolean("success");
                if (success) {
                    // Succès : faire quelque chose
                } else {
                    // Échec : faire autre chose
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // Gérer l'absence de résultat
        }
    }
}
