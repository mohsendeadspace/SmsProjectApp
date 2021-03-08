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
public class Parde_Activity extends AppCompatActivity implements View.OnClickListener{


    Button parde1,parde2,parde3,parde4,state;
    public String p;
    public String Meghdar;
    private Toolbar toolbar;
    public boolean s=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parde_activity);

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


        parde1=(Button)findViewById(R.id.parde1);
        parde2=(Button)findViewById(R.id.parde2);
        parde3=(Button)findViewById(R.id.parde3);
        parde4=(Button)findViewById(R.id.parde4);
        state=(Button)findViewById(R.id.stateparde);


        Typeface pa1=Typeface.createFromAsset(getAssets(),"font.ttf");
        parde1.setTypeface(pa1);

        Typeface pa2=Typeface.createFromAsset(getAssets(),"font.ttf");
        parde2.setTypeface(pa2);

        Typeface pa3=Typeface.createFromAsset(getAssets(),"font.ttf");
        parde3.setTypeface(pa3);

        Typeface pa4=Typeface.createFromAsset(getAssets(),"font.ttf");
        parde4.setTypeface(pa4);

        parde1.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        parde2.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        parde3.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        parde4.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        state.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));


        parde1.setOnClickListener(this);
        parde2.setOnClickListener(this);
        parde3.setOnClickListener(this);
        parde4.setOnClickListener(this);
        state.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.parde1:

                if(s==true){

                    parde1.setBackgroundResource(R.drawable.shape_button2);
                SmsHelper.SendSms(p,"6264942PARDE1");
                Toast.makeText(G.context,"P Values : "+p+" "+"6264942PARDE1",Toast.LENGTH_LONG).show();
                }
                else {
                    parde1.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PARDE1");
                    s=true;

                }


                break;
            case R.id.parde2:

                if(s==true){

                    parde2.setBackgroundResource(R.drawable.shape_button2);
                SmsHelper.SendSms(p,"6264942PARDE2");
                Toast.makeText(G.context,"P Values : "+p+" "+"6264942PARDE2",Toast.LENGTH_LONG).show();
                }
                else {
                    parde2.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PARDE2");
                    s=true;

                }


                break;
            case R.id.parde3:

                if(s==true) {

                    parde3.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p, "6264942PARDE3");
                    Toast.makeText(G.context, "P Values : " + p + " 6264942PARDE3", Toast.LENGTH_LONG).show();
                }
                else {
                    parde3.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PARDE3");
                    s=true;
                }

                break;
            case R.id.parde4:

                if(s==true) {

                    parde4.setBackgroundResource(R.drawable.shape_button2);

                    SmsHelper.SendSms(p, "6264942PARDE4");
                    Toast.makeText(G.context, "P Values : " + p + " 6264942PARDE4", Toast.LENGTH_LONG).show();
                }

                else
                {
                    parde4.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PARDE4");
                    s=true;
                }


                break;
            case R.id.stateparde:

                SmsHelper.SendSms(p,"6264942statePARDE");
                Toast.makeText(G.context,"P Values : "+p+" 6264942statePARDE",Toast.LENGTH_LONG).show();

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
