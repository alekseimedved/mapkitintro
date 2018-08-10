package com.alekseimedved.mapattempt1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MainActivity extends Activity {

    private MapView mapview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String API = "63b813f2-d348-4d81-a6f6-11a11dfd68ae";

        MapKitFactory.setApiKey(API);
        MapKitFactory.initialize(this);


        setContentView(R.layout.activity_main);
        mapview = (MapView)findViewById(R.id.mapview);
        mapview.getMap().move(
                new CameraPosition(new Point(55.751574,37.573856),11.0f,0.0f,0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
    }

    @Override
    protected void onStop(){
        super.onStop();
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
    }


    @Override
    protected void onStart(){
        super.onStart();
        mapview.onStart();
        MapKitFactory.getInstance().onStart();
    }
}
