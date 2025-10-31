package com.clipzen.pro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.clipzen.pro.MainActivity;
import com.clipzen.pro.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2800; // 2.8 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.logoImage);
        TextView appName = findViewById(R.id.appName);
        TextView tagline = findViewById(R.id.tagline);

        // Animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation taglineAnim = AnimationUtils.loadAnimation(this, R.anim.slide_up);

        // Start Animations
        logo.startAnimation(scaleUp);
        appName.startAnimation(fadeIn);
        tagline.startAnimation(taglineAnim);

        // Redirect to MainActivity
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }, SPLASH_DURATION);
    }
}
