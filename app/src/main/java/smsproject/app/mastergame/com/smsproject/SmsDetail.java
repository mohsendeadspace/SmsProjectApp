package smsproject.app.mastergame.com.smsproject;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by MoHseN.DeaDSpacE on 02/06/2016.
 */
public class SmsDetail extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_detail);


        TextView sender=(TextView)findViewById(R.id.txtsender);
        TextView message=(TextView)findViewById(R.id.txtmessage);

        Bundle extras=getIntent().getExtras();
        String Msg= extras.getString("MESSAGE");
        String tel= extras.getString("SENDER");

        sender.setText(tel);
        message.setText(Msg);
    }
}
