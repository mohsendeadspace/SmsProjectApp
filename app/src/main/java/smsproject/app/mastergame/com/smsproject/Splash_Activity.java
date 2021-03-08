package smsproject.app.mastergame.com.smsproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MoHseN.DeaDSpacE on 03/06/2016.
 */
public class Splash_Activity extends AppCompatActivity {

    ImageView imgsplash;
    TextView txtsplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        imgsplash=(ImageView)findViewById(R.id.imgsplash);
        txtsplash=(TextView) findViewById(R.id.txtsplash);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtsplash.setTypeface(typeface);
        txtsplash.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));


        Thread intro=new Thread(){

            @Override
            public void run() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    Intent intent=new Intent("android.intent.action.MAINACTIVITY" );
                    startActivity(intent);

                }

            }
        };
        intro.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
