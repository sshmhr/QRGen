package com.example.hp.qrgen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class qrScanner extends AppCompatActivity {
    private IntentIntegrator qrScan;
    private TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);
        qrScan = new IntentIntegrator(this);
        qrScan.initiateScan();
        textViewName = findViewById(R.id.textView2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                String obj = result.getContents();
                textViewName.setText(obj);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
