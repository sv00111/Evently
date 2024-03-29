package com.example.shreyvalia.evently;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


public class detailPhoto extends AppCompatActivity {

    private Button cameraButton;
    private ImageView imageView;
    static final int CAM_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
        cameraButton = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.image_view);
        cameraButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View i) {

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);

            }
        });

    }



//    public void onCreateImages (Bundle savedInstanceState) {
//
//    }


    private File getFile() {

        File folder = new File ("sdcard/camera_app");

        if(!folder.exists()) {
            folder.mkdir();
        }

        File image_file = new File(folder, "cam_image.jpg");
        return image_file;


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));

    }

}
