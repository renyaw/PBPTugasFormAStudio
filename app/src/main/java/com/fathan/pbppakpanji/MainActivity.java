package com.fathan.pbppakpanji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_send;
    EditText inp_nama,inp_tempat, inp_tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mengambil id elemen dari pada view
        btn_send = findViewById(R.id.button);
        inp_nama = findViewById(R.id.nama);
        inp_tempat = findViewById(R.id.tempat);
        inp_tanggal = findViewById(R.id.tanggal);
        //mengirim array list melalui intent
        ArrayList<String> new_data_nama = getIntent().getStringArrayListExtra("new_datas1");
        ArrayList<String> new_data_tempat = getIntent().getStringArrayListExtra("new_datas2");
        ArrayList<String> new_data_tanggal = getIntent().getStringArrayListExtra("new_datas3");
        //membuat array list bernama data_nama,data_tempat dan data_tanggal yang akan menyimpan string
        ArrayList<String> data_nama = new ArrayList<>();
        ArrayList<String> data_tempat = new ArrayList<>();
        ArrayList<String> data_tanggal = new ArrayList<>();

        //memasukan nilai yang dimasukan pada data_nama, data_tempat dan data_tanggal
        if(new_data_nama!=null){
            for(int i=0;i<new_data_nama.size();i++){
                data_nama.add(new_data_nama.get(i));
                data_tempat.add(new_data_tempat.get(i));
                data_tanggal.add(new_data_tanggal.get(i));
            }
        }

        //mengatur tombol
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memasukan inputan ke string data_nama, data_tempat dan data_tanggal dalam bentuk string
                data_nama.add(inp_nama.getText().toString());
                data_tempat.add(inp_tempat.getText().toString());
                data_tanggal.add(inp_tanggal.getText().toString());
                //deklarasi intent ke activity selanjutnya
                Intent intent = new Intent(getApplicationContext(),pageActivity2.class);
                //memasukkan array list kedalam
                intent.putStringArrayListExtra("datas1",data_nama);
                intent.putStringArrayListExtra("datas2",data_tempat);
                intent.putStringArrayListExtra("datas3",data_tanggal);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(),"Home dipause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(),"Home diteruskan", Toast.LENGTH_SHORT).show();
        super.onResume();
    }
}