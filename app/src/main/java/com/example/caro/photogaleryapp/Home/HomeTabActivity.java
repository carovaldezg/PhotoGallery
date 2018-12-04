package com.example.caro.photogaleryapp.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.caro.photogaleryapp.R;

public class HomeTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HomeTabFragment())
                .commit();
    }

}
