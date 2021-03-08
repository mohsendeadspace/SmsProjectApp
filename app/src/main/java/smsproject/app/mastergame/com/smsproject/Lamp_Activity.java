package smsproject.app.mastergame.com.smsproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
public class Lamp_Activity extends AppCompatActivity implements View.OnClickListener{
    Button lamp1,lamp2,lamp3,lamp4,state;
    public String p;
    public String Meghdar;
    private Toolbar toolbar;
    public boolean check=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lamp_activity);


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


        lamp1=(Button)findViewById(R.id.lamp1);
        lamp2=(Button)findViewById(R.id.lamp2);
        lamp3=(Button)findViewById(R.id.lamp3);
        lamp4=(Button)findViewById(R.id.lamp4);
        state=(Button)findViewById(R.id.statelamp);

        lamp1.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        lamp2.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        lamp3.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        lamp4.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        state.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));


        lamp1.setOnClickListener(this);
        lamp2.setOnClickListener(this);
        lamp3.setOnClickListener(this);
        lamp4.setOnClickListener(this);
        state.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.lamp1:
                if(check==true) {
                    lamp1.setBackgroundResource(R.drawable.lightbulbon);
                    SmsHelper.SendSms(p, "6264942LAMP1");
                    check=false;
                }else {
                    lamp1.setBackgroundResource(R.drawable.lightbulb);
                    SmsHelper.SendSms(p, "6264942LAMP1");
                    check=true;
                }


                break;
            case R.id.lamp2:
                if(check==true) {
                    lamp2.setBackgroundResource(R.drawable.lightbulbon);
                    SmsHelper.SendSms(p, "6264942LAMP2");
                    check=false;
                }else {
                    lamp2.setBackgroundResource(R.drawable.lightbulb);
                    SmsHelper.SendSms(p, "6264942LAMP2");
                    check=true;

                }


                break;
            case R.id.lamp3:
                if (check==true) {
                    lamp3.setBackgroundResource(R.drawable.lightbulbon);
                    SmsHelper.SendSms(p, "6264942LAMP3");
                    check=false;
                }else{
                    lamp3.setBackgroundResource(R.drawable.lightbulb);
                    SmsHelper.SendSms(p, "6264942LAMP3");
                    check=true;

                }

                break;
            case R.id.lamp4:
                if (check==true) {
                    lamp4.setBackgroundResource(R.drawable.lightbulbon);
                    SmsHelper.SendSms(p, "6264942LAMP4");
                    check = false;
                }
                else{
                    lamp4.setBackgroundResource(R.drawable.lightbulb);
                    SmsHelper.SendSms(p, "6264942LAMP4");
                    check=true;

                }

                break;
            case R.id.statelamp:
                SmsHelper.SendSms(p, "6264942stateLAMP");
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
