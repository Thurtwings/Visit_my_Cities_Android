package com.example.visit_my_cities_android;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class DBManager {

    private Context context;
    public RequestQueue queue;
    public DBManager (Context context){

        this.context = context;
        this.queue = Volley.newRequestQueue(context);
    }

}
