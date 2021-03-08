package smsproject.app.mastergame.com.smsproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by MoHseN.DeaDSpacE on 28/05/2016.
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cardView, cardViewtwo, cardViewthree, cardViewfour, cardViewfive, cardViewsix, cardViewseven, cardVieweight;
    FloatingActionButton floatingActionButton;
    TextView txtcardone,txtcardtwo,txtcarthree,txtcardfour,txtcarfive,txtcareight,txtcarseven,txtcarsix;
    public String p;
    String Meghdar;
    Toolbar toolbar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private long back_pressed;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle Data = getIntent().getExtras();
        Meghdar = Data.getString("Meghdar");


        DataBase db = new DataBase(this);
        final SQLiteDatabase mydb = db.getWritableDatabase();
        try {
            Cursor cu = mydb.rawQuery("SELECT * FROM person WHERE password = '" + Meghdar + "'", null);
            int c = cu.getCount();
            String[] phone = new String[c];
            cu.moveToFirst();
            for (int i = 0; i < c; i++) {
                phone[i] = cu.getString(1);
                cu.moveToNext();
                p = phone[i];
            }


        } catch (SecurityException e) {
            e.printStackTrace();
            Toast.makeText(G.context, "ERROR", Toast.LENGTH_SHORT).show();
        }

        txtcardone=(TextView)findViewById(R.id.txtcardone) ;
        Typeface c1=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcardone.setTypeface(c1);
        txtcardtwo=(TextView)findViewById(R.id.txtcardtwo) ;
        Typeface c2=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcardtwo.setTypeface(c2);
        txtcarthree=(TextView)findViewById(R.id.txtcarthree) ;
        Typeface c3=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcarthree.setTypeface(c3);
        txtcardfour=(TextView)findViewById(R.id.txtcardfour) ;
        Typeface c4=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcardfour.setTypeface(c4);
        txtcarfive=(TextView)findViewById(R.id.txtcarfive) ;

        Typeface c5=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcarfive.setTypeface(c5);

        txtcareight=(TextView)findViewById(R.id.txtcareight) ;

        Typeface c6=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcareight.setTypeface(c6);

        txtcarseven=(TextView)findViewById(R.id.txtcarseven) ;

        Typeface c7=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcarseven.setTypeface(c7);

        txtcarsix=(TextView)findViewById(R.id.txtcarsix) ;

        Typeface c8=Typeface.createFromAsset(getAssets(),"font.ttf");
        txtcarsix.setTypeface(c8);

        cardView = (CardView) findViewById(R.id.cardone);
        cardViewtwo = (CardView) findViewById(R.id.cardtwo);
        cardViewthree = (CardView) findViewById(R.id.cardthree);
        cardViewfour = (CardView) findViewById(R.id.cardfour);
        cardViewfive = (CardView) findViewById(R.id.cardtfive);
        cardVieweight = (CardView) findViewById(R.id.cardteight);
        cardViewseven = (CardView) findViewById(R.id.cardtseven);
        cardViewsix = (CardView) findViewById(R.id.cardtsix);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);




        cardView.setOnClickListener(this);
        cardViewtwo.setOnClickListener(this);
        cardViewthree.setOnClickListener(this);
        cardViewfour.setOnClickListener(this);
        cardViewfive.setOnClickListener(this);
        cardVieweight.setOnClickListener(this);
        cardViewseven.setOnClickListener(this);
        cardViewsix.setOnClickListener(this);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "توسعه دهنده:مجتبی ابراهیمی", Snackbar.LENGTH_LONG)
                        .setAction("درباره ما", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent=new Intent(MenuActivity.this,AboutUsActivity.class);
                                startActivity(intent);


                            }
                        }).show();

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {

        final Bundle countainer = new Bundle();
        countainer.putString("Meghdar", Meghdar);
        switch (v.getId()) {

            case R.id.cardone:

                Intent cool = new Intent("android.intent.action.COOLER_ACTIVITY");
                cool.putExtras(countainer);
                startActivity(cool);



                break;
            case R.id.cardtwo:

                Intent hood = new Intent("android.intent.action.HOOD_ACTIVITY");
                hood.putExtras(countainer);
                startActivity(hood);


                break;

            case R.id.cardthree:

                Intent parde = new Intent("android.intent.action.PARDE_ACTIVITY");
                parde.putExtras(countainer);
                startActivity(parde);


                break;

            case R.id.cardfour:

                Intent priz = new Intent("android.intent.action.PRIZ_ACTIVITY");
                priz.putExtras(countainer);
                startActivity(priz);


                break;

            case R.id.cardtfive:

                Intent lamp = new Intent("android.intent.action.LAMP_ACTIVITY");
                lamp.putExtras(countainer);
                startActivity(lamp);


                break;

            case R.id.cardtsix:

                SmsHelper.SendSms(p, "6264942IPONE");
                Toast.makeText(G.context, "OPEN THE DOOR", Toast.LENGTH_LONG).show();

                break;

            case R.id.cardteight:

                Intent dama = new Intent("android.intent.action.DAMA_ACTIVITY");
                dama.putExtras(countainer);
                startActivity(dama);

                break;

            case R.id.cardtseven:

                Intent gaz = new Intent("android.intent.action.GAZ_ACTIVITY");
                gaz.putExtras(countainer);
                startActivity(gaz);


                break;

            default:
                break;
        }


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Menu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://smsproject.app.mastergame.com.smsproject/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Menu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://smsproject.app.mastergame.com.smsproject/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
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
    public void onBackPressed() {
        if(back_pressed + 2000>System.currentTimeMillis())
            super.onBackPressed();

        else
            Toast.makeText(getBaseContext(),"برای خروج دکمه بازگشت را دوبار بزنید",Toast.LENGTH_SHORT).show();
        back_pressed=System.currentTimeMillis();



    }
}
