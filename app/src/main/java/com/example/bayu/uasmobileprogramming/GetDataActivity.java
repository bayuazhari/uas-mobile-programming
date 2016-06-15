package com.example.bayu.uasmobileprogramming;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GetDataActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        Bundle b = getIntent().getExtras();

        TextView tvAlas = (TextView) findViewById(R.id.tvAlas);
        TextView tvTinggi = (TextView) findViewById(R.id.tvTinggi);

        tvAlas.setText(b.getCharSequence("alas"));
        tvTinggi.setText(b.getCharSequence("tinggi"));

        TextView tvLuas = (TextView) findViewById(R.id.tvLuas);
        double angkaAlas = Double.parseDouble(b.getString("bilAlas"));
        double angkaTinggi = Double.parseDouble(b.getString("bilTinggi"));
        tvLuas.setText(String.valueOf("\nLuas : " + (angkaAlas / 2) * angkaTinggi));
    }
}
