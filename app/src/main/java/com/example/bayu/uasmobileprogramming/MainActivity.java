package com.example.bayu.uasmobileprogramming;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    EditText etNis, etNama, etAlamat;
    Button btnKirim;
    RadioGroup radioGroup;
    CheckBox cbBi, cbMtk, cbFis, cbKim, cbBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNis = (EditText) findViewById(R.id.etNis);
        etNama = (EditText) findViewById(R.id.etNama);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        btnKirim = (Button) findViewById(R.id.btnKirim);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        cbBi = (CheckBox) findViewById(R.id.cbBI);
        cbMtk = (CheckBox) findViewById(R.id.cbMTK);
        cbFis = (CheckBox) findViewById(R.id.cbFIS);
        cbKim = (CheckBox) findViewById(R.id.cbKIM);
        cbBio = (CheckBox) findViewById(R.id.cbBIO);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nis = " NIS : " + etNis.getText();
                String nama = "\nNama : " + etNama.getText();
                String alamat = "\nAlamat : " + etAlamat.getText();
                String jk = "\nJenis Kelamin : ";
                String mapel = "\nMata pelajaran yang diambil : ";

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rbLk:
                        jk = jk + "Laki-laki";
                        break;
                    case R.id.rbPr:
                        jk = jk + "Perempuan";
                        break;
                }

                if (cbBi.isChecked()){
                    mapel = mapel + "\nBahasa Indonesia";
                } if (cbMtk.isChecked()){
                    mapel = mapel + "\nMatematika";
                } if (cbFis.isChecked()){
                    mapel = mapel + "\nFisika";
                } if (cbKim.isChecked()){
                    mapel = mapel + "\nKimia";
                } if (cbBio.isChecked()){
                    mapel = mapel + "\nBiologi";
                }

                if (etNis.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Mohon Nis diisi terlebih dahulu", Toast.LENGTH_LONG).show();
                } else if (etNama.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Mohon Nama diisi terlebih dahulu", Toast.LENGTH_LONG).show();
                } else if (etAlamat.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Mohon Alamat diisi terlebih dahulu", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(MainActivity.this, ParsingDataActivity.class);
                    Bundle b = new Bundle();
                    b.putString("nis", nis);
                    b.putString("nama", nama);
                    b.putString("alamat", alamat);
                    b.putString("jk", jk);
                    b.putString("mapel", mapel);
                    Toast.makeText(getApplicationContext(), nis + nama + alamat + jk + mapel , Toast.LENGTH_LONG).show();
                    i.putExtras(b);
                    finish();
                    startActivity(i);
                }
            }
        });
    }
}
