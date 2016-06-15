package com.example.bayu.uasmobileprogramming;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParsingDataActivity extends ActionBarActivity {
    TextView tvNis, tvNama, tvAlamat, tvJk, tvMatkul;
    EditText etAlas, etTinggi;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_data);

        Bundle b = getIntent().getExtras();

        tvNis = (TextView) findViewById(R.id.txtNis);
        tvNama = (TextView) findViewById(R.id.txtNama);
        tvAlamat = (TextView) findViewById(R.id.txtAlamat);
        tvJk = (TextView) findViewById(R.id.txtJK);
        tvMatkul = (TextView) findViewById(R.id.txtMatkul);
        etAlas = (EditText) findViewById(R.id.etAlas);
        etTinggi = (EditText) findViewById(R.id.etTinggi);
        btnHitung = (Button) findViewById(R.id.button);

        tvNis.setText(b.getCharSequence("nis"));
        tvNama.setText(b.getCharSequence("nama"));
        tvAlamat.setText(b.getCharSequence("alamat"));
        tvJk.setText(b.getCharSequence("jk"));
        tvMatkul.setText(b.getCharSequence("mapel"));

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alas = " Alas : " + etAlas.getText();
                String tinggi = "\nTinggi : " + etTinggi.getText();

                if (etAlas.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Mohon Alas diisi terlebih dahulu", Toast.LENGTH_LONG).show();
                } else if (etTinggi.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Mohon Tinggi diisi terlebih dahulu", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(ParsingDataActivity.this, GetDataActivity.class);
                    Bundle b = new Bundle();
                    b.putString("alas", alas);
                    b.putString("tinggi", tinggi);
                    b.putString("bilAlas", etAlas.getText().toString());
                    b.putString("bilTinggi", etTinggi.getText().toString());
                    Toast.makeText(getApplicationContext(), alas + tinggi, Toast.LENGTH_LONG).show();
                    i.putExtras(b);
                    finish();
                    startActivity(i);
                }
            }
        });
    }
}
