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
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by MoHseN.DeaDSpacE on 31/05/2016.
 */
public class Priz_Activity extends AppCompatActivity implements View.OnClickListener{


    Button priz1,priz2,priz3,priz4,state;
    public String p;
    public String Meghdar;
    private Toolbar toolbar;
    public boolean pr=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priz_activity);

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


        priz1=(Button)findViewById(R.id.priz1);
        priz2=(Button)findViewById(R.id.priz2);
        priz3=(Button)findViewById(R.id.priz3);
        priz4=(Button)findViewById(R.id.priz4);
        state=(Button)findViewById(R.id.statepriz);



        Typeface pr1=Typeface.createFromAsset(getAssets(),"font.ttf");
        priz1.setTypeface(pr1);

        Typeface pr2=Typeface.createFromAsset(getAssets(),"font.ttf");
        priz2.setTypeface(pr2);

        Typeface pr3=Typeface.createFromAsset(getAssets(),"font.ttf");
        priz3.setTypeface(pr3);

        Typeface pr4=Typeface.createFromAsset(getAssets(),"font.ttf");
        priz4.setTypeface(pr4);




        priz1.setOnClickListener(this);
        priz2.setOnClickListener(this);
        priz3.setOnClickListener(this);
        priz4.setOnClickListener(this);
        state.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.priz1:

                if(pr==true){
                    priz1.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p,"6264942PRIZ1");
                    Toast.makeText(G.context,"P Values : "+p+" "+"6264942PRIZ1",Toast.LENGTH_LONG).show();
                }
                else {
                    priz1.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PRIZ1");
                    pr=true;
                }



                break;
            case R.id.priz2:
                if(pr==true)
                {
                    priz2.setBackgroundResource(R.drawable.shape_button2);
                    SmsHelper.SendSms(p,"6264942PRIZ2");
                    Toast.makeText(G.context,"P Values : "+p+" "+"6264942PRIZ2",Toast.LENGTH_LONG).show();
                }
                else
                {
                    priz2.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PRIZ2");
                    pr=true;
                }

                break;
            case R.id.priz3:

                if(pr==true) {
                    priz3.setBackgroundResource(R.drawable.shape_button2);

                    SmsHelper.SendSms(p,"6264942PRIZ3");
                    Toast.makeText(G.context,"P Values : "+p+" 6264942PRIZ3",Toast.LENGTH_LONG).show();
                }

                else
                {
                    priz3.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PRIZ3");
                    pr=true;

                }



                break;
            case R.id.priz4:

                if(pr==true) {
                    priz4.setBackgroundResource(R.drawable.shape_button2);

                    SmsHelper.SendSms(p,"6264942PRIZ4");
                    Toast.makeText(G.context,"P Values : "+p+" 6264942PRIZ4",Toast.LENGTH_LONG).show();
                }

                else
                {
                    priz4.setBackgroundResource(R.drawable.shape_button);
                    SmsHelper.SendSms(p, "6264942PRIZ4");
                    pr=true;
                }



                break;
            case R.id.statepriz:

                SmsHelper.SendSms(p,"6264942statePRIZ");
                Toast.makeText(G.context,"P Values : "+p+" 6264942statePRIZ",Toast.LENGTH_LONG).show();

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


