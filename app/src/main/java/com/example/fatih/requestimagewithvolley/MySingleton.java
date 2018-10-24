package com.example.fatih.requestimagewithvolley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static Context ctx;
    private RequestQueue requestQueue;

    //Kurucu metodun parametlerini alır ve atama yapar.
    private MySingleton(Context context){
        ctx = context;
        //getRequestQueue() metodundan, RequestQueue örneği alınır ve değişkene atanır
        requestQueue = getRequestQueue();
    }


    private RequestQueue getRequestQueue() {
        //RequestQueue örneği alınır ve return edilir
        return Volley.newRequestQueue(ctx);
    }

    //synchronized: bu anahtar kelime ile senkronize edilir
    public static synchronized MySingleton getIntstance(Context context){
        //MySingleton örneği olurturulur ve return edilir
        return new MySingleton(context);
    }

    //indirme işlemi yapılır. add() metodu ile istek işlenir.
    public <T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);
    }

}
