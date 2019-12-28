# MyanmarMapView
Myanmar Map View

ဒီ Library လေးကတော့ Myanmar Map View တစ်ခုစီမှာ နှိပ်လို့ရမဲ့ပုံစံလေးပါ။

https://youtu.be/98M6oirVwtA

<img src="https://github.com/SanKoKo/MyanmarMapView/blob/master/screenshot/map2.gif" alt="screenshot" style="max-width:100%;">



Library သုံးဖို့ရာ အောက်ပါအတိုင်းလုပ်ဆောင်ပါ။

# 1. Add it in your root build.gradle at the end of repositories:

      allprojects {
      
        repositories {
        
          ...
          
          maven { url 'https://jitpack.io' }
          
        }
        
        }
      
  
  # 2. Add the dependency
  
            dependencies {
            
                  implementation 'com.github.SanKoKo:MyanmarMapView:Tag'
                  
          }
          
  
  
<h2> How to use </h2>

<h3>XML</h3>

      <san.map.sanmyanmarmap.MyanmarMapView
        android:id="@+id/mm"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:mapBackgroundColor="#A80BEB"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
        
        
  <h3>Java Code </h3>
          

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
