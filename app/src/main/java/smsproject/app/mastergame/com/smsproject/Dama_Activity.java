package smsproject.app.mastergame.com.smsproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MoHseN.DeaDSpacE on 02/06/2016.
 */
public class Dama_Activity extends AppCompatActivity {

    EditText edtdama;
    Button dama;
    public String p;
    public String Meghdar;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dama_activity);


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


        edtdama=(EditText)findViewById(R.id.edtdama);
        Typeface dam=Typeface.createFromAsset(getAssets(),"font.ttf");
        edtdama.setTypeface(dam);
        dama=(Button)findViewById(R.id.dama);
        Typeface nb=Typeface.createFromAsset(getAssets(),"font.ttf");
        dama.setTypeface(nb);

        edtdama.setAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_four));
        dama.setAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_five));



        dama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsHelper.SendSms(p,"6264942DAMA"+(edtdama.getText().toString()));
                Toast.makeText(G.context, "P Values : " + p + " 6264942DAMA"+(edtdama.getText().toString()), Toast.LENGTH_LONG).show();
            }
        });
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
