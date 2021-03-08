package smsproject.app.mastergame.com.smsproject;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MoHseN.DeaDSpacE on 19/05/2016.
 */
public class LoginActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final EditText edtphone=(EditText) findViewById(R.id.edtphone);
        Typeface typefacephone=Typeface.createFromAsset(getAssets(),"font.ttf");
        edtphone.setTypeface(typefacephone);
        final EditText edtpassword=(EditText) findViewById(R.id.edtpassword);

        Typeface typefacepas=Typeface.createFromAsset(getAssets(),"font.ttf");
        edtpassword.setTypeface(typefacepas);

        final EditText edttekrar=(EditText) findViewById(R.id.edttekrar);

        Typeface typefacetekrar=Typeface.createFromAsset(getAssets(),"font.ttf");
        edttekrar.setTypeface(typefacetekrar);



        DataBase db=new DataBase(this);
        final SQLiteDatabase mydb=db.getWritableDatabase();



        Button btnregister=(Button) findViewById(R.id.btnregister);
        Typeface typefaceregist=Typeface.createFromAsset(getAssets(),"font.ttf");
       btnregister.setTypeface(typefaceregist);


        if (btnregister != null) {
            btnregister.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(edtphone.getText().toString().equals("")||edtpassword.getText().toString().equals("")||edttekrar.getText().toString().equals("")){
                        Toast.makeText(G.context,"لطفا ورودی های خود را چک کنید",Toast.LENGTH_LONG).show();
                    }
                    else if(!edtpassword.getText().toString().equals(edttekrar.getText().toString())){
                        edtpassword.setText("");
                        edttekrar.setText("");
                        Toast.makeText(G.context,"عدم تطابق رمز",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        try {
                            mydb.execSQL("INSERT INTO person (phone_num,password) VALUES('" + edtphone.getText().toString() + "','" + edtpassword.getText().toString() + "')");
                            edtpassword.setText("");
                            edttekrar.setText("");
                            edtphone.setText("");
                            Toast.makeText(G.context, "ثبت با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                        }
                        catch (SQLException e){

                            edtpassword.setText("");
                            edttekrar.setText("");
                            Toast.makeText(G.context,"رمز عبور تکراری می باشدْلطفا رمز دیگری وارد نمایید",Toast.LENGTH_SHORT).show();
                        }

                    }

                }
            });




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
