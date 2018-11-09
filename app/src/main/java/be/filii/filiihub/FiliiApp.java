package be.filii.filiihub;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class FiliiApp extends Application {



    public static final String CHANNEL_SERVICE_ID = "FiliiKotChannel";
    public static final String CHANNEL_NOTIF_ID = "FiliiKotNotification";



    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_SERVICE_ID,
                    "Filiikot Service Channel",
                    NotificationManager.IMPORTANCE_MIN

            );


            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_NOTIF_ID,
                    "Filiikot Notification Channel",
                    NotificationManager.IMPORTANCE_DEFAULT

            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
            manager.createNotificationChannel(notificationChannel);
        }
    }



    public Socket getSocket() {

        String URL = getResources().getString(R.string.socket_url);
        Socket mSocket;


        IO.Options opts = new IO.Options();
        opts.forceNew = true;

        try {
            mSocket = IO.socket(URL, opts);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return mSocket;
    }
}
