package smsproject.app.mastergame.com.smsproject;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by MoHseN.DeaDSpacE on 02/06/2016.
 */
public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


            Object[] pdus=(Object[]) intent.getExtras().get("pdus");
            SmsMessage sms=SmsMessage.createFromPdu((byte[]) pdus[0]);

            String MessageBody= sms.getMessageBody();
            String SenderTel=sms.getOriginatingAddress();

            Intent detailIntent=new Intent(G.context,SmsDetail.class);
            detailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            detailIntent.putExtra("MESSAGE",MessageBody);
            detailIntent.putExtra("SENDER",SenderTel);
            G.context.startActivity(detailIntent);
    }
}
