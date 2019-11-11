package com.summa.hitungmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HitungHitungDuit extends AppCompatActivity {

    //buat variable global
    EditText editNilaiPertama, editNilaiKedua;
    Button btnHitung;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //panggil view
        setContentView(R.layout.activity_hitung_hitung_duit);

        //inisialisasi
        editNilaiPertama = (EditText) findViewById(R.id.editNilaiPertama);
        editNilaiKedua = (EditText) findViewById(R.id.editNilaiKedua);
        btnHitung = (Button) findViewById(R.id.btnHitung);
        tvHasil = (TextView) findViewById(R.id.tvHasil);

        //listener button
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HitungHitungDuitGakAda();
            }
        });

    }

    private void HitungHitungDuitGakAda() {

        //buat variable untruk ambil nilai di edittext
        String ambilNilaipertama = editNilaiPertama.getText().toString();
        String ambilNilaikedua = editNilaiKedua.getText().toString();

        //validasi klo ada kolom text yang belum diisi
        if (ambilNilaipertama.isEmpty() || ambilNilaikedua.isEmpty()){
            Toast.makeText(this, "masih kosong oy nilainya",Toast.LENGTH_SHORT).show();
        } else {

            //perhitungannya
            //klo pake double
            //Double hasil = Double.valueOf(ambilNilaipertama) + Double.valueOf(ambilNilaikedua);
            //tvHasil.setText("Hasilnya adalah "+hasil);

            //kalo pake integer
            //int hasil = Integer.parseInt(ambilNilaipertama) + Integer.parseInt(ambilNilaikedua);
            //tvHasil.setText("Hasilnya adalah "+hasil);

            //kalo pake long
            Long hasil = Long.parseLong(ambilNilaipertama) + Long.parseLong(ambilNilaikedua);
            tvHasil.setText("Hasilnya adalah " + hasil);

            //dialog (kayak popup)
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            //atribut tittle dan message
            alertDialog.setTitle("Hasil dari penjumlahan");
            alertDialog.setMessage("Hasilnya adalah : "+hasil);
            //alertDialog.show(); atau ini bisa di taruh di bawah jika di dialog mau ditambah tombol klik ok untuk nutup

            //pas udh muncul dialog harus klik ok, klo ngga di pencet ga bisa keluar
            alertDialog.setCancelable(false);

            //munculin tombol ok
            //positif button ada paramater ("nama button", listener)
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editNilaiPertama.setText("");
                    editNilaiKedua.setText("");
                }
            });
            alertDialog.setNegativeButton("Search", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //intrnt pindah activity
                    //punya 2 paramster (context/activity dia berasal, pindah kemana?)

                    Intent pindahKeactivityLain = new Intent(HitungHitungDuit.this,WebViewActivity.class);
                    //di start or mulai
                    startActivity(pindahKeactivityLain);

                }
            });

            alertDialog.show();
        }


    }
}
