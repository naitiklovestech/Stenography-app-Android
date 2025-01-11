package com.example.imgstenography;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Encoder extends AppCompatActivity {

    EditText etenc;
    TextView enctv;
    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_encoder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etenc = findViewById(R.id.etenc);
        enctv = findViewById(R.id.enctv);
        cpb =(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

    }

    public void enc(View view){

        String temp = etenc.getText().toString();
        String rv = encode.enc(temp);
        enctv.setText(rv);
    }

    public void cp2(View view){

        String data = enctv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text", data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this,"Copied", Toast.LENGTH_LONG).show();

        }
    }
}