package com.example.networkconnectivityapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Inject
    NetworkConnectivity networkConnectivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called whenever a certain button from the UI is clicked
    public void internetCheckBtnClicked(View view) {
        networkConnectivity.checkInternetConnection((isConnected) ->
                Toast.makeText(this, isConnected + "", Toast.LENGTH_SHORT).show()
        );
    }
}
