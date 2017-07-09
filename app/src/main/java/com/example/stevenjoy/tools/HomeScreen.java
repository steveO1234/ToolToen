package com.example.stevenjoy.tools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class HomeScreen extends AppCompatActivity {

    private Button personalAccount;
    private Button businessAccount;
    private Button tempButton;


    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        personalAccount = (Button) findViewById(R.id.personal_button);
        businessAccount = (Button) findViewById(R.id.business_button);
        tempButton = (Button) findViewById(R.id.temp_button);


        personalAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeScreen.this, SignupActivity.class));
            }
        });


        businessAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeScreen.this, BusinessSignupActivity.class));
            }
        });

        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomeScreen.this, UploadFromGallery.class));
            }
        });

    }
}