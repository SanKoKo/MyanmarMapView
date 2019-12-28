package san.map.sanmyanmarmap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

public class MyanmarMapView extends FrameLayout {
    private int[] colors;
    private int[] stockColors;
    private int duration = 600;
    private Interpolator interpolator = new AnticipateOvershootInterpolator();
    private OnMapClick onMapClick;

    public MyanmarMapView(@NonNull Context context) {
        super(context);
        mapView(context,null);
    }

    public MyanmarMapView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mapView(context,attrs);
    }

    public MyanmarMapView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mapView(context,attrs);
    }



    private void mapView(Context context,AttributeSet attributeSet) {
        RichPathView richPathView = new RichPathView(context);
        richPathView.setVectorDrawable(R.drawable.myanmar);


        if(attributeSet!=null){
            TypedArray typeArray = context.obtainStyledAttributes(attributeSet,R.styleable.MyanmarMapView,0,0);

            int mapColor = typeArray.getColor(R.styleable.MyanmarMapView_mapBackgroundColor, Color.BLACK);

            for (RichPath richPath : richPathView.findAllRichPaths()) {
                richPath.setFillColor(mapColor);
            }
            typeArray.recycle();
        }

        if(colors==null || colors.length==0){
            colors = new int[2];
            colors[0] = Color.BLUE;
            colors[1] = Color.BLACK;
        }

        if(stockColors==null || stockColors.length==0){
            stockColors = new int[1];
            stockColors[0] = Color.WHITE;
        }
        richPathView.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick(RichPath richPath) {

                if(onMapClick!=null){
                    onMapClick.onClick(richPath.getName());
                }
                    richPath.setPivotToCenter(true);
                    RichPathAnimator.animate(richPath)
                            .duration(duration)
                            .interpolator(interpolator)
                            .scale(1.1f,1f)
                            .fillColor(colors)
                            .strokeColor(stockColors)
                            .start();





            }
        });
        this.addView(richPathView);
    }
    public void setAnimatedDuration(int duration){
        this.duration = duration;
    }

    public void addColors(int... colors){
        this.colors = colors;
    }

    public void addStockColors(int... colors){
        this.stockColors = colors;
    }

    public void addAnimationStyle(Interpolator interpolator){
        this.interpolator = interpolator;
    }

    public void setOnMapClickListener(OnMapClick onMapClick){
        this.onMapClick = onMapClick;
    }

    public interface OnMapClick{
        void onClick(String name);
    }



}
