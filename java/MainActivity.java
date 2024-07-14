package com.example.possiblegenes;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ImageView maleImage, femImage, babyImage, fiftyImage1, fiftyImage2, reImg1, reImg2,reImg3;
    private TextView mainText, splitText1, splitText2, remainderText;
    private String femEye;
    private String maleEye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleImage = findViewById(R.id.maleImage);
        femImage = findViewById(R.id.femImage);
        babyImage = findViewById(R.id.babyImage);
        fiftyImage1 = findViewById(R.id.fiftyImage1);
        fiftyImage2 = findViewById(R.id.fiftyImage2);
        reImg1 = findViewById(R.id.remainderImage1);
        reImg2 = findViewById(R.id.remainderImage2);
        reImg3 = findViewById(R.id.remainderImage3);

        mainText = findViewById(R.id.mainText);
        splitText1 = findViewById(R.id.splitText1);
        splitText2 = findViewById(R.id.splitText2);
        remainderText = findViewById(R.id.remainderText);

        femEye = "Brown";
        maleEye = "Brown";

        calculateProb();

        maleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(v);
            }
        });

        femImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(v);
            }
        });
    }
    public void calculateProb(){
        Probability prob = new Probability();
        double[] vals = prob.calculateProb(maleEye,femEye);
        if(vals[0] > vals[1] && vals[0] > vals[2]){
            babyImage.setImageResource(R.drawable.brownbaby);
            reImg2.setImageResource(R.drawable.greenbaby);
            reImg3.setImageResource(R.drawable.bluebaby);

            babyImage.setVisibility(View.VISIBLE);
            reImg2.setVisibility(View.VISIBLE);
            reImg3.setVisibility(View.VISIBLE);
            splitText1.setVisibility(View.VISIBLE);
            splitText2.setVisibility(View.VISIBLE);

            fiftyImage1.setVisibility(View.INVISIBLE);
            fiftyImage2.setVisibility(View.INVISIBLE);
            reImg1.setVisibility(View.INVISIBLE);
            remainderText.setVisibility(View.INVISIBLE);

            mainText.setText(String.format("Brown = %s%%", vals[0]));
            splitText1.setText(String.format("Green = %s%%", vals[1]));
            splitText2.setText(String.format("Blue = %s%%", vals[2]));
        } else if (vals[1] > vals[0] && vals[1] > vals[2]) {
            babyImage.setImageResource(R.drawable.greenbaby);
            reImg2.setImageResource(R.drawable.brownbaby);
            reImg3.setImageResource(R.drawable.bluebaby);

            babyImage.setVisibility(View.VISIBLE);
            reImg2.setVisibility(View.VISIBLE);
            reImg3.setVisibility(View.VISIBLE);
            splitText1.setVisibility(View.VISIBLE);
            splitText2.setVisibility(View.VISIBLE);

            fiftyImage1.setVisibility(View.INVISIBLE);
            fiftyImage2.setVisibility(View.INVISIBLE);
            reImg1.setVisibility(View.INVISIBLE);
            remainderText.setVisibility(View.INVISIBLE);

            mainText.setText(String.format("Green = %s%%", vals[1]));
            splitText1.setText(String.format("Brown = %s%%", vals[0]));
            splitText2.setText(String.format("Blue = %s%%", vals[2]));
        }else if (vals[2] > vals[0] && vals[2] > vals[1]) {
            babyImage.setImageResource(R.drawable.bluebaby);
            reImg2.setImageResource(R.drawable.brownbaby);
            reImg3.setImageResource(R.drawable.greenbaby);

            babyImage.setVisibility(View.VISIBLE);
            reImg2.setVisibility(View.VISIBLE);
            reImg3.setVisibility(View.VISIBLE);
            splitText1.setVisibility(View.VISIBLE);
            splitText2.setVisibility(View.VISIBLE);

            fiftyImage1.setVisibility(View.INVISIBLE);
            fiftyImage2.setVisibility(View.INVISIBLE);
            reImg1.setVisibility(View.INVISIBLE);
            remainderText.setVisibility(View.INVISIBLE);

            mainText.setText(String.format("Blue = %s%%", vals[2]));
            splitText1.setText(String.format("Brown = %s%%", vals[0]));
            splitText2.setText(String.format("Green = %s%%", vals[1]));
        }else if (vals[0] == vals[1]) {
            fiftyImage1.setImageResource(R.drawable.brownbaby);
            fiftyImage2.setImageResource(R.drawable.greenbaby);
            reImg1.setImageResource(R.drawable.bluebaby);

            fiftyImage1.setVisibility(View.VISIBLE);
            fiftyImage2.setVisibility(View.VISIBLE);
            reImg1.setVisibility(View.VISIBLE);
            remainderText.setVisibility(View.VISIBLE);

            babyImage.setVisibility(View.INVISIBLE);
            reImg2.setVisibility(View.INVISIBLE);
            reImg3.setVisibility(View.INVISIBLE);
            splitText1.setVisibility(View.INVISIBLE);
            splitText2.setVisibility(View.INVISIBLE);

            mainText.setText(R.string.fiftysplity);
            remainderText.setText(String.format("Blue = %s%%", vals[2]));
        }else if (vals[0] == vals[2]) {
            fiftyImage1.setImageResource(R.drawable.brownbaby);
            fiftyImage2.setImageResource(R.drawable.bluebaby);
            reImg1.setImageResource(R.drawable.greenbaby);

            fiftyImage1.setVisibility(View.VISIBLE);
            fiftyImage2.setVisibility(View.VISIBLE);
            reImg1.setVisibility(View.VISIBLE);
            remainderText.setVisibility(View.VISIBLE);

            babyImage.setVisibility(View.INVISIBLE);
            reImg2.setVisibility(View.INVISIBLE);
            reImg3.setVisibility(View.INVISIBLE);
            splitText1.setVisibility(View.INVISIBLE);
            splitText2.setVisibility(View.INVISIBLE);

            mainText.setText(R.string.fiftysplity);
            remainderText.setText(String.format("Green = %s%%", vals[1]));
        }else if (vals[1] == vals[2]) {
            fiftyImage1.setImageResource(R.drawable.greenbaby);
            fiftyImage2.setImageResource(R.drawable.bluebaby);
            reImg1.setImageResource(R.drawable.brownbaby);

            fiftyImage1.setVisibility(View.VISIBLE);
            fiftyImage2.setVisibility(View.VISIBLE);
            reImg1.setVisibility(View.VISIBLE);
            remainderText.setVisibility(View.VISIBLE);

            babyImage.setVisibility(View.INVISIBLE);
            reImg2.setVisibility(View.INVISIBLE);
            reImg3.setVisibility(View.INVISIBLE);
            splitText1.setVisibility(View.INVISIBLE);
            splitText2.setVisibility(View.INVISIBLE);

            mainText.setText(R.string.fiftysplity);
            remainderText.setText(String.format("Brown = %s%%", vals[0]));
        }
    }
    public void changeImage(View view) {
        if (view.getId() == R.id.femImage) {
            if(femEye.equals("Brown")){
                femImage.setImageResource(R.drawable.femblue);
                femEye = "Blue";
                calculateProb();
            } else if (femEye.equals("Blue")) {
                femImage.setImageResource(R.drawable.femgreen);
                femEye = "Green";
                calculateProb();
            }else{
                femImage.setImageResource(R.drawable.fembrown);
                femEye = "Brown";
                calculateProb();
            }
        } else if (view.getId() == R.id.maleImage) {
            if(maleEye.equals("Brown")){
                maleImage.setImageResource(R.drawable.maleblue);
                maleEye = "Blue";
                calculateProb();
            } else if (maleEye.equals("Blue")) {
                maleImage.setImageResource(R.drawable.malegreen);
                maleEye = "Green";
                calculateProb();
            }else{
                maleImage.setImageResource(R.drawable.malebrown);
                maleEye = "Brown";
                calculateProb();
            }
        }
    }
}
