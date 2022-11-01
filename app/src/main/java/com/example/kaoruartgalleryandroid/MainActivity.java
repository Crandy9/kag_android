package com.example.kaoruartgalleryandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title bar
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){return;}
        setContentView(R.layout.activity_main);
        //    button
        Button btn = findViewById(R.id.gallerybtn);
        btn.setOnClickListener(v -> {
            String kagurl = "https://kaoruartgallery.com";
            if (kagurl.startsWith("https://") || kagurl.startsWith("http://")) {
                Uri uri = Uri.parse(kagurl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Invalid URL",Toast.LENGTH_SHORT).show();
            }
        });
    }
}