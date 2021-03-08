package smsproject.app.mastergame.com.smsproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by MoHseN.DeaDSpacE on 31/05/2016.
 */
public class Cooler_Activity extends AppCompatActivity implements View.OnClickListener {


    Button cooler,cooler1,bokhari,state;
    public String p;
    public String Meghdar;
    private Toolbar toolbar;

public boolean pr=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cooler_activity);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle Data=getIntent().getExtras();
        Meghdar=Data.getString("Meghdar");
        DataBase db=new DataBase(this);
        final SQLiteDatabase mydb = db.getWritableDatabase();
        try {
            Cursor cu = mydb.rawQuery("SELECT * FROM person WHERE password = '"+Meghdar+"'", null);
            int c = cu.getCount();
            String[] phone= new String[c];
            cu.moveToFirst();
            for(int i=0;i<c;i++){
                phone[i]=cu.getString(1);
                cu.moveToNext();
                p=phone[i];
            }

        Toast.makeText(G.context,p,Toast.LENGTH_SHORT).show();
        }catch (SecurityException e){
            e.printStackTrace();
            Toast.makeText(G.context,"ERROR",Toast.LENGTH_SHORT).show();
        }




        cooler=(Button)findViewById(R.id.cooler);
        cooler1=(Button)findViewById(R.id.cooler1);
        bokhari=(Button)findViewById(R.id.bokhari);
        state=(Button)findViewById(R.id.statecb);

        Typeface co1=Typeface.createFromAsset(getAssets(),"font.ttf");
        cooler.setTypeface(co1);

        Typeface co2=Typeface.createFromAsset(getAssets(),"font.ttf");
        cooler1.setTypeface(co2);

        Typeface bo=Typeface.createFromAsset(getAssets(),"font.ttf");
        bokhari.setTypeface(bo);



        cooler.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        bokhari.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        cooler1.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        state.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));




        cooler.setOnClickListener(this);
        cooler1.setOnClickListener(this);
        bokhari.setOnClickListener(this);
        state.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.cooler:
                if(pr==true) {
                    cooler.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p, "6264942COOL");
                    Toast.makeText(G.context, "P Values : " + p + " " + "6264942COOL", Toast.LENGTH_LONG).show();
                }
                else
                    {
                        cooler.setBackgroundResource(R.drawable.shape_button);
                        SmsHelper.SendSms(p, "6264942COOL");
                        pr=true;
                    }


                break;
            case R.id.cooler1:

                if(pr==true) {
                    cooler1.setBackgroundResource(R.drawable.shape_button2);

                    SmsHelper.SendSms(p,"6264942COOL1");
                    Toast.makeText(G.context,"P Values : "+p+" 6264942COOL1",Toast.LENGTH_LONG).show();
                }

                else {
                    cooler1.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942COOL1");
                    pr=true;

                }


                break;
            case R.id.bokhari:

                if(pr==true) {
                    bokhari.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p,"6264942BOKHARI1");
                    Toast.makeText(G.context,"P Values : "+p+" 6264942BOKHARI1",Toast.LENGTH_LONG).show();
                }


                else
                {
                    bokhari.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942BOKHARI1");
                    pr=true;

                }




                break;
            case R.id.statecb:

                SmsHelper.SendSms(p,"6264942STATUS_C.B");
                Toast.makeText(G.context,"P Values : "+p+" 6264942STATUS_C.B",Toast.LENGTH_LONG).show();

                break;

            default:
                break;

        }

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
