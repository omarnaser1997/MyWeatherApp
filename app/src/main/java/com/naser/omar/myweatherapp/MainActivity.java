package com.naser.omar.myweatherapp;


import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;              //Add Kosalgeek  & add GenAsync
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity implements AsyncResponse {


    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView)findViewById(R.id.txt);



        PostResponseAsyncTask task = new PostResponseAsyncTask(this);
        try {
            task.execute("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Latakia%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
        }catch (Exception e){}
    }

    @Override
    public void processFinish(String s) {
        txt.setText(s);

    }


}