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
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final ServiceInterface.Stub binder = new ServiceInterface.Stub() {

        @Override
        public long getCallTime(long start, int mode, int n_tests) throws RemoteException {
            return System.currentTimeMillis();
        }
    };
}
