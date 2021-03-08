package smsproject.app.mastergame.com.smsproject;

import android.telephony.SmsManager;

/**
 * Created by MoHseN.DeaDSpacE on 01/06/2016.
 */
public class SmsHelper {
    public static void SendSms(String desc,String message){

        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(desc,null,message,null,null);

    }
}
