package com.lctec.kaoruartgalleryandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        // LC TECH footer
        TextView textView = (TextView)findViewById(R.id.footertextview);
        // © 2022 - Developed by
        Spannable developedBy = new SpannableString("© 2022 - Developed by ");
        developedBy.setSpan(new ForegroundColorSpan(Color.rgb(203,255,255)), 0, developedBy.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(developedBy);

        // LC Technologies
        Spannable lctec = new SpannableString("LC Technologies");
        // turn this to link
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                String lctecsite = "https://lctechnologies.azurewebsites.net/";
                Uri uri = Uri.parse(lctecsite);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        lctec.setSpan(clickableSpan, 0, lctec.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        lctec.setSpan(new ForegroundColorSpan(Color.rgb(255,228,196)), 0, lctec.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.append(lctec);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        // - Jesus Christ is King
        Spannable jesuschristisking = new SpannableString(" - Jesus Christ is King");
        jesuschristisking.setSpan(new ForegroundColorSpan(Color.rgb(203,255,255)), 0, jesuschristisking.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.append(jesuschristisking);

        //    button
        Button btn = findViewById(R.id.gallerybtn);
        btn.setOnClickListener(v -> {
            String kagurl = "https://kaoruartgallery.com/gallery/";
            Uri uri = Uri.parse(kagurl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}