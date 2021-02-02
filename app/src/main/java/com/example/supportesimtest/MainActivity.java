// created by bestphoneplans.com
package com.example.supportesimtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.euicc.EuiccInfo;
import android.telephony.euicc.EuiccManager;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    EuiccManager mgr;
    Context context;
    TextView myAwesomeTextView;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        myAwesomeTextView = (TextView)findViewById(R.id.textview_first);

            mgr = (EuiccManager) context.getSystemService(Context.EUICC_SERVICE);

        /* esim supported */
        boolean isEnabled = mgr.isEnabled();
        if (!isEnabled) {
            Log.d("test01","******    **** The device does NOT support ESIM ***   ***** ");
            myAwesomeTextView.setText("The device does NOT support ESIM");
            return;
        }

        myAwesomeTextView.setText("The device support ESIM");


    }
}
