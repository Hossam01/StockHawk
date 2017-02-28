package com.udacity.stockhawk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.stockhawk.R;
import com.udacity.stockhawk.data.Contract;

import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {



    String symbol;
    TextView tvStockSymbol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        if (intent.hasExtra("SYMBOL")) {
            symbol = intent.getStringExtra("SYMBOL");
            tvStockSymbol = (TextView) findViewById(R.id.TextView);
            tvStockSymbol.setText(symbol);
        }

        Picasso.with(getApplicationContext()).load("http://chart.finance.yahoo.com/t?s="+symbol+"&lang=en-US&width=512&height=288").into(imageView);

    }
}
