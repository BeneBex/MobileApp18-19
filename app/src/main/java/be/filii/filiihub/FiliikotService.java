package be.filii.filiihub;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import static android.app.Application.getProcessName;
import static be.filii.filiihub.FiliiApp.CHANNEL_NOTIF_ID;
import static be.filii.filiihub.FiliiApp.CHANNEL_SERVICE_ID;

public class FiliikotService extends Service {


    private Socket mSocket;
    PendingIntent pendingIntent;
    Context context;
    String lastFiliikotState = null;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        context = this;

        Intent notificationIntent = new Intent(this, MainActivity.class);
        pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);


        setServiceNotification("Verbinden met het Filiikot!", "Websocket initialiseren...");

        initSocket();


        return START_NOT_STICKY;
    }


    private void initSocket() {


        if (mSocket != null) {
            destroySocket();
        }

        Log.i("SOCKET Service", "Initializing Socket");
        FiliiApp app = (FiliiApp) getApplication();
        mSocket = app.getSocket();

        mSocket.on(Socket.EVENT_CONNECT, onConnect);
        mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
        mSocket.on("update", onUpdate);


        mSocket.connect();
    }


    private void destroySocket() {
        if (mSocket != null) {
            Log.i("SOCKET Service", "Destroying Socket");
            mSocket.disconnect();
            mSocket.off(Socket.EVENT_CONNECT, onConnect);
            mSocket.off(Socket.EVENT_DISCONNECT, onDisconnect);
            mSocket.off(Socket.EVENT_CONNECT_ERROR, onConnectError);
            mSocket.off(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
            mSocket.off("update", onUpdate);
        }
    }


    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            Log.i("SOCKET Service", "Socket connected");

            setServiceNotification("Verbonden met het Filiikot!", "Websocket aangemaakt.");

        }
    };

    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            Log.e("SOCKET Service", "Socket disconnected");

            setServiceNotification("Verbinding verbroken met het Filiikot!", "De websocket heeft geen verbinding meer.");

        }
    };

    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            Log.i("SOCKET Service", "Error connecting to socket");

            setServiceNotification("Kan niet verbinden met het Filiikot!", "Controleer de internetverbinding.");

        }
    };

    private Emitter.Listener onUpdate = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            Log.i("SOCKET Service", "Socket Status Updated");


            JSONObject data = (JSONObject) args[0];
            String openClosed;
            String temperature;
            String lastUpdate;
            String openSince;
            try {
                openClosed = data.getString("openclosed");
                temperature = data.getString("temperature");
                lastUpdate = data.getString("lastUpdate");
                openSince = data.getString("since");
            } catch (JSONException e) {
                Log.e("SOCKET", e.getMessage());
                return;
            }

            setServiceNotification("Het Filiikot is " + openClosed, "Laatste update: " + lastUpdate);

            //sendStatusNotification(openClosed, openSince);

            if (lastFiliikotState == null) {
                lastFiliikotState = openClosed;
            } else if (!lastFiliikotState.equals(openClosed)) {
                lastFiliikotState = openClosed;
                sendStatusNotification(openClosed, openSince);
            }
        }
    };


    private void sendStatusNotification(String openClosed, String openSince) {
        Notification updateNotification = new NotificationCompat.Builder(context, CHANNEL_NOTIF_ID)
                .setContentTitle("Het Filiikot is " + openClosed)
                .setContentText("Sinds " + openSince)
                .setSmallIcon(R.drawable.ic_filii)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(2, updateNotification);

    }

    private void setServiceNotification(String title, String message) {
        context = this;

        Intent notificationIntent = new Intent(this, MainActivity.class);
        pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_SERVICE_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_filii)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
                .setContentIntent(pendingIntent)
                .setShowWhen(false)
                .build();
        startForeground(1, notification);
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
