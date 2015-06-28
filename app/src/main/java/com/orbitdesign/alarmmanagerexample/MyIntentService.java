package com.orbitdesign.alarmmanagerexample;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    private static final int NOTIFICATION_ID = 87;
    private static final String TAG = MyIntentService.class.getName();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSubText("Sub text");
        builder.setContentInfo("Content Info");
        builder.setStyle(
                new NotificationCompat
                        .BigTextStyle()
                        .bigText("Some larger message that is shown to the user\nLine 2\nLine 3 \n Line 4\n Line 5"));
        builder.setAutoCancel(false);
        builder.setOngoing(false);
        builder.setColor(Color.MAGENTA);
        builder.setSmallIcon(R.drawable.abc_ic_commit_search_api_mtrl_alpha);
        builder.setWhen(0);

        Intent notifIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 99, notifIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        Notification notificationCompat = builder.build();

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);


    }


}
