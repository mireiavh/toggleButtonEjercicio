package com.example.togglebuttonejercicio;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ImageView imageView;

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

        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView);

        setImgVisible();
    }

    public void setImgVisible(){
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleButton.setTextOn(getString(R.string.tb_enable));
                imageView.setImageResource(R.drawable.shrek);
                imageView.setVisibility(View.VISIBLE);
            } else {
                toggleButton.setTextOff(getString(R.string.tb_unenable));
                imageView.setVisibility(View.GONE);
            }
        });
    }

}