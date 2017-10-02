package it.neslab.intentreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class IntentReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long t = System.currentTimeMillis();
        Intent i = getIntent();

        if(i.getLongExtra("starting", 0)!=0) {
            Intent retVal = new Intent();
            retVal.putExtra("starting", i.getLongExtra("starting", 0));
            retVal.putExtra("receive", t);
            retVal.putExtra("n_tests", i.getIntExtra("n_tests", 0));
            setResult(RESULT_OK, retVal);
            finish();
        }

        setContentView(R.layout.activity_intent_receiver);
    }

}
