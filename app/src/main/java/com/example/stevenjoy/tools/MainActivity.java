package com.example.stevenjoy.tools;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    EditText username, password;
    private View sign_up;
    public static final int REQUEST_SIGNUP=0;

   // TextView tx1;
    int counter = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sign_up =  findViewById(R.id.account_SignUp);  /** created for create signup finish manana*/
        sign_up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//
//                Intent intent = new Intent(MainActivity.this, SignupActivity.class);  // create activity for signup
//                MainActivity.this.startActivity(intent);

                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);  // create activity for signup
                startActivityForResult(intent,REQUEST_SIGNUP);

            }
        });

        b1 = (Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

        b2 = (Button) findViewById(R.id.button2);
        //tx1 = (TextView)findViewById(R.id.textView3);
        //tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    Log.d("whoa", username.getText().toString());
                    Log.d("whoa2", password.getText().toString());

                    //tx1.setVisibility(View.VISIBLE);
                    //tx1.setBackgroundColor(Color.RED);
                    counter--;
                    //tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Log.d("WHOA", "You fuckin passed broski");
            //correcct password
        } else {
            Log.d("WHOA", "You fuckin suck");
        }


    }
}