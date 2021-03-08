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
import android.widget.Toast;

/**
 * Created by MoHseN.DeaDSpacE on 31/05/2016.
 */
public class Hood_Activity extends AppCompatActivity  implements View.OnClickListener{
    Button hood1,hood2,bargh,state;
    public String p;
    public String Meghdar;
    private Toolbar toolbar;
    public boolean check=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hood_activity);

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

        hood1=(Button) findViewById(R.id.hood1);
        hood2=(Button) findViewById(R.id.hood2);
        bargh=(Button) findViewById(R.id.mainpower);
        state=(Button) findViewById(R.id.stateh);

        Typeface hod1=Typeface.createFromAsset(getAssets(),"font.ttf");
        hood1.setTypeface(hod1);

        Typeface hod2=Typeface.createFromAsset(getAssets(),"font.ttf");
        hood2.setTypeface(hod2);

        Typeface bar=Typeface.createFromAsset(getAssets(),"font.ttf");
        bargh.setTypeface(bar);


        hood1.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        hood2.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        bargh.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        state.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));

        hood1.setOnClickListener(this);
        hood2.setOnClickListener(this);
        bargh.setOnClickListener(this);
        state.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.hood1:
            if (check==true) {
                hood1.setBackgroundResource(R.drawable.shape_button2);
                SmsHelper.SendSms(p, "6264942HOD");
                Toast.makeText(G.context, "P Values : " + p + " " + "6264942HOD", Toast.LENGTH_LONG).show();
                check=false;
            }else{

                hood1.setBackgroundResource(R.drawable.shape_button);
                SmsHelper.SendSms(p, "6264942HOD");
                check=true;
            }

                break;
            case R.id.hood2:
                if (check==true) {
                    hood2.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p, "6264942HOD2");
                    check=false;
                }else{
                    hood2.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942HOD2");
                    check=true;
                }
                break;
            case R.id.mainpower:
                if (check==true) {
                    bargh.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p, "2624942POWER");
                    check=false;
                }else{
                    bargh.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "2624942POWER");
                    check=true;
                }



                break;
            case R.id.stateh:

                SmsHelper.SendSms(p,"6264942stateHOD");
                Toast.makeText(G.context,"P Values : "+p+" 6264942stateHOD",Toast.LENGTH_LONG).show();

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
