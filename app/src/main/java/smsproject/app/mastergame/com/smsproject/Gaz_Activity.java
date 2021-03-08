package smsproject.app.mastergame.com.smsproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by MoHseN.DeaDSpacE on 02/06/2016.
 */
public class Gaz_Activity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;

    Button gaz1,gaz2,state;
    public String p;
    public String Meghdar;
    public boolean check=true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gaz_activity);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gaz1=(Button)findViewById(R.id.gaz1);
        gaz2=(Button)findViewById(R.id.gaz2);
        state=(Button)findViewById(R.id.statecb);

        gaz1.setOnClickListener(this);
        gaz2.setOnClickListener(this);
        state.setOnClickListener(this);

        gaz1.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        gaz2.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        state.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));

        Bundle Data=getIntent().getExtras();
         Meghdar = Data.getString("Meghdar");
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

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.gaz1:

                if (check==true) {
                    gaz1.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p, "6264942GAZ_OPEN");
                    Toast.makeText(G.context, "P Values : " + p + " " + "6264942GAZ_OPEN", Toast.LENGTH_LONG).show();
                    check=false;
                }else{

                    gaz1.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942GAZ_OPEN");
                    check=true;
                }


                break;

            case R.id.gaz2:

                if (check==true) {
                    gaz2.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p, "6264942GAZ_CLOSE");
                    Toast.makeText(G.context, "P Values : " + p + " " + "6264942GAZ_CLOSE", Toast.LENGTH_LONG).show();
                    check=false;
                }else{

                    gaz2.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942GAZ_CLOSE");
                    check=true;
                }


                break;

            case R.id.statecb:

                SmsHelper.SendSms(p,"6264942stateGAZ");
                Toast.makeText(G.context,"P Values : "+p+" 6264942stateGAZ",Toast.LENGTH_LONG).show();

                break;


            default:
                break;

        }


    }
}
