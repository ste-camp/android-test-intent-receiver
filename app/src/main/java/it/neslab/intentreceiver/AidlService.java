package it.neslab.intentreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by stefano on 08/11/17.
 */

public class AidlService extends Service {
    private long intentReceived;
    private long intentStartTime;
    private int mode;
    private int total;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        intentReceived = System.currentTimeMillis();
        intentStartTime = intent.getLongExtra("starting", 0L);
        mode = intent.getIntExtra("mode", 0);
        total = intent.getIntExtra("n_tests", 0);

        return binder;
    }

    private final ServiceInterface.Stub binder = new ServiceInterface.Stub() {

        @Override
        public long getCallTime() throws RemoteException {
            return System.currentTimeMillis();
        }

        @Override
        public long getStart() throws RemoteException {
            return intentStartTime;
        }

        @Override
        public long getIntentReceived() throws RemoteException {
            return intentReceived;
        }

        @Override
        public int getMode() throws RemoteException {
            return mode;
        }

        @Override
        public int getNTests() throws RemoteException {
            return total;
        }
    };
}
