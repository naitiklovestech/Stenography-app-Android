package com.example.imgstenography;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button enc,dec,abt;
    ViewFlipper vf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        enc = findViewById(R.id.encd);
        dec = findViewById(R.id.decd);

        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(MainActivity.this, Encoder.class);
                startActivity(temp);
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(MainActivity.this, Decoder.class);
                startActivity(temp);
            }
        });

        vf = findViewById(R.id.vf);
        int images[] = {R.drawable.bellaso_cipher, R.drawable.caesar_cipher_encryption, R.drawable.dorabella_cipher};

        for(int i=0; i<images.length; i++){
            flipper(images[i]);
        }
    }

    public void flipper(int images){

        ImageView test = new ImageView(this);
        test.setBackgroundResource(images);
        vf.addView(test);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}