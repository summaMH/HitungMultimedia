package com.summa.hitungmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG", "ïni oncreate method");
        //nampilin toast
        Toast.makeText(this, "ini dipakein Toast, jadi tidak tertampil di logcat error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //nampilin log
        Log.e("TAG", "ini onestart method, ketika nyalain appnya");

        //bikin method, merah dikanan di klik, pilih create
        hitungduit();

    }

    private void hitungduit() {
        //buat variable duit saya
        Double uangTransportHariIni = 25000.0;
        Double uangTransport3hari = 75000.0;
        Double hasilUangTransportSeluruhnya = uangTransportHariIni + uangTransport3hari;

        Toast.makeText(this, "hasil uang transport sebesar: Rp" + hasilUangTransportSeluruhnya, Toast.LENGTH_SHORT).show();
        TextView tvUang = (TextView) findViewById(R.id.tv_uang);
        tvUang.setText("Hasil uang transport sebesar Rp "+hasilUangTransportSeluruhnya);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG","ini onResume method, melanjutkan atau memproses appnya");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG","ini onPause, ketika kita keluar dr appnya program yang sedang dijalankan akan di pause, atau saat sedang pindah ke aktivity lain");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG","ini onStop, berhenti karena buka app lain atau ke home");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG","ini onDestroy, keluar ( melalui tombol back) dari app");
    }
}
