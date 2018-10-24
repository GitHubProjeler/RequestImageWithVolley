package com.example.fatih.requestimagewithvolley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bn;
    ImageView img;
    String urlImage = "http://ios-android.trkaynak.com/volley-request.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn = (Button) findViewById(R.id.btnGetImage);
        img = (ImageView) findViewById(R.id.imageView);

        bn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnGetImage){

            //ImageRequest: url bilgisi verilen resmi istemek için kullanılan sınıf
            ImageRequest imageRequest = new ImageRequest(urlImage,
                    new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap response) {

                            //istek sonucunda gelen resim imageview kontrolüne set edilir (gösterilir).
                            img.setImageBitmap(response);
                        }
                    }, 0, 0, ImageView.ScaleType.FIT_CENTER, null,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });

            /*Mysingleton: Her defasında RequestQueue nesneleri oluşturmak yerine tekbir istek oluşturmak
                daha mantıklıdır. Yani bu sınıfın temel amacı, RequestQueue nesnesini yapılandırmaktır.
                Tek bir RequestQueue nesnesi içerir ve yapıladırır. Aynı zamanda kapsüllemedir.
            */
            MySingleton.getIntstance(this.getApplicationContext()).addToRequestQue(imageRequest);
        }
    }
}
