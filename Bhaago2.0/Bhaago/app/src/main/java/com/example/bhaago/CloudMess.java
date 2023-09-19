package com.example.bhaago;

import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CloudMess extends FirebaseMessagingService {


    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived (remoteMessage);


                getFirebaseMessage (remoteMessage.getNotification ().getTitle (), remoteMessage.getNotification ().getBody ());
            }




    private void getFirebaseMessage(String title, String body) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder (this, "myFirebaseMess")
                .setContentTitle (title)
                .setContentText (body)
                .setAutoCancel (true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from (this);
        if (ActivityCompat.checkSelfPermission (this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        managerCompat.notify (101, builder.build ());
    }

}
