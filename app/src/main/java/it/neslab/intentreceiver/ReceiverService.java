package it.neslab.intentreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class ReceiverService extends Service {
    final Messenger Mess = new Messenger(new IncomingHandler());

    private long latestTime;
    private long latestStartTime;
    private int mode;
    private int total;

    public ReceiverService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        latestTime = System.currentTimeMillis();
        latestStartTime = intent.getLongExtra("starting", 0L);
        mode = intent.getIntExtra("mode", 0);
        total = intent.getIntExtra("n_tests", 0);
        return Mess.getBinder();
    }

    public class IncomingHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Bundle b = new Bundle();

            b.putLong("time", latestTime);
            b.putLong("starting", latestStartTime);
            b.putInt("mode", mode);
            b.putInt("n_tests", total);

            Message reply = new Message();
            reply.setData(b);
            try {
                msg.replyTo.send(reply);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
