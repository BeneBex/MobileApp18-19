package be.filii.filiihub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

public class FiliihubFragment extends Fragment {
    public static Fragment newInstance() {
        return new FiliihubFragment();
    }

    private Socket mSocket;
    private Boolean isConnected = true;
    Toast toast = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initSocket();
        return inflater.inflate(R.layout.fragment_filiihub, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destroySocket();
    }


    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            if(getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.i("SOCKET", "Socket connected");
                    if(!isConnected) {
                        makeToast("Socket Connected!", Toast.LENGTH_SHORT);
                        isConnected = true;
                    }
                }
            });
        }
    };

    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            if(getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.i("SOCKET", "Socket disconnected!");
                    if(isConnected){
                        isConnected = false;
                        makeToast("Socket Disconnected!", Toast.LENGTH_SHORT);
                    }
                }
            });
        }
    };

    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            if(getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(isConnected){
                        isConnected = false;
                        Log.e("SOCKET", "Error connecting to socket");
                        makeToast("Error connecting to Socket!", Toast.LENGTH_SHORT);
                    }

                }
            });
        }
    };


    private Emitter.Listener onUpdate = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            if(getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.i("SOCKET", "Socket Status Updated");
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

                    makeToast("Het filiikot is " + openClosed, Toast.LENGTH_LONG);

                }
            });
        }
    };



    private void makeToast(String message, int toastLenght){
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(getActivity().getApplicationContext(), message, toastLenght);
        toast.show();
    }


    private void initSocket(){

        Log.i("SOCKET", "Initializing Socket");
        FiliiApp app = (FiliiApp) getActivity().getApplication();
        mSocket = app.getSocket();

        mSocket.on(Socket.EVENT_CONNECT,onConnect);
        mSocket.on(Socket.EVENT_DISCONNECT,onDisconnect);
        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
        mSocket.on("update", onUpdate);


        mSocket.connect();
    }

    private void destroySocket(){
        Log.i("SOCKET", "Destroying Socket");
        mSocket.disconnect();
        mSocket.off(Socket.EVENT_CONNECT,onConnect);
        mSocket.off(Socket.EVENT_DISCONNECT,onDisconnect);
        mSocket.off(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.off(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
        mSocket.off("update", onUpdate);
    }




}
