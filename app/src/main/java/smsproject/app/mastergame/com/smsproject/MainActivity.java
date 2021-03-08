package smsproject.app.mastergame.com.smsproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText edtpas=(EditText)findViewById(R.id.edtpas);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"font.ttf");
        edtpas.setTypeface(typeface);
        TextView vorod=(TextView)findViewById(R.id.txtvorod) ;
        Typeface typefacevorod=Typeface.createFromAsset(getAssets(),"font.ttf");
        vorod.setTypeface(typefacevorod);
        Button btnlogin=(Button)findViewById(R.id.btnlogin);
        Typeface typefacelogin=Typeface.createFromAsset(getAssets(),"font.ttf");
        btnlogin.setTypeface(typefacelogin);
        Button btninsert=(Button)findViewById(R.id.btninsert);
        Typeface typefaceinsert=Typeface.createFromAsset(getAssets(),"font.ttf");
        btnlogin.setTypeface(typefaceinsert);
        DataBase db=new DataBase(this);
        final SQLiteDatabase mydb = db.getWritableDatabase();



        if (btninsert != null) {
            btninsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            });
        }

        if (btnlogin != null) {
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor cu = mydb.rawQuery("SELECT * FROM person WHERE password = '"+edtpas.getText().toString()+"'", null);
                    if(cu.getCount()<1){
                        Toast.makeText(G.context,"رمز وجود ندارد",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        final Bundle countainer=new Bundle();
                        countainer.putString("Meghdar",(edtpas.getText().toString()));
                        Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                        intent.putExtras(countainer);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }

    }


}
