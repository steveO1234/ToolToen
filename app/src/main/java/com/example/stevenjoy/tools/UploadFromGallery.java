package com.example.stevenjoy.tools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class UploadFromGallery extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_from_gallery);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_CODE);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case REQUEST_CODE:
                    if (resultCode == UploadFromGallery.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        break;
                    } else if (resultCode == UploadFromGallery.RESULT_CANCELED) {
                        Log.e("TAG", "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e("TAG", "Exception in onActivityResult : " + e.getMessage());
        }
    }
}
