package com.mark.demo.androidwifidemo;

import java.util.List;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class WifiScannerActivityDemo extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_scanner_activity_demo);
        
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> networkList = null;
        networkList = wifi.getScanResults();
        
        final TextView textView = (TextView) findViewById(R.id.wifilist);
        
        for (ScanResult network : networkList)
        {
            String Capabilities =  network.capabilities;        
            textView.append("SSID Name: \n" + network.SSID + "\nSSID Security Capabilities : \n" + Capabilities + "\n\n");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wifi_scanner_activity_demo, menu);
        return true;
    }
    
}
