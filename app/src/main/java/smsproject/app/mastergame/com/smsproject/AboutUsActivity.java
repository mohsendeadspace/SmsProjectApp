package smsproject.app.mastergame.com.smsproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MoHseN.DeaDSpacE on 12/06/2016.
 */
public class AboutUsActivity extends AppCompatActivity {


    ImageView img1,img2,img3;
    TextView txt1,txt3,txt4;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_activity);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img1=(ImageView)findViewById(R.id.imageView);
        img2=(ImageView)findViewById(R.id.imageView2);
        img3=(ImageView)findViewById(R.id.imageView3);

        txt1=(TextView)findViewById(R.id.textView);

      Typeface tf=Typeface.createFromAsset(getAssets(),"font.ttf");
        txt1.setTypeface(tf);


        txt3=(TextView)findViewById(R.id.text2);
        txt4=(TextView)findViewById(R.id.text3);

        Typeface tt=Typeface.createFromAsset(getAssets(),"font.ttf");
        txt3.setTypeface(tt);

        Typeface tr=Typeface.createFromAsset(getAssets(),"font.ttf");
        txt4.setTypeface(tr);




        img2.setAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_three));
        img3.setAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_four));
        img1.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==android.R.id.home)
        {
            finish();


        }

        return super.onOptionsItemSelected(item);
    }
}
