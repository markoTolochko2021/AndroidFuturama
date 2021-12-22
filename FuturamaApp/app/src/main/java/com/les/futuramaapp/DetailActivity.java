package com.les.futuramaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHARTYPE_ID = "characterType";


    public static final String EXTRA_ROBOT_ID = "robotId";
    public static final String EXTRA_HUMAN_ID = "humanId";
    public static final String EXTRA_MUTANT_ID = "mutantId";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int characterType = (int) getIntent().getExtras().get(EXTRA_CHARTYPE_ID);


        switch (characterType){
            case 1:
                int robotId = (int) getIntent().getExtras().get(EXTRA_ROBOT_ID);

                String robotName = FuturamaCharacters.robotCharacters[robotId].getName();
                TextView robotText = (TextView) findViewById(R.id.text_character);
                robotText.setText(robotName);

                int robotImage = FuturamaCharacters.robotCharacters[robotId].getImageResourcesId();
                ImageView robotImgView = (ImageView) findViewById(R.id.image_character);
                robotImgView.setImageDrawable(ContextCompat.getDrawable(this, robotImage));

                break;

            case 2:
                int mutantId = (int) getIntent().getExtras().get(EXTRA_MUTANT_ID);

                String mutantName = FuturamaCharacters.mutantCharacters[mutantId].getName();
                TextView mutantText = (TextView) findViewById(R.id.text_character);
                mutantText.setText(mutantName);

                int mutantImage = FuturamaCharacters.mutantCharacters[mutantId].getImageResourcesId();
                ImageView mutantImgView = (ImageView) findViewById(R.id.image_character);
                mutantImgView.setImageDrawable(ContextCompat.getDrawable(this, mutantImage));

                break;

            case 3:
                int humanId = (int) getIntent().getExtras().get(EXTRA_HUMAN_ID);

                String humanName = FuturamaCharacters.humanCharacters[humanId].getName();
                TextView humanText = (TextView) findViewById(R.id.text_character);
                humanText.setText(humanName);

                int humanImage = FuturamaCharacters.humanCharacters[humanId].getImageResourcesId();
                ImageView humanImgView = (ImageView) findViewById(R.id.image_character);
                humanImgView.setImageDrawable(ContextCompat.getDrawable(this, humanImage));

                break;
        }

    }
}