package san.map.myanmar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import san.map.sanmyanmarmap.MyanmarMapView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.tv);
        MyanmarMapView myanmarMapView = findViewById(R.id.mm);

        /*

        You can set the map default color in xml by using app:mapBackgroundColor="#A80BEB"
         */


        myanmarMapView.addColors(Color.GREEN, Color.BLACK); //Default is blue and black
        myanmarMapView.addStockColors(Color.BLUE, Color.WHITE); // Default is white
        myanmarMapView.setAnimatedDuration(1000); //Default duration is 600
//        myanmarMapView.addAnimationStyle(new AnticipateOvershootInterpolator());
//        myanmarMapView.addAnimationStyle(new AccelerateDecelerateInterpolator()); //default style
//        myanmarMapView.addAnimationStyle(new AccelerateInterpolator());
//        myanmarMapView.addAnimationStyle(new CycleInterpolator(2));
//        myanmarMapView.addAnimationStyle(new LinearInterpolator());
//        myanmarMapView.addAnimationStyle(new FastOutLinearInInterpolator());
//        myanmarMapView.addAnimationStyle(new OvershootInterpolator());
//        myanmarMapView.addAnimationStyle(new FastOutSlowInInterpolator());
        myanmarMapView.addAnimationStyle(new BounceInterpolator());
        myanmarMapView.setOnMapClickListener(new MyanmarMapView.OnMapClick() {
            @Override
            public void onClick(String name) {
                System.out.println(name);
                tv.setText(name);
            }
        });

    }
}
