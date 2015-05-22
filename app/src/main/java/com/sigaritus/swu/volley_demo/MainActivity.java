package com.sigaritus.swu.volley_demo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {
    //tuling  api key 1b3bf45520687fce41be4bef2c4e1e26
    //developer id 91780

    private RequestQueue mQueue;
    public static String[] imgs={"http://img.blog.csdn.net/20150413155636375",
            "http://img.blog.csdn.net/20150413155714583","http://img.blog.csdn.net/20150413155811491"};
    public static String[] titles={"pic1","pic2","pic2"};

//    private String url
//    ="http://en.wikipedia.org/w/api.php?format=jsonfm&action=query&titles=android&prop=revisions&rvprop=content";
    private ImageView pic;
    private String tuling
            ="http://www.tuling123.com/openapi/api?key=1b3bf45520687fce41be4bef2c4e1e26&info=你爱我吗";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pic =(ImageView)findViewById(R.id.pic);
        mQueue = Volley.newRequestQueue(MainActivity.this);

//        readBitmapViaVolley("http://img.blog.csdn.net/20150413155636375",pic);

        get_poem_info(tuling);
    }



    public void readBitmapViaVolley(String imgUrl, final ImageView imageView) {
        ImageRequest imgRequest = new ImageRequest(imgUrl,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap arg0) {
                        // TODO Auto-generated method stub
                        imageView.setImageBitmap(arg0);
                    }
                },
                300,
                200,
                Bitmap.Config.ARGB_8888,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError arg0) {

                    }
                });
        mQueue.add(imgRequest);
    }
    public void get_poem_info(String url){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject jsonObject) {
                String code="";
                String text="";
                try {
                     code =jsonObject.getString("code");
                     text =jsonObject.getString("text");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this,code+text+"success",Toast.LENGTH_SHORT).show();

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.i("error",volleyError.getMessage());
            }
        });

        mQueue.add(jsonObjectRequest);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
