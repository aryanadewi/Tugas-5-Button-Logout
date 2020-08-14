package com.aryanadewi_tugaspraktikum.myactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnexit;
    private EditText phoneNumber;
    private EditText websiteUri;
    private EditText locationUri;
    private EditText textshare;
    Button buttonWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = findViewById(R.id.edtPhoneNumber);
        websiteUri = findViewById(R.id.edtWebsiteUri);
        locationUri = findViewById(R.id.edtLocationUri);
        textshare = findViewById(R.id.edtShareText);
        buttonWebsite = findViewById(R.id.btnWebsiteUri);
        buttonWebsite.setOnClickListener(this);
        buttonWebsite = findViewById(R.id.btnLocationUri);
        buttonWebsite.setOnClickListener(this);
        buttonWebsite = findViewById(R.id.btnShareText);
        buttonWebsite.setOnClickListener(this);

        btnexit = (Button)findViewById(R.id.buttonexit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    //            moveTaskBack(true);
                finish();
                System.exit(0);
            }
        });
        }
    }

    public void openDialPhone(View view) {
        Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber.getText().toString()));
        startActivity(dialPhone);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPhoneNumber:
                Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + phoneNumber.getText().toString()));
                startActivity(dialPhone);
                break;
            case R.id.btnWebsiteUri:
                Intent openWebsite = new
                        Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://" + websiteUri.getText().toString()));
                startActivity(openWebsite);
                break;
            case R.id.btnLocationUri:
                Intent openLocation = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,O?q=" +
                        locationUri.getText().toString()));
                startActivity(openLocation);
                break;
            case R.id.btnShareText:
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType("text/plan")
                        .setChooserTitle("Share this text with : ")
                        .setText(textshare.getText().toString())
                        .startChooser();
                break;
        }
    }

}